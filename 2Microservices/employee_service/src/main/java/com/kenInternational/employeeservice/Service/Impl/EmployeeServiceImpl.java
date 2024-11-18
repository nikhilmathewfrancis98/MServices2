package com.kenInternational.employeeservice.Service.Impl;

//import com.kenInternational.employeeservice.Service.DepartmentProxy;
import com.kenInternational.employeeservice.Service.EmployeeService;
import com.kenInternational.employeeservice.dto.APIResponseDto;
import com.kenInternational.employeeservice.dto.DepartDto;
import com.kenInternational.employeeservice.dto.EmployeeDto;
import com.kenInternational.employeeservice.dto.OrganizationDto;
import com.kenInternational.employeeservice.entity.Employee;
import com.kenInternational.employeeservice.repository.EmployeeRepository;
//import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;


@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {
//    private static final Logger LOG = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    private final WebClient.Builder webClientBuilder;

    private final LoadBalancerClient loadBalancerClient;

//    @Autowired
//    public  EmployeeService(WebClient.Builder webClientBuilder, LoadBalancerClient loadBalancerClient) {
//        this.webClientBuilder = webClientBuilder;
//        this.loadBalancerClient = loadBalancerClient;
//    }
    @Autowired
//    DepartmentProxy proxy;
    WebClient client;
//    RestTemplate restTemplate;
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    ModelMapper EmployeeMapper;

    @Autowired
    public EmployeeServiceImpl(WebClient.Builder webClientBuilder, LoadBalancerClient loadBalancerClient) {
        this.webClientBuilder = webClientBuilder;
        this.loadBalancerClient = loadBalancerClient;
    }

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.map(employeeDto,Employee.class);

        Employee saveDEmployee = employeeRepository.save(employee);

        EmployeeDto savedEmployeeDto = EmployeeMapper.map(saveDEmployee, EmployeeDto.class);

        return savedEmployeeDto;
    }

    /**
     * In the below method we are having an external calling to the department6 service so we
     * have to add the @CircuitBreaker here
     * @param employeeId
     * @return
     */
    @Override
//    @CircuitBreaker(name = "${spring.application.name}",fallbackMethod = "getDefaultDepartment")
    @Retry(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
    public APIResponseDto getEmployeeById(Long employeeId) {
        log.info("inside getEmployeeById() method");
        Employee saveDEmployee = employeeRepository.findById(employeeId).get();
//       DepartDto department= getDepartment(saveDEmployee.getDepartmentCode()).getBody();
        OrganizationDto organization = getorganization(saveDEmployee.getOrganizationCode());
        DepartDto department= getDepartment(saveDEmployee.getDepartmentCode());

        EmployeeDto savedEmployeeDto = EmployeeMapper.map(saveDEmployee, EmployeeDto.class);
        APIResponseDto x= APIResponseDto.builder().employee(savedEmployeeDto).department(department)
                .organization(organization).build();
        return x;

    }

    /**
     * The below method has the code for both the Rest Template and the Web Client
     * and also the Open Feign code using inside the Proxy Interface
     * @param department_code
     * @return
     */
    public DepartDto getDepartment(String department_code){
//        String uri="http://DEPARTMENT-SERVICE/api/departments/" +department_code;
//        HttpHeaders headers=new HttpHeaders();
//        headers.add("invocationFrom","Invoked Using REST Template");
//        restTemplate.exchange(uri,HttpMethod.GET,new HttpEntity<>(DepartDto.class,headers),DepartDto.class);
//        ResponseEntity<DepartDto> responseEntityDepartment=restTemplate.getForEntity(uri, DepartDto.class);
        // This will be the code that we have to give if we are using the web-client for load balancing
        // String uri="http://DEPARTMENT-SERVICE/api/departments/" +department_code; direct giving is error


//        ServiceInstance serviceInstance = loadBalancerClient.choose("DEPARTMENT-SERVICE");
//        String uri = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/api/departments/" + department_code;
//    Commenting the above code inorder to test the circuit breaker
//    As we need to stop dept_Service the above code can bring the error

        DepartDto res= client.get()
                  .uri("http://localhost:8084/api/departments/"+department_code)
                  .retrieve()
                  .bodyToMono(DepartDto.class)
                  .block();
//          proxy.getDepartment(department_code)
        return res;
    }

    /**
     * Getting the organization Details
     */
    public OrganizationDto  getorganization(String org_code){
        OrganizationDto res= client.get()
                .uri("http://localhost:8083/api/organizations/"+org_code)
                .retrieve()
                .bodyToMono(OrganizationDto.class)
                .block();
        return res;
    }

    /**
     * The belowi is the default department response if the external call to department fails
     * @return
     */
    public APIResponseDto getDefaultDepartment(Long employeeId,Exception exception) {
        log.info("inside getDefaultDepartment() method");
        Employee saveDEmployee = employeeRepository.findById(employeeId).get();
        DepartDto department=DepartDto.builder().id(000L).departmentCode("NA").
                departmentName("NA").departmentDescription("NA").build();
        EmployeeDto savedEmployeeDto = EmployeeMapper.map(saveDEmployee, EmployeeDto.class);
        APIResponseDto x= APIResponseDto.builder().employee(savedEmployeeDto).department(department).build();
        return x;

    }

}


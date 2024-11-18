import axios from 'axios';
import { environment} from '../Constants/environments';
import { AppConstants } from '../Constants/appconstants';

const EMPLOYEE_ID=2;

class EmployeeService{
  
    getEmployee(){
      // console.log(AppConstants.EMPLOYEE_SERVICE_BASE_URL);
      // console.log(environment.API_GATEWAY_ROOT_URL);
      return axios.get(environment.API_GATEWAY_ROOT_URL+""+AppConstants.EMPLOYEE_SERVICE_BASE_URL+"/"+EMPLOYEE_ID);
    }
    
}

export default new EmployeeService;

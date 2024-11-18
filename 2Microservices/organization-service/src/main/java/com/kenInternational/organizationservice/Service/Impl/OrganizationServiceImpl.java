package com.kenInternational.organizationservice.Service.Impl;

import com.kenInternational.organizationservice.DTO.OrganizationDto;
import com.kenInternational.organizationservice.Entity.Organization;
//import com.kenInternational.organizationservice.Mapper.MapperTo;
import com.kenInternational.organizationservice.Repository.OrganizationRepository;
import com.kenInternational.organizationservice.Service.OrganizationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class OrganizationServiceImpl implements OrganizationService {
    @Autowired
    OrganizationRepository repository;

//    @Autowired
//    MapperTo MapperObject ;
    private final ModelMapper modelMapper;

    @Autowired
    public OrganizationServiceImpl(@Qualifier("MapperObject") ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    @Override
    public OrganizationDto saveOrganization(OrganizationDto orgDto) {
//       Organization org= MapperObject.GetMapper().map(orgDto, Organization.class);
        Organization org= modelMapper.map(orgDto, Organization.class);

        Organization savOrg= repository.save(org);

        return modelMapper.map(savOrg,OrganizationDto.class);
    }

    @Override
    public OrganizationDto getOrganizationByCode(String organizationCode) {
//       repository.findAll().stream().map(Organization::getOrganizationName).forEach(System.out::println);
        Organization organization = repository.findByOrganizationCode(organizationCode);
        return modelMapper.map(organization,OrganizationDto.class);
    }
}

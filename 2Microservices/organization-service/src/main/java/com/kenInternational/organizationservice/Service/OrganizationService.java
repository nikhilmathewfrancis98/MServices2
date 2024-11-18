package com.kenInternational.organizationservice.Service;

import com.kenInternational.organizationservice.DTO.OrganizationDto;
import com.kenInternational.organizationservice.Entity.Organization;

public interface OrganizationService {
    OrganizationDto saveOrganization(OrganizationDto orgDto);
    OrganizationDto getOrganizationByCode(String organizationCode);

}

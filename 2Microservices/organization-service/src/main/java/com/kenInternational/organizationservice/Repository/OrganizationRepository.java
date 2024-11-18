package com.kenInternational.organizationservice.Repository;

import com.kenInternational.organizationservice.Entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationRepository extends JpaRepository<Organization,Long> {
    /**
     * The below is the organization query method since we are trying to add the custom fetching
     * @param organizationCode
     * @return
     */
    Organization findByOrganizationCode(String organizationCode);
}

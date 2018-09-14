package com.example.service;

import java.util.List;
import com.example.dto.ReturnValue;
import com.example.entity.Organization;
import com.example.utils.CustomException;

public interface OrganizationService {

  ReturnValue createOrganization(Organization organization) throws CustomException;

  ReturnValue updateOrganization(Organization organization) throws CustomException;

  ReturnValue deleteOrganization(Long organizationId) throws CustomException;

  Organization getOrganizationById(Long organizationId) throws CustomException;

  List<Organization> getAllOrganizations() throws CustomException;
}

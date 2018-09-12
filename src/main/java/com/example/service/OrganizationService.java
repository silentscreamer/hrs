package com.example.service;

import java.util.List;

import com.example.dto.ResultObject;
import com.example.entity.Organization;
import com.example.utils.CustomException;

public interface OrganizationService {

	ResultObject createOrganization(Organization organization) throws CustomException;

	ResultObject updateOrganization(Organization organization) throws CustomException;

	ResultObject deleteOrganization(Long organizationId) throws CustomException;

	Organization getOrganizationById(Long organizationId) throws CustomException;
	
	List<Organization> getAllOrganizations() throws CustomException;
}

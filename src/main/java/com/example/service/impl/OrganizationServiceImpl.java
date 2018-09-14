package com.example.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.constants.ResultCode;
import com.example.dto.ReturnValue;
import com.example.entity.Organization;
import com.example.repository.OrganizationRepository;
import com.example.service.OrganizationService;
import com.example.utils.CustomException;

@Service
public class OrganizationServiceImpl implements OrganizationService {

  @Autowired
  OrganizationRepository organizationRepository;

  @Override
  public ReturnValue createOrganization(Organization organization) throws CustomException {
    ReturnValue object = new ReturnValue(true, ResultCode.SUCCESS);
    object.getData().add(organizationRepository.save(organization));
    return object;
  }

  @Override
  public ReturnValue updateOrganization(Organization organization) throws CustomException {
    ReturnValue object = new ReturnValue(true, ResultCode.SUCCESS);
    if (getOrganizationById(organization.getId()) == null) {
      throw new CustomException(ResultCode.ORGANIZATION_DOES_NOT_EXIST);
    }
    organizationRepository.save(organization);
    return object;
  }

  @Override
  public ReturnValue deleteOrganization(Long organizationId) throws CustomException {
    ReturnValue object = new ReturnValue(true, ResultCode.SUCCESS);
    organizationRepository.deleteById(organizationId);
    return object;
  }

  @Override
  public Organization getOrganizationById(Long organizationId) throws CustomException {
    return organizationRepository.findById(organizationId).orElse(null);
  }

  @Override
  public List<Organization> getAllOrganizations() throws CustomException {
    return organizationRepository.findAll();
  }
}

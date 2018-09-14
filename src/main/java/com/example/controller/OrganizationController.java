package com.example.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.constants.ResultCode;
import com.example.dto.ResultObject;
import com.example.entity.Organization;
import com.example.service.OrganizationService;
import com.example.utils.CustomException;

@RestController
@RequestMapping("/organization")
public class OrganizationController {

	@Autowired
	OrganizationService organizationService;

	private static final Logger log = LoggerFactory.getLogger(OrganizationController.class);

	@PostMapping("/add")
	public ResultObject addOrganization(@Valid @RequestBody Organization organization) {
		ResultObject object;
		try {
			object = organizationService.createOrganization(organization);
		} catch (CustomException ce) {
			log.error("Custom Exception" + ce);
			return new ResultObject(false, ResultCode.ERROR);
		} catch (Exception e) {
			log.error("Exception", e);
			return new ResultObject(false, ResultCode.SYSTEM_ERROR);
		}
		return object;
	}

	@GetMapping("/all")
	public ResultObject getAllOrganizations() {
		ResultObject object = new ResultObject(true, ResultCode.SUCCESS);
		try {
			object.getData().addAll(organizationService.getAllOrganizations());
		} catch (CustomException ce) {
			log.error("Custom Exception" + ce);
			return new ResultObject(false, ResultCode.ERROR);
		} catch (Exception e) {
			log.error("Exception", e);
			return new ResultObject(false, ResultCode.SYSTEM_ERROR);
		}
		return object;
	}

	@GetMapping("/{id}")
	public ResultObject getOrganizationById(@PathVariable(value = "id") Long organizationId) {
		ResultObject object = new ResultObject(true, ResultCode.SUCCESS);
		try {
			object.getData().add(organizationService.getOrganizationById(organizationId));
		} catch (CustomException ce) {
			log.error("Custom Exception" + ce);
			return new ResultObject(false, ResultCode.ERROR);
		} catch (Exception e) {
			log.error("Exception", e);
			return new ResultObject(false, ResultCode.SYSTEM_ERROR);
		}
		return object;
	}

	@PutMapping("/{id}")
	public ResultObject updateOrganization(@PathVariable(value = "id") Long organizationId,
			@RequestBody Organization organization) {
		try {
			return organizationService.updateOrganization(organization);
		} catch (CustomException ce) {
			log.error("Custom Exception" + ce);
			return new ResultObject(false, ResultCode.ERROR);
		} catch (Exception e) {
			log.error("Exception", e);
			return new ResultObject(false, ResultCode.SYSTEM_ERROR);
		}
	}

	@DeleteMapping("{id}")
	public ResultObject deleteOrganization(@PathVariable(value = "id") Long organizationId) {
		try {
			return organizationService.deleteOrganization(organizationId);
		} catch (CustomException ce) {
			log.error("Custom Exception" + ce);
			return new ResultObject(false, ResultCode.ERROR);
		} catch (Exception e) {
			log.error("Exception", e);
			return new ResultObject(false, ResultCode.SYSTEM_ERROR);
		}
	}
}

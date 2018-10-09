package com.application.complaintbox.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.application.complaintbox.model.FormRequest;
import com.application.complaintbox.services.FormDataService;

@RestController
@RequestMapping(value = "/api/v1")
public class FormController {

	@Autowired
	private FormDataService formDataService;

	@RequestMapping(value = "/form", method = RequestMethod.POST, headers = "Accept=application/json", produces = {
			"application/json" })
	public Map<String, Object> savePost(Model model, @RequestBody FormRequest formRequest) {

		return formDataService.saveForm(formRequest);

	}

	@RequestMapping(value = "/form/{id}", method = RequestMethod.GET, headers = "Accept=application/json", produces = {
			"application/json" })
	public Map<String, Object> getPost(Model model, @PathVariable("id") String id) {

		return formDataService.getForm(id);
	}

}

package com.application.complaintbox.services;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.stereotype.Service;

import com.application.complaintbox.model.FormRequest;

@Service
public class FormDataService {

	private static Map<String, FormRequest> inmemoryMap = new TreeMap<>();

	private String status = "status";
	private String message = "message";
	private String statusSuccess = "success";
	private String statusError = "error";

	public Map<String, Object> getForm(String id) {

		Map<String, Object> returnMap = new HashMap<>();

		if (inmemoryMap.isEmpty()) {
			returnMap.put(status, statusSuccess);
			returnMap.put(message, "list is empty");
		} else if (inmemoryMap.get(id) != null) {
			returnMap.put(status, statusSuccess);
			returnMap.put(message, "list of stored form data");
			returnMap.put(id, inmemoryMap.get(id));
		} else {
			returnMap.put(status, statusError);
			returnMap.put(message, "no matching data");
		}

		return returnMap;

	}

	public Map<String, Object> saveForm(FormRequest formData) {

		Map<String, Object> returnMap = new HashMap<>();
		String id = formData.getId();
		try {
			inmemoryMap.computeIfAbsent(id, k -> formData);
		} catch (Exception e) {
			returnMap.put(status, statusError);
			returnMap.put(message, "error during map insert");
		}
		returnMap.put(status, statusSuccess);
		returnMap.put(message, "data added successfully");

		return returnMap;

	}

}

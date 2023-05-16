package com.example.jpp.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.jpp.services.EmployeeService;

import java.io.IOException;

@RestController
public class EmployeeController {
	private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/generateIdCards")
    public String generateIdCards(@RequestParam("csvFilePath") String csvFilePath) {
    	try {
    		employeeService.generateIdCards(csvFilePath);
    		return "ID cards generated successfully.";
    		} catch (IOException e) {
    		return "Error generating ID cards: " + e.getMessage();
    		}
    		}
}

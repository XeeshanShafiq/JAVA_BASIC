package com.test.soap.service;


import com.example.employee.EmployeeValidationRequest;
import com.example.employee.EmployeeValidationResponse;
import org.springframework.stereotype.Service;

@Service
public class EmployeeValidationService {

    public EmployeeValidationResponse validateEmployeeEmail(EmployeeValidationRequest request) {
        String email = request.getEmail();
        boolean isValid = isValidEmail(email);

        EmployeeValidationResponse response = new EmployeeValidationResponse();
        response.setIsValid(isValid);

        return response;
    }

    private boolean isValidEmail(String email) {
        return email != null;
    }
}
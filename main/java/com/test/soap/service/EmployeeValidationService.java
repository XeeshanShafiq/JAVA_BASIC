package com.test.soap.service;


import com.example.employee.EmployeeValidationRequest;
import com.example.employee.EmployeeValidationResponse;
import org.springframework.stereotype.Service;

@Service
public class EmployeeValidationService {


    public EmployeeValidationResponse validateEmployeeEmail(EmployeeValidationRequest request) {
        EmployeeValidationResponse response = new EmployeeValidationResponse();
        response.setTitle(checkExperience(request.getExperience()));
        String email = request.getEmail();
        boolean isValid = isValidEmail(email);
        response.setIsValid(isValid);
        return response;
    }

    private boolean isValidEmail(String email) {
        return email != null;
    }

    private String checkExperience(int experience){
        if (experience > 0 && experience <= 2) {
            return "The title for given experience is Intern";
        } else if (experience > 2 && experience <= 5) {
            return "The title for given experience is Developer";
        } else if (experience > 5) {
            return "The title for given experience is Lead";
        } else {
            return "Invalid Experience!!!! Please enter valid experience ";
        }
    }

}

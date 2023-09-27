package com.test.soap.endpoint;


import com.example.employee.EmployeeValidationRequest;
import com.example.employee.EmployeeValidationResponse;
import com.test.soap.service.EmployeeValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class EmployeeValidationEndpoint {

    private static final String NAMESPACE_URI = "http://example.com/employee";

    @Autowired
    private EmployeeValidationService validationService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "EmployeeValidationRequest")
    @ResponsePayload
    public EmployeeValidationResponse validateEmployeeEmail(@RequestPayload EmployeeValidationRequest request) {
        return validationService.validateEmployeeEmail(request);
    }
}
package com.dynatrace.requestattribute.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/user")
    public String getUser(
            @RequestHeader(value = "X-User-ID", required = false) Optional<String> userId,
            @RequestHeader(value = "X-Destination", required = false) Optional<String> destination,
            @RequestHeader(value = "X-Salary", required = false) Optional<String> salary) {

        // Log the request attributes
        logger.info("Captured Request Attributes - User ID: {}, Destination: {}, Salary: {}", 
                    userId.orElse("N/A"), destination.orElse("N/A"), salary.orElse("N/A"));

        // Prepare the response
        return String.format(
                "Captured Attributes:\nUser ID: %s\nDestination: %s\nSalary: %s",
                userId.orElse("User ID header is missing!"),
                destination.orElse("Destination header is missing!"),
                salary.orElse("Salary header is missing!")
        );
    }
    
    @GetMapping("/details")
    public String getDetails(
            @RequestHeader(value = "X-Contact", required = false) Optional<String> contactId,
            @RequestHeader(value = "X-Country", required = false) Optional<String> country,
            @RequestHeader(value = "X-Mobile", required = false) Optional<String> mobile) {

        // Log the request attributes
        logger.info("Captured Request Attributes - Contact ID: {}, Country: {}, Mobile: {}", 
        		contactId.orElse("N/A"), country.orElse("N/A"), mobile.orElse("N/A"));

        // Prepare the response
        return String.format(
                "Captured Attributes:\ncontact ID: %s\ncountry: %s\nmobile: %s",
                contactId.orElse("Contact Id header is missing!"),
                country.orElse("Country header is missing!"),
                mobile.orElse("Mobile header is missing!")
        );
    }
}
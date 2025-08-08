package com.verizon.sms.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Arrays;

@RestController
public class SmsController {
    @GetMapping("/sms")
    public List<String> messages() {
        return Arrays.asList("SMS to +91-99999", "SMS to +91-88888");
    }
}

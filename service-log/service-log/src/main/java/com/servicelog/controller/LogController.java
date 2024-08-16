package com.servicelog.controller;
import com.servicelog.dto.LogRequestDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping()
public class LogController {

    @PostMapping("/log")
    public void logRequest(@RequestBody LogRequestDto request) {
        System.out.println("Received request to log: " + request.getNumber());
    }
}
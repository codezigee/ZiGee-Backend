package academy.zigee.api.member.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
public class MemberController {

    @GetMapping("/")
    public Map<String, Object> home() {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "ZiGee Backend is running!");
        response.put("timestamp", LocalDateTime.now());
        response.put("version", "1.0.0");
        return response;
    }

    @GetMapping("/create")
    public Map<String, String> create() {
        Map<String, String> response = new HashMap<>();
        response.put("status", "UP");
        response.put("service", "ZiGee Backend");
        return response;
    }
}

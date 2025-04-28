package com.example.someting.controller;

import com.example.someting.model.DataCreateRequest;
import com.example.someting.service.DataService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/something")
public class DataController {
    private final DataService dataService;

//    @GetMapping("/new")
//    public String test() {
//        return "???";
//    }

    @PostMapping("/new")
    public String setData(@RequestBody DataCreateRequest request) {
        dataService.setData(request);

        return "Create";
    }
}

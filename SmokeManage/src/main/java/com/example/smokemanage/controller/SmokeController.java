package com.example.smokemanage.controller;

import com.example.smokemanage.entity.Smoke;
import com.example.smokemanage.model.SmokeCreateRequest;
import com.example.smokemanage.model.SmokeItems;
import com.example.smokemanage.model.SmokePatchRequest;
import com.example.smokemanage.service.SmokeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/smoke")
public class SmokeController {
    private final SmokeService smokeService;

    @PostMapping("/new")
    public String setSmoke(@RequestBody SmokeCreateRequest request) {
        smokeService.setSmoke(request);

        return "create";
    }

    @GetMapping("/all")
    public List<SmokeItems> getSmokes() {
        return smokeService.getSmokes();
    }

    @PatchMapping("/patch/{id}")
    public String putSmokeByCount(@PathVariable Long id, @RequestBody SmokePatchRequest request) {
        smokeService.putSmoke(id, request);
        return "patch";
    }

    @DeleteMapping("delete/{id}")
    public String delSmoke(@PathVariable Long id) {
        smokeService.delSmoke(id);

        return "delete";
    }
}

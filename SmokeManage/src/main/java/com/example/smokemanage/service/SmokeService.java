package com.example.smokemanage.service;

import com.example.smokemanage.entity.Smoke;
import com.example.smokemanage.model.SmokeCreateRequest;
import com.example.smokemanage.model.SmokeItems;
import com.example.smokemanage.model.SmokePatchRequest;
import com.example.smokemanage.repository.SmokeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SmokeService {
    private final SmokeRepository smokeRepository;

    public void setSmoke(SmokeCreateRequest request) {
        Smoke smoke = new Smoke();

        smoke.setTime(LocalDateTime.now());
        smoke.setCount(request.getCount());

        smokeRepository.save(smoke);
    }

    public List<SmokeItems> getSmokes() {
        List<Smoke> smokes = smokeRepository.findAll();
        List<SmokeItems> result = new LinkedList<>();

        smokes.forEach(item -> {
            SmokeItems smokeItems = new SmokeItems();

            smokeItems.setId(item.getId());
            smokeItems.setWarning(item.getTime() + " 때 " + item.getCount() + "개나 피우셨어요.");

            result.add(smokeItems);
        });

        return result;
    }

    public void putSmoke(Long id,SmokePatchRequest request) {
        Smoke smoke = smokeRepository.findById(id).orElseThrow();

        smoke.setCount(request.getCount());

        smokeRepository.save(smoke);
    }

    public void delSmoke(Long id) {
        smokeRepository.deleteById(id);
    }
}

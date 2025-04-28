package com.example.someting.service;

import com.example.someting.entity.Data;
import com.example.someting.model.DataCreateRequest;
import com.example.someting.model.DataItem;
import com.example.someting.repository.DataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DataService {
    private final DataRepository dataRepository;

    public void setData(DataCreateRequest request) {
        Data data = new Data();

        data.setName(request.getName());
        data.setAge(request.getAge());
        data.setShape(request.getShape());
        data.setColor(request.getColor());
        data.setDate(LocalDate.now());

        dataRepository.save(data);
    }

    public List<DataItem> getDatas () {
        List<Data> data = dataRepository.findAll();
        List<DataItem> result = new LinkedList<>();

        data.forEach((item) -> {
            DataItem dataItem = new DataItem();

            dataItem.setId(item.getId());
            dataItem.setReturnString(
                    ""
            );
            // result.add();
        });
    }
}

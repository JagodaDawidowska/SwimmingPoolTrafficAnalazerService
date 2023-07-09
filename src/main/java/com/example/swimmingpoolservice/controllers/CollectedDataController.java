package com.example.swimmingpoolservice.controllers;

import com.example.swimmingpoolservice.controllers.dto.CollectedDataDTO;
import com.example.swimmingpoolservice.controllers.dto.ZonedDateTimeRequest;
import com.example.swimmingpoolservice.data.models.CollectedData;
import com.example.swimmingpoolservice.services.CollectedDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CollectedDataController {
    @Autowired
    private CollectedDataService collectedDataService;

    @GetMapping("/data/all")
    public List<CollectedData> findAllData() {
        return collectedDataService.findAll();
    }

    @GetMapping("/data/hour")
    public List<CollectedDataDTO> getCollectedDataInHour() {
        return collectedDataService.getCollectedDataInHour();
    }

    @PostMapping("/data/period")
    public List<CollectedDataDTO> fetchDtoOverASpecifiedPeriod(@RequestBody ZonedDateTimeRequest zonedDateTimeRequest) {
        return collectedDataService.fetchDtoOverASpecifiedPeriod(zonedDateTimeRequest.getDateFrom(), zonedDateTimeRequest.getDateTo());
    }

//    @GetMapping("/api/")
//    public List<CollectedDataDTO> findLastData() {
//        List<CollectedDataDTO> list = collectedDataService.findLastData(PageRequest.of(0, 1));
//        if (list.isEmpty()) {
//            return null;
//        } else {
//            return list;
//        }
//    }
}

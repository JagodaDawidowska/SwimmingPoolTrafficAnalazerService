package com.example.swimmingpoolservice.controllers;

import com.example.swimmingpoolservice.controllers.dto.CollectedDataDTO;
import com.example.swimmingpoolservice.controllers.dto.ZonedDateTimeRequest;
import com.example.swimmingpoolservice.data.models.CollectedData;
import com.example.swimmingpoolservice.services.CollectedDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CollectedDataController {
    @Autowired
    private CollectedDataService collectedDataService;

    @GetMapping("/n")
    public List<CollectedData> findAllRentedInventory() {
        return collectedDataService.findAll();
    }

    @GetMapping("/DTO")
    public List<CollectedDataDTO> collectedDTO() {
        return collectedDataService.collectedDTO();
    }

    @PostMapping("/DTO_Peroid_of_TimeBODY")
    public List<CollectedDataDTO> fetchDTOOverASpecifiedPeriodOfTimeBODY(@RequestBody ZonedDateTimeRequest zonedDateTimeRequest) {

        return collectedDataService.fetchDTOOverASpecifiedPeriodOfTimeBODY(zonedDateTimeRequest.getDateFrom(), zonedDateTimeRequest.getDateTo());
    }

    @GetMapping("/last_Data")
    public List<CollectedDataDTO> findLastData() {
        List<CollectedDataDTO> list = collectedDataService.findLastData(PageRequest.of(0, 1));
        if (list.isEmpty()) {
            return null;
        } else {
            return list;
        }
    }
}

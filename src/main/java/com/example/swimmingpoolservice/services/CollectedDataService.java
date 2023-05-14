package com.example.swimmingpoolservice.services;

import com.example.swimmingpoolservice.controllers.dto.CollectedDataDTO;
import com.example.swimmingpoolservice.data.models.CollectedData;
import com.example.swimmingpoolservice.repositories.CollectedDataRepository;
import com.example.swimmingpoolservice.utils.CollectDataUtil;
import com.example.swimmingpoolservice.utils.DateUtil;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class CollectedDataService {
    private CollectedDataRepository collectedDataRepository;
    private CollectDataUtil collectDataUtil;


    public CollectedDataService(CollectedDataRepository collectedDataRepository, CollectDataUtil collectDataUtil) {
        this.collectedDataRepository = collectedDataRepository;
        this.collectDataUtil = collectDataUtil;
    }

    public CollectedData mapperStringListToCollectedDataList(CollectDataUtil collectDataUtil) throws IOException {
        List<String> fileterdDatainString = collectDataUtil.displayFileteredInformation();
        String amountPeopleAtPool = fileterdDatainString.get(0);
        String amountOfFreeSpotsAtPool = fileterdDatainString.get(1);
        String amountPeopleAtSpa = fileterdDatainString.get(2);
        String amountOfFreeSpotsAtSpa = fileterdDatainString.get(3);

        CollectedData collectedData = new CollectedData();
        collectedData.setAmountPeopleAtPool(Integer.valueOf(amountPeopleAtPool));
        collectedData.setAmountOfFreeSpotsAtPool(Integer.valueOf(amountOfFreeSpotsAtPool));
        collectedData.setAmountPeopleAtSpa(Integer.valueOf(amountPeopleAtSpa));
        collectedData.setAmountOfFreeSpotsAtSpa(Integer.valueOf(amountOfFreeSpotsAtSpa));

        return collectedData;
    }

    public void SaveData() throws IOException {
        CollectedData collectedData = new CollectedData();
        collectedData = mapperStringListToCollectedDataList(collectDataUtil);
        collectedData.setDownloadDate(DateUtil.getZonedCurrentDate());
        collectedDataRepository.save(collectedData);
    }

    public List<CollectedData> findAll() {
        return collectedDataRepository.findAll();
    }

    public List<CollectedDataDTO> collectedDTO() {
        return collectedDataRepository.getCollectedDataInHour();
    }

    public List<CollectedDataDTO> fetchDTOOverASpecifiedPeriodOfTime(ZonedDateTime dateStart, ZonedDateTime dateEnd) {
        return collectedDataRepository.fetchDTOOverASpecifiedPeriodOfTime(dateStart, dateEnd);
    }

    public List<CollectedDataDTO> fetchDTOOverASpecifiedPeriodOfTimeBODY(ZonedDateTime dateStart, ZonedDateTime dateEnd) {
        return collectedDataRepository.fetchDTOOverASpecifiedPeriodOfTimeBODY(dateStart, dateEnd);
    }

    public List<CollectedDataDTO> findLastData(PageRequest of) {
        List<CollectedDataDTO> list = collectedDataRepository.findFirstByOOrderByDownloadDate(PageRequest.of(0, 1));
        return list;
    }
}

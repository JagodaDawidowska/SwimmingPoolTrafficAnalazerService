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
        List<String> filteredDataInString = collectDataUtil.displayFilteredInformation();
        String amountPeopleAtPool = filteredDataInString.get(0);
        String amountOfFreeSpotsAtPool = filteredDataInString.get(1);
        String amountPeopleAtSpa = filteredDataInString.get(2);
        String amountOfFreeSpotsAtSpa = filteredDataInString.get(3);

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

    public List<CollectedDataDTO> getCollectedDataInHour() {
        return collectedDataRepository.getCollectedDataInHour();
    }

    public List<CollectedDataDTO> fetchDTOOverASpecifiedPeriodOfTime(ZonedDateTime dateStart, ZonedDateTime dateEnd) {
        return collectedDataRepository.fetchDTOOverASpecifiedPeriodOfTime(dateStart, dateEnd);
    }

    public List<CollectedDataDTO> fetchDtoOverASpecifiedPeriod(ZonedDateTime dateStart, ZonedDateTime dateEnd) {
        return collectedDataRepository.fetchDTOOverASpecifiedPeriodOfTimeBODY(dateStart, dateEnd);
    }

}

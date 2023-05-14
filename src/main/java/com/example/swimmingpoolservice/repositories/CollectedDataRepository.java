package com.example.swimmingpoolservice.repositories;

import com.example.swimmingpoolservice.controllers.dto.CollectedDataDTO;
import com.example.swimmingpoolservice.data.models.CollectedData;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.ZonedDateTime;
import java.util.List;

@Repository
public interface CollectedDataRepository extends JpaRepository<CollectedData, Long> {
    @Transactional
    @Modifying
    @Query("SELECT new com.example.swimmingpoolservice.controllers.dto.CollectedDataDTO( C.amountPeopleAtPool, C.amountOfFreeSpotsAtPool, C.amountPeopleAtSpa, C.amountOfFreeSpotsAtSpa, C.downloadDate)" +
            "FROM CollectedData AS C")
    List<CollectedDataDTO> getCollectedDataInHour();

    @Transactional
    @Modifying
    @Query(value = "SELECT new com.example.swimmingpoolservice.controllers.dto.CollectedDataDTO( C.amountPeopleAtPool, C.amountOfFreeSpotsAtPool, C.amountPeopleAtSpa, C.amountOfFreeSpotsAtSpa, C.downloadDate)" +
            "FROM CollectedData AS C " +
            "WHERE + C.downloadDate>:dateStart AND C.downloadDate<:dateEnd")
    List<CollectedDataDTO> fetchDTOOverASpecifiedPeriodOfTime(ZonedDateTime dateStart, ZonedDateTime dateEnd);

    @Transactional
    @Modifying
    @Query(value = "SELECT new com.example.swimmingpoolservice.controllers.dto.CollectedDataDTO( C.amountPeopleAtPool, C.amountOfFreeSpotsAtPool, C.amountPeopleAtSpa, C.amountOfFreeSpotsAtSpa, C.downloadDate)" +
            "FROM CollectedData AS C " +
            "WHERE + C.downloadDate>:dateStart AND C.downloadDate<:dateEnd")
    List<CollectedDataDTO> fetchDTOOverASpecifiedPeriodOfTimeBODY(ZonedDateTime dateStart, ZonedDateTime dateEnd);

    @Query(value = "SELECT new com.example.swimmingpoolservice.controllers.dto.CollectedDataDTO( C.amountPeopleAtPool, C.amountOfFreeSpotsAtPool, C.amountPeopleAtSpa, C.amountOfFreeSpotsAtSpa, C.downloadDate)" +
            "FROM CollectedData AS C " +
            "ORDER BY C.downloadDate DESC")
    List<CollectedDataDTO> findFirstByOOrderByDownloadDate(Pageable pageable);

}

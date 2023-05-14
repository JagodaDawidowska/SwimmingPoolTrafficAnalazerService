package com.example.swimmingpoolservice.Scheduled;

import com.example.swimmingpoolservice.services.CollectedDataService;
import com.example.swimmingpoolservice.utils.CollectDataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ScheduleTask {
    @Autowired
    private CollectDataUtil collectDataUtil;

    @Autowired
    private CollectedDataService collectedDataService;

//    @Scheduled(fixedRate = 100000)
//    * "0 0/30 8-10 * * *" = 8:00, 8:30, 9:00, 9:30 and 10 o'clock every day.
    @Scheduled(cron = "0 */5 6-21 * * *")
    public void work() throws IOException {
        collectDataUtil.displayFileteredInformation();
        collectedDataService.SaveData();
    }


}

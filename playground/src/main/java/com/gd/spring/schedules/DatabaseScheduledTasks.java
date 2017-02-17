package com.gd.spring.schedules;

import com.gd.spring.services.PhoneService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@ConditionalOnProperty("application.schedule.active")
public class DatabaseScheduledTasks {
    private static final Logger log = LoggerFactory.getLogger(DatabaseScheduledTasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    private final PhoneService phoneService;

    @Autowired
    public DatabaseScheduledTasks(PhoneService phoneService) {
        this.phoneService = phoneService;
    }

    @Scheduled(cron = "${application.schedule.cron}")
    public void reportCurrentTime() {
        log.info("At {} we found {} phones in the DB.", dateFormat.format(new Date()), phoneService.countPhones());
    }
}

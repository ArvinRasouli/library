package com.mupra.library.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@EnableScheduling
public class CronJobService {
    private final BookService bookService;

    public CronJobService(BookService bookService) {
        this.bookService = bookService;
    }

    private final Logger logger = LoggerFactory.getLogger(CronJobService.class);

    @Scheduled(cron = "0 0 8 * * * ")
    public void updateAllInventoryBooks() {
        logger.info("start daily cron job");
        bookService.changeInventoryAllBooks();
        logger.info("end daily cron job");
    }
}

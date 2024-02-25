package com.mupra.library.rest;

import com.mupra.library.dto.request.AddPublisherRequest;
import com.mupra.library.entity.Publisher;
import com.mupra.library.service.PublisherService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/publisher")
public class PublisherRestController {
    private final PublisherService publisherService;

    public PublisherRestController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @PostMapping("/add")
    public Publisher addPublisher(@RequestBody AddPublisherRequest addPublisherRequest) {
        return publisherService.addPublisher(addPublisherRequest);
    }
}

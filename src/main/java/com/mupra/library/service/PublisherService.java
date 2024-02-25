package com.mupra.library.service;

import com.mupra.library.dto.request.AddPublisherRequest;
import com.mupra.library.entity.Publisher;

public interface PublisherService {
    Publisher addPublisher(AddPublisherRequest addPublisherRequest);

    Publisher getPublisherById(int id);
}

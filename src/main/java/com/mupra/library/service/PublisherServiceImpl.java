package com.mupra.library.service;

import com.mupra.library.dao.PublisherDAO;
import com.mupra.library.dto.request.AddPublisherRequest;
import com.mupra.library.entity.Publisher;
import org.springframework.stereotype.Service;

@Service
public class PublisherServiceImpl implements PublisherService{

    private final PublisherDAO publisherDAO;

    public PublisherServiceImpl(PublisherDAO publisherDAO) {
        this.publisherDAO = publisherDAO;
    }


    @Override
    public Publisher addPublisher(AddPublisherRequest addPublisherRequest) {
        Publisher publisher = new Publisher(addPublisherRequest.getName(), addPublisherRequest.getEstablishedYear());
        return publisherDAO.save(publisher);
    }

    @Override
    public Publisher getPublisherById(int id) {

        return publisherDAO.findById(id).orElseThrow(
                () -> new RuntimeException("Publisher not exist")
        );
    }

}

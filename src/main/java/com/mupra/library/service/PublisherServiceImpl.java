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

        if (publisher.getName().length() > 100) {
            throw new RuntimeException("The length of the publisher name exceeds the limit");
        }

        if (publisher.getName().isEmpty()) {
            throw new RuntimeException("Publisher name field cannot be empty");
        }


        if (publisher.getEstablishedYear() > 1402 || publisher.getEstablishedYear() <= 0) {
            throw new RuntimeException("The data entered in the year of establishment field is invalid");
        }
        return publisherDAO.save(publisher);
    }

    @Override
    public Publisher getPublisherById(int id) {

        return publisherDAO.findById(id).orElseThrow(
                () -> new RuntimeException("Publisher not exist")
        );
    }

}

package com.myapp.services;

import com.myapp.models.Messages;

import java.util.List;

public interface MessagesService {


    List<Messages> getAllMessages();

    Messages findById(int id);

    void addMessage(Messages messages);


}

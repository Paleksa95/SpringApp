package com.myapp.dao;


import com.myapp.models.Messages;

import java.util.List;

public interface MessagesDAO {

    List<Messages> getAllMessages();

    Messages findById(int id);

    void addMessage(Messages messages);

}

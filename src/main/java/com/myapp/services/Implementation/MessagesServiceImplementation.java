package com.myapp.services.Implementation;


import com.myapp.dao.MessagesDAO;
import com.myapp.models.Messages;
import com.myapp.services.MessagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessagesServiceImplementation implements MessagesService {


    @Autowired
    private MessagesDAO messagesDAO;


    public void addMessage(Messages messages) {
        messagesDAO.addMessage(messages);
    }

    public List<Messages> getAllMessages() {
        return messagesDAO.getAllMessages();
    }

    public Messages findById(int id) {
        return messagesDAO.findById(id);
    }

}

package com.myapp.controllers;

import com.myapp.models.Messages;
import com.myapp.services.MessagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;


@Controller
public class MessageController {


    @Autowired
    private MessagesService messagesService;

    //For adding new message.
    @ModelAttribute("Messages")
    public Messages constructMessages() {
        return new Messages();
    }

    //Getting list of all messages.
    @RequestMapping("showmessages")
    public String showMessages(Model model) {
        model.addAttribute("messages", messagesService.getAllMessages());
        return "showmessages";
    }


  //Adding new message by any user that is Loged in.
    @RequestMapping(value = "/showmessages", method = RequestMethod.POST)
    public String submitMessageForm(@Valid @ModelAttribute("Messages") Messages messages, BindingResult result) {

        //If we have errors ( see models.Messages )
        //We will return user to showmessages.jsp page and we will display errors ( look showmessages.jsp )
        if (result.hasErrors()){
            return "/showmessages";
        }

        //If there are no errors we are redirecting user to index.jsp
        //I am not returning any param with index here and there are not going to be any message that will tell user that his
        //message is posted successfully, so he need to go to showmessages.jsp and to see it there. ( i just didn't want to implement that )
        messagesService.addMessage(messages);
        return "redirect:/index";
    }


}

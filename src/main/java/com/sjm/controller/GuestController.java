package com.sjm.controller;

import com.sjm.domain.GuestBook;
import com.sjm.service.GuestService;
import com.sjm.util.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GuestController {

    @Autowired
    private GuestService guestService;

    @RequestMapping(value = "/books" , method = RequestMethod.GET)
    public Message getGuestBooks(){

        return Message.success();
    }

    @RequestMapping(value = "/book/{id}" , method = RequestMethod.GET)
    public Message getGuestBook(){

        return Message.success();
    }

    @RequestMapping(value = "/book" , method = RequestMethod.POST)
    public Message saveGuestBook(GuestBook gb){

        return Message.success();
    }

    @RequestMapping(value = "/book/{id}" , method = RequestMethod.PUT)
    public Message updateGuestBook(GuestBook gb){

        return Message.success();
    }

    @RequestMapping(value = "/book/{id}" , method = RequestMethod.DELETE)
    public Message deleteGuestBook(){

        return Message.success();
    }
}

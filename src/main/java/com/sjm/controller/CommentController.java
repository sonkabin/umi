package com.sjm.controller;

import com.sjm.domain.Comment;
import com.sjm.service.CommentService;
import com.sjm.util.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    @RequestMapping(value = "/comments" , method = RequestMethod.GET)
        public Message getComments(){

            return Message.success();
        }

        @RequestMapping(value = "/comment/{id}" , method = RequestMethod.GET)
        public Message getComment(){

            return Message.success();
        }

        @RequestMapping(value = "/comment" , method = RequestMethod.POST)
        public Message saveComment(Comment comment){

            return Message.success();
        }

        @RequestMapping(value = "/comment/{id}" , method = RequestMethod.PUT)
        public Message updateComment(Comment comment){

            return Message.success();
        }

        @RequestMapping(value = "/comment/{id}" , method = RequestMethod.DELETE)
        public Message deleteComment(){

            return Message.success();
        }
}

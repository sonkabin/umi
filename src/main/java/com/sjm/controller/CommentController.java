package com.sjm.controller;

import com.sjm.domain.Comment;
import com.sjm.service.CommentService;
import com.sjm.util.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 文章评论可查看，可删除，后台管理系统修改和新增无意义
 * @author sonkabin
 *
 */
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

        @RequestMapping(value = "/comment/{id}" , method = RequestMethod.DELETE)
        public Message deleteComment(){

            return Message.success();
        }
}

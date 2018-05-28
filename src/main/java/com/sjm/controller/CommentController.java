package com.sjm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sjm.domain.Comment;
import com.sjm.dto.CommentDTO;
import com.sjm.service.CommentService;
import com.sjm.util.Message;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
        public Message getComments(@RequestParam(value="pn",defaultValue="1")Integer pn,CommentDTO dto){
    		PageHelper.startPage(pn, 5);
    		List<Comment> list = commentService.getComments(dto);
    		PageInfo<?> pageInfo = new PageInfo<>(list,5);
            return Message.success().add("pageInfo", pageInfo);
        }

        @RequestMapping(value = "/comment/{id}" , method = RequestMethod.GET)
        public Message getComment(){

            return Message.success();
        }

        @RequestMapping(value = "/comment/{id}" , method = RequestMethod.DELETE)
        public Message deleteComment(@PathVariable("id")Integer id){
        	commentService.deleteComment(id);
            return Message.success();
        }
}

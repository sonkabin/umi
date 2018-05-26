package com.sjm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sjm.domain.GuestBook;
import com.sjm.dto.GuestBookDTO;
import com.sjm.service.GuestService;
import com.sjm.util.Message;

/**
 * 用户留言只能查看和删除，不能更新，也不能在后台管理系统中增加
 * @author sonkabin
 *
 */
@RestController
public class GuestController {

    @Autowired
    private GuestService guestService;

    @RequestMapping(value = "/gusetBooks" , method = RequestMethod.GET)
    public Message getGuestBooks(@RequestParam(value="pn",defaultValue="1")Integer pn,GuestBookDTO dto){
    	PageHelper.startPage(pn, 5);
    	List<GuestBook> gb = guestService.getGuestBooks(dto);
    	PageInfo<?> page = new PageInfo<>(gb, 5);
        return Message.success().add("pageInfo", page);
    }

    @RequestMapping(value = "/gusetBook/{id}" , method = RequestMethod.DELETE)
    public Message deleteGuestBook(@PathVariable("id")Integer id){
    	guestService.deleteGuestBook(id);
        return Message.success();
    }
}

package com.sjm.controller;

import com.sjm.domain.BlogSetting;
import com.sjm.service.BlogSettingService;
import com.sjm.util.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SettingController {
	
	@Autowired
	private BlogSettingService blogSettingService;

    @RequestMapping(value = "/setting", method = RequestMethod.GET)
    public Message getBlogSetting() {
    	BlogSetting bs = blogSettingService.findSetting();
        return Message.success().add("bs", bs);
    }

    @RequestMapping(value = "/setting/{id}", method = RequestMethod.PUT)
    public Message updateBlogSetting(BlogSetting blogSetting) {
    	blogSettingService.updateSetting(blogSetting);
        return Message.success();
    }

}


package com.sjm.controller;

import com.sjm.domain.BlogSetting;
import com.sjm.util.Message;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SettingController {

    @RequestMapping(value = "/setting", method = RequestMethod.GET)
    public Message getBlogSetting() {

        return Message.success();
    }

    @RequestMapping(value = "/setting/{id}", method = RequestMethod.PUT)
    public Message updateBlogSetting(BlogSetting blogSetting) {

        return Message.success();
    }

}


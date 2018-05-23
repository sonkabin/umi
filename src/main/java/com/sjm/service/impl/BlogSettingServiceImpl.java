package com.sjm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sjm.dao.BlogSettingMapper;
import com.sjm.domain.BlogSetting;
import com.sjm.service.BlogSettingService;

@Service
public class BlogSettingServiceImpl implements BlogSettingService {

	@Autowired
	private BlogSettingMapper blogSettingMapper;
	
	@Override
	public BlogSetting findSetting() {
		return blogSettingMapper.selectByPrimaryKey(1);
	}

	@Override
	public void updateSetting(BlogSetting blogSetting) {
		blogSettingMapper.updateByPrimaryKeySelective(blogSetting);
	}

}

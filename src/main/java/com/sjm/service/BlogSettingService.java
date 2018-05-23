package com.sjm.service;

import com.sjm.domain.BlogSetting;

public interface BlogSettingService {

	BlogSetting findSetting();

	void updateSetting(BlogSetting blogSetting);

}

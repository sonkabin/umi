package com.sjm.service.impl;

import com.sjm.dao.GuestBookMapper;
import com.sjm.domain.GuestBook;
import com.sjm.domain.GuestBookExample;
import com.sjm.domain.GuestBookExample.Criteria;
import com.sjm.dto.GuestBookDTO;
import com.sjm.service.GuestService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GuestServiceImpl implements GuestService {

	@Autowired
	private GuestBookMapper guestBookMapper;

	@Override
	public List<GuestBook> getGuestBooks(GuestBookDTO dto) {
		GuestBookExample example = new GuestBookExample();
		Criteria criteria = example.createCriteria().andNameLike("%" + dto.getName() + "%");
		if(dto.getStartTime() != null) {
			criteria.andCreateTimeGreaterThanOrEqualTo(dto.getStartTime());
		}
		if(dto.getEndTime() != null) {
			criteria.andCreateTimeLessThanOrEqualTo(dto.getEndTime());
		}
		List<GuestBook> list = guestBookMapper.selectByExampleWithBLOBs(example);
		return list;
	}

	@Override
	public void deleteGuestBook(Integer id) {
		guestBookMapper.deleteByPrimaryKey(id);
	}
}

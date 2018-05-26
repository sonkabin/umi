package com.sjm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sjm.dao.LabelMapper;
import com.sjm.domain.Label;
import com.sjm.domain.LabelExample;
import com.sjm.service.LabelService;

@Service
public class LabelServiceImpl implements LabelService {

	@Autowired
	private LabelMapper labelMapper;
	
	@Override
	public List<Label> getLabels(int userId) {
		LabelExample example = new LabelExample();
		example.createCriteria().andUserIdEqualTo(userId);
		return labelMapper.selectByExample(example);
	}

	@Override
	public Label findLabel(Integer id) {
		return labelMapper.selectByPrimaryKey(id);
	}

	@Override
	public void saveLabel(String labelName,int userId) {
		Label label = new Label();
		label.setLabelName(labelName);
		label.setUserId(userId);
		labelMapper.insertSelective(label);
	}

	@Override
	public void updateLabel(Label label) {
		labelMapper.updateByPrimaryKeySelective(label);
	}

	@Override
	public void deleteLabel(Integer id) {
		labelMapper.deleteByPrimaryKey(id);
	}

}

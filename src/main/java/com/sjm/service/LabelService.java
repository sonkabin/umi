package com.sjm.service;

import java.util.List;

import com.sjm.domain.Label;

public interface LabelService {

	List<Label> getLabels(int userId);

	Label findLabel(Integer id);

	void saveLabel(String labelName,int userId);

	void updateLabel(Label label);

	void deleteLabel(Integer id);

}

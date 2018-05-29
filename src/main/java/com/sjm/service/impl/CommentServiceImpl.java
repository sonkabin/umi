package com.sjm.service.impl;

import com.sjm.dao.CommentMapper;
import com.sjm.domain.Comment;
import com.sjm.domain.CommentExample;
import com.sjm.domain.CommentExample.Criteria;
import com.sjm.dto.CommentDTO;
import com.sjm.service.CommentService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	private CommentMapper commentMapper;

	@Override
	public void deleteComment(Integer id) {
		commentMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<Comment> getComments(CommentDTO dto) {
		CommentExample example = new CommentExample();
		Criteria criteria = example.createCriteria();
		String title = null;
		if(dto.getTitle() != null) {
			title = "%" + dto.getTitle() + "%";
		}else {
			example.setOrderByClause("c.create_time desc");
		}
		if(dto.getStartTime() != null) {
			criteria.andCreateTimeGreaterThanOrEqualTo(dto.getStartTime());
		}
		if(dto.getEndTime() != null) {
			criteria.andCreateTimeLessThanOrEqualTo(dto.getEndTime());
		}
		return commentMapper.selectByExampleWithTitle(example,title);
	}
}

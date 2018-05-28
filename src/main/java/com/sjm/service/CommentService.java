package com.sjm.service;

import java.util.List;

import com.sjm.domain.Comment;
import com.sjm.dto.CommentDTO;

public interface CommentService {

	void deleteComment(Integer id);

	List<Comment> getComments(CommentDTO dto);
}

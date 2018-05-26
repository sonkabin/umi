package com.sjm.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sjm.domain.Label;
import com.sjm.service.LabelService;
import com.sjm.util.Message;

/**
 * 标签可以增删改查，但是只能操作管理员自己的
 * @author sonkabin
 *
 */
@RestController
public class LabelController {

	@Autowired
	private LabelService labelService;
	
	@RequestMapping(value = "/tags", method = RequestMethod.GET)
	public Message getLabels(HttpSession session) {
		List<Label> labels = labelService.getLabels(getUserId(session));
		return Message.success().add("labels", labels);
	}
	
	@RequestMapping(value = "/labels", method = RequestMethod.GET)
	public Message getLabels(@RequestParam(value="pn",defaultValue="1")Integer pn,HttpSession session) {
		PageHelper.startPage(pn, 5);
		List<Label> labels = labelService.getLabels(getUserId(session));
		PageInfo<?> pageInfo = new PageInfo<>(labels, 5);
		return Message.success().add("pageInfo", pageInfo);
	}
	
	@RequestMapping(value = "/label/{id}", method = RequestMethod.GET)
	public Message getLabel(@PathVariable("id")Integer id) {
		Label label = labelService.findLabel(id);
		return Message.success().add("label", label);
	}
	
	@RequestMapping(value = "/label", method = RequestMethod.POST)
	public Message saveLabel(@RequestParam("labelName")String labelName,HttpSession session) {
		labelService.saveLabel(labelName,getUserId(session));
		return Message.success();
	}
	
	@RequestMapping(value = "/label/{labelId}", method = RequestMethod.PUT)
	public Message updateLabel(Label label) {
		labelService.updateLabel(label);
		return Message.success();
	}
	
	@RequestMapping(value = "/label/{labelId}", method = RequestMethod.DELETE)
	public Message deleteLabel(@PathVariable("labelId")Integer id) {
		labelService.deleteLabel(id);
		return Message.success();
	}
	
	//help method
	private int getUserId(HttpSession session) {
		return (int) session.getAttribute("userId");
	}
}

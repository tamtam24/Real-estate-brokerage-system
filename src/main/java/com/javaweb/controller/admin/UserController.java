package com.javaweb.controller.admin;

import com.javaweb.constant.SystemConstant;
import com.javaweb.model.dto.UserDTO;
import com.javaweb.security.utils.SecurityUtils;
import com.javaweb.service.IUserService;
import com.javaweb.service.impl.RoleService;
import com.javaweb.utils.DisplayTagUtils;
import com.javaweb.utils.MessageUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller(value = "usersControllerOfAdmin")
public class UserController {

	@Autowired
	private IUserService userService;

	@Autowired
	private RoleService roleService;

	@Autowired
	private MessageUtils messageUtil;

	@RequestMapping(value = "/admin/user-list", method = RequestMethod.GET)
	public ModelAndView getNews(@ModelAttribute(SystemConstant.MODEL) UserDTO model, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("admin/user/list");
		DisplayTagUtils.of(request, model);
		List<UserDTO> news = userService.getUsers(model.getSearchValue(), PageRequest.of(model.getPage() - 1, model.getMaxPageItems()));
		model.setListResult(news);
		model.setTotalItems(userService.countTotalItems());
		mav.addObject(SystemConstant.MODEL, model);
		initMessageResponse(mav, request);
		return mav;
	}

	@RequestMapping(value = "/admin/user-edit", method = RequestMethod.GET)
	public ModelAndView addUser(@ModelAttribute(SystemConstant.MODEL) UserDTO model, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("admin/user/edit");
		model.setRoleDTOs(roleService.getRoles());
		initMessageResponse(mav, request);
		mav.addObject(SystemConstant.MODEL, model);
		return mav;
	}

	@RequestMapping(value = "/admin/profile-{username}", method = RequestMethod.GET)
	public ModelAndView updateProfile(@PathVariable("username") String username, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("admin/user/profile");
		UserDTO model = userService.findOneByUserName(username);
		initMessageResponse(mav, request);
		model.setRoleDTOs(roleService.getRoles());
		mav.addObject(SystemConstant.MODEL, model);
		return mav;
	}

	@RequestMapping(value = "/admin/user-edit-{id}", method = RequestMethod.GET)
	public ModelAndView updateUser(@PathVariable("id") Long id, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("admin/user/edit");
		UserDTO model = userService.findUserById(id);
		model.setRoleDTOs(roleService.getRoles());
		initMessageResponse(mav, request);
		mav.addObject(SystemConstant.MODEL, model);
		return mav;
	}

	@RequestMapping(value = "/admin/profile-password", method = RequestMethod.GET)
	public ModelAndView updatePassword(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("admin/user/password");
		UserDTO model = userService.findOneByUserName(SecurityUtils.getPrincipal().getUsername());
		initMessageResponse(mav, request);
		mav.addObject(SystemConstant.MODEL, model);
		return mav;
	}

	private void initMessageResponse(ModelAndView mav, HttpServletRequest request) {
		String message = request.getParameter("message");
		if (message != null && StringUtils.isNotEmpty(message)) {
			Map<String, String> messageMap = messageUtil.getMessage(message);
			mav.addObject(SystemConstant.ALERT, messageMap.get(SystemConstant.ALERT));
			mav.addObject(SystemConstant.MESSAGE_RESPONSE, messageMap.get(SystemConstant.MESSAGE_RESPONSE));
		}
	}
}

/*
 * Copyright 2002-2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.readcode.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.readcode.service.UserService;
import org.readcode.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {
	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private UserService userService;

	@GetMapping("/")
	public String getUser() {
		return "index";
	}

	@GetMapping(value = "/user", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Object primitive(@RequestParam Integer value) {
		UserVo user = new UserVo();
		user.setUserName(value + "");
		return user;
	}

	@GetMapping(value = "/selectListAgeGt15", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<UserVo> selectListAgeGt15() {
		List<UserVo> userPoList = userService.selectListAgeGt15();

		return userPoList;
	}
}

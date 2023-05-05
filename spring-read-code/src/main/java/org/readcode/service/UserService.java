package org.readcode.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.readcode.dao.UserDao;
import org.readcode.po.UserPo;
import org.readcode.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private UserDao userDao;

	public List<UserVo> selectListAgeGt15() {
		QueryWrapper<UserPo> wrapper = new QueryWrapper<>();
		wrapper.select("username","password","age","sex");
		List<UserPo> userPoList = userDao.selectList(wrapper);

		List<UserVo> userList = new ArrayList<>();
		for (UserPo v : userPoList) {
			UserVo user = new UserVo();
			user.setUserName(v.getUserName());
			user.setPassword(v.getPassword());
			userList.add(user);
		}

		return userList;
	}
}

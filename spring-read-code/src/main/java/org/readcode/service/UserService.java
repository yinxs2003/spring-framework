package org.readcode.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.readcode.dao.UserDao;
import org.readcode.po.UserPo;
import org.readcode.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;

	public List<User> selectListAgeGt15() {
		QueryWrapper<UserPo> wrapper = new QueryWrapper<>();
		wrapper.select("username","password","age","sex");
		List<UserPo> userPoList = userDao.selectList(wrapper);

		List<User> userList = new ArrayList<>();
		for (UserPo v : userPoList) {
			User user = new User();
			user.setName(v.getUserName());
			user.setLastName(v.getPassword());
			userList.add(user);
		}

		return userList;
	}
}

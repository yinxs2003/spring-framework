package org.readcode.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.readcode.dao.UserDao;
import org.readcode.po.UserPo;
import org.readcode.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;

	public List<UserPo> selectListAgeGt15() {
		QueryWrapper<UserPo> wrapper = new QueryWrapper<>();
		wrapper.select("id", "userName")
				.gt("age", 15);

		return userDao.selectList(wrapper);
	}
}

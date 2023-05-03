package org.readcode.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("user")
public class UserPo {
	// 主键
	@TableId(type = IdType.AUTO)
	private Integer id;
	private Integer age;
	private String userName;
	private String password;
	private String sex;
	private String address;
}

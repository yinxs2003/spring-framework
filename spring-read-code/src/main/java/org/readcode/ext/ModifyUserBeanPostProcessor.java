package org.readcode.ext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.readcode.vo.UserVo;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * 自定义BeanPostProcessor,用来修改ModifyUserBeanPostProcessor这个bean的属性
 */
public class ModifyUserBeanPostProcessor implements BeanFactoryPostProcessor {
	protected final Log logger = LogFactory.getLog(getClass());

	// 执行完之后，ModifyUserBeanPostProcessor这个bean里的值会填充新的属性
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		UserVo userVo = (UserVo) beanFactory.getBean("ModifyUserBeanPostProcessor");
		userVo.setSex("girl");
		userVo.setAge(19);
		logger.info("=====>" + userVo);
	}
}

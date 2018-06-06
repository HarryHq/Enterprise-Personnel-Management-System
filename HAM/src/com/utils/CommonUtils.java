package com.utils;


import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.entity.Staff;


/**
 * @author mhuan
 *
 */
public class CommonUtils {


	/**
	 * 把表单数据 封装到实体类中
	 * 
	 * @param map 传递一个装有实体信息的Map
	 * @param class1  需要封装的实体类
	 * @return
	 */
	public static <T> T toBean(Map map, Class<T> class1) {
		try {
			// 1、创建指定类型的javabean对象
			T bean = class1.newInstance();

			// 2、把数据封装到javabean中
			BeanUtils.populate(bean, map);

			// 3、返回javabean对象
			return bean;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}


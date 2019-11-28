package com.xtkj.service.keyswordfilter;

import java.util.List;

import com.xtkj.pojo.KeyWords;

public interface IKeysWordFilterService {

	/**
	 * @Description:关键字过滤接口
	 * @param str
	 * @return 返回过滤后的字符串
	 */
	String keysWordFilter(String str);

	/**
	 * @Description:增加关键字
	 * @param keyWords
	 * @return 返回插入数据影响的行数
	 */
	int addKeys(KeyWords keyWords);

	/**
	 * @Description:删除关键字
	 * @param keyWords
	 * @return 返回数据库影响的行数
	 */
	int updateKeys(KeyWords keyWords);


	/**
	 * @Description:查询所有的关键字
	 * @return 返回关键字的list<KeyWords>
	 */
	List<KeyWords> listKeys();

}

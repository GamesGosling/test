package com.xtkj.service.keyswordfilter;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xtkj.dao.KeyWordsMapper;
import com.xtkj.pojo.KeyWords;
import com.xtkj.service.redis.JedisClient;
import com.xtkj.utils.JSONStringUtils;
import com.xtkj.utils.keywordsfilter.WordFilterUtil;

@Service
public class KeysWordFilterServiceImp implements IKeysWordFilterService {

	@Autowired
	private KeyWordsMapper keyWordsMapper;
	@Autowired
	private JedisClient jedis;

	public String keysWordFilter(String str) {
		
		List<KeyWords> listKeysWords = listKeys();
		//将关键字插入node中
		for(KeyWords keyWord:listKeysWords) {
			WordFilterUtil.insertWord(keyWord.getKeyWords(), keyWord.getHot());
		}
		//进行过滤
		String strs=WordFilterUtil.filterText(str, '*').getFilteredContent();
		
		return strs;		
	}
	
	
	@SuppressWarnings("unchecked")
	public  List<KeyWords> listKeys(){
		List<KeyWords> listKeysWords=null;
		String keyWords = null;
		//先在缓存里获取关键字字符串
		try { 
			keyWords=jedis.get("ListKeysWords");		
		} catch (Exception e) {
			e.getStackTrace();
		}
		
		if(keyWords==null||"".equals(keyWords)) {
			//查询所用关键字
			listKeysWords=keyWordsMapper.listKeys();
			String json=JSONStringUtils.javaToJson(listKeysWords);
			jedis.set("ListKeysWords", json);
		}else {
			List<KeyWords> list=JSONStringUtils.jsonToJava(keyWords, KeyWords.class);
			listKeysWords=list;
		}
		
		return listKeysWords;
	}
	


	@Override
	public int addKeys(KeyWords keyWords) {
		String id=UUID.randomUUID().toString();
		keyWords.setId(id);
		return keyWordsMapper.insert(keyWords);
	}

	
	@Override
	public int updateKeys(KeyWords keyWords) {
		try {
			jedis.del("ListKeysWords");
		} catch (Exception e) {
			e.getStackTrace();
		}	
		return keyWordsMapper.updateByPrimaryKeySelective(keyWords);
	}
}

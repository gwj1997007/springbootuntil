package com.test.tools.springbootuntil;

import com.alibaba.fastjson.JSON;
import com.test.tools.springbootuntil.untils.MapOrJson2XmlUtil;
import netscape.javascript.JSObject;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootuntilApplicationTests {
	@Autowired
	private MapOrJson2XmlUtil util;

	@Test
	void contextLoads() {
	}
	@Test
	public void testMap2xml(){
		util.testmap2xml();
	}
}

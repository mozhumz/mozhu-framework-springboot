package com.hyj.framework;

import com.hyj.framework.web.controller.AopTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HyjFrameworkApplicationTests {
	@Resource
	AopTest aopTest;

	@Test
	public void contextLoads() {
		aopTest.testDemo("testDemo");
	}

}

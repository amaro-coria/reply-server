package com.teknei;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.teknei.persistence.ReplyBD;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReplyServerApplicationTests {
	
	@Autowired
	private ReplyBD bd;

	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testCount(){
		//Integer count = bd.callDBUnitTest();
		//assertNotNull(count);
	}

}

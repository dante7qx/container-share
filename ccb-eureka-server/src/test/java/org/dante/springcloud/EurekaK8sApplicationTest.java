package org.dante.springcloud;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class EurekaK8sApplicationTest {
	
	/**
	 * 这里只是演示单元测试步骤，下面的代码没有任何意义
	 */
	@Test
	public void test() {
		log.info("ok!");
	}

}

package org.dante.springcloud;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.dante.springcloud.vo.TechnologyVO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class CCBApi1Application {
	public static void main(String[] args) {
		SpringApplication.run(CCBApi1Application.class, args);
	}
	
	@GetMapping("/app_name")
	public String appName() throws UnknownHostException {
		return "ccb-api1 - ".concat(InetAddress.getLocalHost().getHostName());
	}
	
	@GetMapping("/msg")
	public List<TechnologyVO> msg()  {
		List<TechnologyVO> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			list.add(new TechnologyVO("ccb-api1服务-" + i,
					"服务创建于" + DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now())));
		}
		return list;
	}
	
}


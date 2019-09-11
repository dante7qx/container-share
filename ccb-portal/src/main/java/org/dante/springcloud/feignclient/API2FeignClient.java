package org.dante.springcloud.feignclient;

import java.util.List;

import org.dante.springcloud.feignclient.fallback.API2FeignFallback;
import org.dante.springcloud.vo.TechnologyVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Profile("springcloud")
@FeignClient(name = "ccb-api2", fallback = API2FeignFallback.class)
public interface API2FeignClient {

	@RequestMapping(method = RequestMethod.GET, value = "/app_name")
	public String appName();
	
	@RequestMapping(method = RequestMethod.GET, value = "/msg")
	public List<TechnologyVO> msg();
	
}



package org.dante.springcloud.feignclient;

import java.util.List;

import org.dante.springcloud.feignclient.fallback.API2NoEurekaFeignFallback;
import org.dante.springcloud.vo.TechnologyVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Profile("k8s")
@FeignClient(name = "ccb-api2", url = "http://${ccb.api2.url}", fallback = API2NoEurekaFeignFallback.class)
public interface API2NoEurekaFeignClient {

	@RequestMapping(method = RequestMethod.GET, value = "/app_name")
	public String appName();
	
	@RequestMapping(method = RequestMethod.GET, value = "/msg")
	public List<TechnologyVO> msg();
	
}



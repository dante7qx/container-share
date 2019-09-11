package org.dante.springcloud.feignclient;

import java.util.List;

import org.dante.springcloud.feignclient.fallback.API1FeignFallback;
import org.dante.springcloud.vo.TechnologyVO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Profile("springcloud")
@Qualifier("api1FeignClient")
@FeignClient(name = "ccb-api1", fallback = API1FeignFallback.class)
public interface API1FeignClient {

	@RequestMapping(method = RequestMethod.GET, value = "/app_name")
	public String appName();
	
	@RequestMapping(method = RequestMethod.GET, value = "/msg")
	public List<TechnologyVO> msg();
	
}

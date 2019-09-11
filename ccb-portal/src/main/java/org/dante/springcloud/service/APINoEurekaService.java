package org.dante.springcloud.service;

import java.util.List;

import org.dante.springcloud.feignclient.API1NoEurekaFeignClient;
import org.dante.springcloud.feignclient.API2NoEurekaFeignClient;
import org.dante.springcloud.vo.TechnologyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("k8s")
@Service
public class APINoEurekaService {

	@Autowired
	private API1NoEurekaFeignClient api1FeignClient;
	@Autowired
	private API2NoEurekaFeignClient api2FeignClient;
	
	public String getAPI1AppName() {
		return api1FeignClient.appName();
	}
	
	public List<TechnologyVO> getAPI1Msg() {
		return api1FeignClient.msg();
	}
	
	public String getAPI2AppName() {
		return api2FeignClient.appName();
	}
	
	public List<TechnologyVO> getAPI2Msg() {
		return api2FeignClient.msg();
	}

}

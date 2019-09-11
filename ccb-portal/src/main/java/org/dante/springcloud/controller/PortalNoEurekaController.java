package org.dante.springcloud.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

import org.dante.springcloud.service.APINoEurekaService;
import org.dante.springcloud.vo.TechnologyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Profile("k8s")
@RestController
public class PortalNoEurekaController {
	
	@Autowired
	private APINoEurekaService apiService;
	
	@GetMapping("/app_name")
	public String appName() throws UnknownHostException {
		return "ccb-portal - ".concat(InetAddress.getLocalHost().getHostName());
	}
	
	@GetMapping("/api1/app_name")
	public String api1AppName() {
		return apiService.getAPI1AppName();
	}
	
	@GetMapping("/api1/msg")
	public List<TechnologyVO> api1Msg() {
		return apiService.getAPI1Msg();
	}
	
	@GetMapping("/api2/app_name")
	public String api2AppName() {
		return apiService.getAPI2AppName();
	}
	
	@GetMapping("/api2/msg")
	public List<TechnologyVO> api2Msg() {
		return apiService.getAPI2Msg();
	}

}

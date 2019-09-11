package org.dante.springcloud.feignclient.fallback;

import java.util.ArrayList;
import java.util.List;

import org.dante.springcloud.feignclient.API1FeignClient;
import org.dante.springcloud.vo.TechnologyVO;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("springcloud")
@Component
public class API1FeignFallback implements API1FeignClient {

	@Override
	public String appName() {
		return "ccb-api1 - 服务暂不可用, 请稍后重试！";
	}

	@Override
	public List<TechnologyVO> msg() {
		List<TechnologyVO> list = new ArrayList<>();
		list.add(new TechnologyVO("ccb-api1", "服务暂不可用, 请稍后重试！"));
		return list;
	}


}

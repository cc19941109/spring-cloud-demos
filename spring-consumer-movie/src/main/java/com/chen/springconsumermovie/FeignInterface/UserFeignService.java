package com.chen.springconsumermovie.FeignInterface;

import com.chen.springconsumermovie.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "provider-eureka-demo")
public interface UserFeignService {

    @GetMapping("/simple/{id}")
    User getUser(@PathVariable("id")Long id);

    @GetMapping("/test/port")
    String getPort();

}

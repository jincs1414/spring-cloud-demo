package me.jincs.springcloud.serviceconsumer;

import org.springframework.stereotype.Service;

@Service
public class HelloRemotefallback implements HelloRemote {
    @Override
    public String hello(String name) {
        return "调用失败——____——";
    }
}

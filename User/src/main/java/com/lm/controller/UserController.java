package com.lm.controller;
import com.lm.entity.User;
import com.lm.mapper.UserMapper;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.util.List;
/**
 * @author 流明
 */
@RestController
public class UserController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private EurekaClient eurekaClient;
    @GetMapping("/USER/{id}")
    public User USER( @PathVariable String id){
        System.out.println("user被调用");
        return userMapper.getUser(id);

    }
    @GetMapping("/getMyNews/{id}")
    public List<Object> getMyNews(@PathVariable String id){
        InstanceInfo info = eurekaClient.getNextServerFromEureka("NEWS", false);
        String url = info.getHomePageUrl();
        List<Object> objects = restTemplate.getForObject(url + "NEWS/{userId}", List.class, id);
        return objects;
    }
}

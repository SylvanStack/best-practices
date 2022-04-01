package com.yuanstack.bp.springboot.helloworld.mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author hansiyuan
 * @date 2022年04月01日 22:37
 */

@Controller
@EnableAutoConfiguration
public class MongoController {

    @Autowired
    MongoTemplate mongoTemplate;

    @RequestMapping("/mongo/list")
    @ResponseBody
    List<User> mongo() {
        //Query query = new Query();
        //query.addCriteria(Criteria.where("name").is("kk"));
        //String name = mongotemplate.findOne(query, User.class).getName();
        return mongoTemplate.findAll(User.class);
    }

    @RequestMapping("/mongo/test")
    @ResponseBody
    String test() {
        //Query query = new Query();
        //query.addCriteria(Criteria.where("name").is("kk"));
        //String name = mongotemplate.findOne(query, User.class).getName();
        User user = new User();
        user.setId(new Long(System.currentTimeMillis()).toString());
        user.setName("KK" + System.currentTimeMillis() % 1000);
        user.setAge("33");
        mongoTemplate.insert(user);
        return "test ok";
    }


}

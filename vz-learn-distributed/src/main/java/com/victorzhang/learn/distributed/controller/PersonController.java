package com.victorzhang.learn.distributed.controller;

import com.victorzhang.learn.distributed.serialize.Person;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 基于SpringMVC的Restful风格Url
 *
 * @author zhangwei
 * @email zhangwei@cetiti.com
 * @date 2018-05-30 19:52:52
 */
@RestController
public class PersonController {

    @GetMapping("/person/{username}")
    public String get(@PathVariable("username") String username) {
        return username;
    }

    @PostMapping("/person")
    public String post() {
        return "person";
    }

    @PutMapping("/person")
    public String put(String username, String password) {
        Person person = new Person(username, password);
        return person.toString();
    }

    @DeleteMapping("/person/{username}")
    public String delete(@PathVariable("username") String username) {
        return username;
    }
}

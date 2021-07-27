package de.neuefische.rem21_3.spring.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    // return 200 - 204 - 404
    @GetMapping("/world")   // hello/world
    public String helloGet(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    // return 201
    @PostMapping  //hello
    public String helloPost(@RequestBody String name) {
        // create data

        return String.format("Hello %s!", name);
    }

    @PutMapping ("{name}")
    public String helloPut(@PathVariable String name, @RequestBody String nameBody) {
        // create data

        return String.format("Hello %s!", name);
    }

    @DeleteMapping
    public String helloDelete(@RequestParam(value = "name", defaultValue = "World") String name) {
        // delete data

        return String.format("Hello %s!", name);
    }
}

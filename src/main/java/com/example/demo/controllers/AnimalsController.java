package com.example.demo.controllers;

import com.example.demo.models.Greeting;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/animals")
public class AnimalsController {


    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue = "Worl",required = true) String name){
        return new Greeting(counter.incrementAndGet(), "Hello " + name,this.getClass().getSimpleName());
    }

    @GetMapping("/sayBye/{name}/{lastName}")
    public Greeting greeting2(@PathVariable("name") String name,
                              @PathVariable String lastName){
        return new Greeting(counter.incrementAndGet(), "Bye " + name + " " + lastName,this.getClass().getSimpleName());
    }
}

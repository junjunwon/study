package com.spring.web;

import com.spring.domain.ExampleRepository;
import org.springframework.stereotype.Controller;

@Controller
public class ExampleController {

    private final ExampleRepository exampleRepository;

    public ExampleController(ExampleRepository exampleRepository) {
        this.exampleRepository = exampleRepository;
    }
}

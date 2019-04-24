package de.exonity01.dataresttest.test;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("test")
public class TestController {

    private final TestServiceA testServiceA;

    @GetMapping("")
    public String getBook() {
       return testServiceA.test();
    }

}

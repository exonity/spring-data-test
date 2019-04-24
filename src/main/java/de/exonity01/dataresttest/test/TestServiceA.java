package de.exonity01.dataresttest.test;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.transaction.Transactional;

@Transactional
@RequiredArgsConstructor
@Service
public class TestServiceA {

    private final ApplicationEventPublisher applicationEventPublisher;

    public String test() {
        System.out.println("1");

        applicationEventPublisher.publishEvent(new MyEvent());

        System.out.println("2");
        return "result";
    }

}

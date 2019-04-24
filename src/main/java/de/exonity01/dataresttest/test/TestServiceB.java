package de.exonity01.dataresttest.test;

import org.springframework.context.event.EventListener;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionalEventListener;
import org.springframework.util.Assert;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.server.ResponseStatusException;

@Service
public class TestServiceB {

    @TransactionalEventListener
    public void processMyEvent(MyEvent event) {
        System.out.println("C");
    }
}

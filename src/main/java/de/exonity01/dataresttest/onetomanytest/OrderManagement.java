package de.exonity01.dataresttest.onetomanytest;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
@RequiredArgsConstructor
public class OrderManagement {

    private final @NonNull OrderRepository orderRepository;

    public Order createOrder() {
        Order parent = new Order();
        return orderRepository.save(parent);
    }

}

package de.exonity01.dataresttest.customer;

import de.exonity01.dataresttest.customer.web.CustomerCreateDto;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class CustomerManagement {

    private final @NonNull CustomerRepository customerRepository;

    private final @NonNull ApplicationEventPublisher applicationEventPublisher;

    public Customer create(@Valid CustomerCreateDto customerCreateDto) {
        Assert.notNull(customerCreateDto, "CustomerCreateDto must not be null!");

        // Create customer
        Customer customer = Customer.builder()
                .enabled(true)
                .name(customerCreateDto.getName())
                .surname(customerCreateDto.getSurname())
                .build();
        customerRepository.save(customer);

        return customer;
    }

    public Optional<Customer> findCustomerById(long customerId) {
        return customerRepository.findById(customerId);
    }

}

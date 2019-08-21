package de.exonity01.dataresttest.customer.application;

import de.exonity01.dataresttest.customer.Customer;
import de.exonity01.dataresttest.customer.web.CustomerEditDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.transaction.Transactional;
import javax.validation.Valid;

@Service
@RequiredArgsConstructor
public class CustomerApplicationService {

    @Transactional
    public Customer edit(Customer customer, @Valid CustomerEditDto customerEditDto) {
        Assert.notNull(customer, "Customer must not be null!");
        Assert.notNull(customerEditDto, "CustomerEditDto must not be null!");

        customer.edit(customerEditDto);

        return customer;
    }

    @Transactional
    public Customer enable(Customer customer) {
        Assert.notNull(customer, "Customer must not be null!");

        customer.enable();

        return customer;
    }

    @Transactional
    public Customer disable(Customer customer) {
        Assert.notNull(customer, "Customer must not be null!");

        customer.disable();

        return customer;
    }

}

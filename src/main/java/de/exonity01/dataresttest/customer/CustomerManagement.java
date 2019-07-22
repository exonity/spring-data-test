package de.exonity01.dataresttest.customer;

import de.exonity01.dataresttest.customer.web.CustomerEditDto;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.transaction.Transactional;
import javax.validation.Valid;

@Service
@Transactional
public class CustomerManagement {

    public Customer edit(Customer customer, @Valid CustomerEditDto customerEditDto) {
        Assert.notNull(customer, "Customer must not be null!");
        Assert.notNull(customerEditDto, "CustomerEditDto must not be null!");

        customer.edit(customerEditDto);

        return customer;
    }
}

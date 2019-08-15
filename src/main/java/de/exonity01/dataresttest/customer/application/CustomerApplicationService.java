package de.exonity01.dataresttest.customer.application;

import de.exonity01.dataresttest.customer.Customer;
import de.exonity01.dataresttest.customer.web.CustomerEditDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.validation.Valid;

@Service
@RequiredArgsConstructor
public class CustomerApplicationService {

    public Customer edit(Customer customer, @Valid CustomerEditDto customerEditDto) {
        Assert.notNull(customer, "Customer must not be null!");
        Assert.notNull(customerEditDto, "CustomerEditDto must not be null!");

        customer.edit(customerEditDto);

        return customer;
    }

    public Customer enableCustomerStorage(Customer customer) {
        Assert.notNull(customer, "Customer must not be null!");

        return customer.enableDocumentStorage();
    }

    public Customer disableCustomerStorage(Customer customer) {
        Assert.notNull(customer, "Customer must not be null!");

        return customer.disableDocumentStorage();
    }

}

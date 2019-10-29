package de.exonity01.dataresttest.customer.application;

import de.exonity01.dataresttest.core.exceptions.CustomException;
import de.exonity01.dataresttest.core.exceptions.InternalErrorCode;
import de.exonity01.dataresttest.customer.Customer;
import de.exonity01.dataresttest.customer.CustomerManagement;
import de.exonity01.dataresttest.customer.web.CustomerEditDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Service
@RequiredArgsConstructor
public class CustomerApplicationService {

    private final @NotNull CustomerManagement customerManagement;

    @Transactional
    public Customer edit(Customer customer, @Valid CustomerEditDto customerEditDto) {
        Assert.notNull(customer, "Customer must not be null!");
        Assert.notNull(customerEditDto, "CustomerEditDto must not be null!");

        // Precondition checks
        if (!customer.isEnabled()) {
            throw new CustomException(
                    InternalErrorCode.CustomerNotEnabled,
                    "Customer id=" + customer.getId() + " is not enabled!");
        }

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

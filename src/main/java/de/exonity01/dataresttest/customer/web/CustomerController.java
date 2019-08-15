package de.exonity01.dataresttest.customer.web;

import de.exonity01.dataresttest.core.web.BaseController;
import de.exonity01.dataresttest.customer.Customer;
import de.exonity01.dataresttest.customer.application.CustomerApplicationService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

import static org.springframework.http.ResponseEntity.ok;

@RequiredArgsConstructor
public class CustomerController extends BaseController {

    private final @NonNull CustomerApplicationService customerApplicationService;

    @PutMapping("/{id}")
    public ResponseEntity<Customer> edit(@PathVariable("id") Customer customer,
                                         @RequestBody @Valid CustomerEditDto customerEditDto) {
        assertNotNull(customer);

        return ok(customerApplicationService.edit(
                customer,
                customerEditDto));
    }

    @PutMapping("/{id}/enable-customer-storage")
    public ResponseEntity<Customer> enableCustomerStorage(@PathVariable("id") Customer customer) {
        assertNotNull(customer);

        return ok(customerApplicationService.enableCustomerStorage(customer));
    }

    @PutMapping("/{id}/disable-customer-storage")
    public ResponseEntity<Customer> disableCustomerStorage(@PathVariable("id") Customer customer) {
        assertNotNull(customer);

        return ok(customerApplicationService.disableCustomerStorage(customer));
    }

}

package de.exonity01.dataresttest.customer.web;

import de.exonity01.dataresttest.customer.Customer;
import de.exonity01.dataresttest.customer.CustomerManagement;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

import static org.springframework.http.ResponseEntity.ok;

@RequiredArgsConstructor
public class CustomerController {

    private final @NonNull CustomerManagement customerManagement;

    @PutMapping("/{id}")
    public ResponseEntity<Customer> edit(@PathVariable("id") Customer customer,
                                         @RequestBody @Valid CustomerEditDto customerEditDto) {
        if (customer == null) {
            return ResponseEntity.notFound().build();
        }

        return ok(customerManagement.edit(
                customer,
                customerEditDto));
    }

}

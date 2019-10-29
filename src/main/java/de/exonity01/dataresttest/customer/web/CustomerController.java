package de.exonity01.dataresttest.customer.web;

import de.exonity01.dataresttest.core.web.BaseController;
import de.exonity01.dataresttest.customer.Customer;
import de.exonity01.dataresttest.customer.CustomerManagement;
import de.exonity01.dataresttest.customer.application.CustomerApplicationService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customer")
public class CustomerController extends BaseController {

    private final @NonNull CustomerApplicationService customerApplicationService;

    private final @NonNull CustomerManagement customerManagement;

    @GetMapping("")
    public ResponseEntity<List<Customer>> getAll() {
        return ok(customerManagement.findAll());
    }

    @PostMapping("")
    public ResponseEntity<Customer> create(@RequestBody @Valid CustomerCreateDto customerCreateDto) {
        return ok(customerManagement.create(customerCreateDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> edit(@PathVariable("id") Customer customer,
                                         @RequestBody @Valid CustomerEditDto customerEditDto) {
        return ok(customerApplicationService.edit(
                customer,
                customerEditDto));
    }

    @PutMapping("/{id}/enable")
    public ResponseEntity<Customer> enableCustomer(@PathVariable("id") Customer customer) {
        return ok(customerApplicationService.enable(customer));
    }

    @PutMapping("/{id}/disable")
    public ResponseEntity<Customer> disableCustomerStorage(@PathVariable("id") Customer customer) {
        return ok(customerApplicationService.disable(customer));
    }

}

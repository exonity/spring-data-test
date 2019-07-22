package de.exonity01.dataresttest.customer;

import de.exonity01.dataresttest.customer.web.CustomerEditDto;
import lombok.*;
import org.springframework.util.Assert;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.Valid;

@Builder
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Getter
@Entity
@Table(name = "customer")
public class Customer {

    public boolean isDocumentStorageEnabled() {
        return true;
    }

    private String name;

    private String surname;

    public Customer edit(@Valid CustomerEditDto customerEditDto) {
        Assert.notNull(customerEditDto, "CustomerEditDto must not be null!");

        name = customerEditDto.getName();
        surname = customerEditDto.getSurname();

        return this;
    }

}

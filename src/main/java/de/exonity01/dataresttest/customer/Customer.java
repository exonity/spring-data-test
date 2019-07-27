package de.exonity01.dataresttest.customer;

import de.exonity01.dataresttest.core.BaseEntity;
import de.exonity01.dataresttest.customer.web.CustomerEditDto;
import lombok.*;
import org.springframework.util.Assert;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.Valid;

@Builder
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Getter
@Entity
@Table(name = "customer")
public class Customer extends BaseEntity {

    @Column(name = "document_storage_enabled")
    private boolean documentStorageEnabled;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    public Customer edit(@Valid CustomerEditDto customerEditDto) {
        Assert.notNull(customerEditDto, "CustomerEditDto must not be null!");

        name = customerEditDto.getName();
        surname = customerEditDto.getSurname();

        return this;
    }

    public Customer enableDocumentStorage() {
        documentStorageEnabled = true;

        return this;
    }

    public Customer disableDocumentStorage() {
        documentStorageEnabled = false;

        return this;
    }

}

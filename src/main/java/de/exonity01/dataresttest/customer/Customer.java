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

    @Column(name = "enabled")
    private boolean enabled;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "is_private")
    private boolean isPrivate;

    @Column(name = "company_name")
    private String companyName;


    public Customer edit(@Valid CustomerEditDto customerEditDto) {
        Assert.notNull(customerEditDto, "CustomerEditDto must not be null!");
        Assert.state(enabled == true, "State must be enabled!");

        isPrivate = customerEditDto.getIsPrivate();
        name = customerEditDto.getName();
        surname = customerEditDto.getSurname();

        if (!customerEditDto.getIsPrivate()) {
            companyName = customerEditDto.getCompanyName();
        }

        return this;
    }

    public Customer enable() {
        enabled = true;

        return this;
    }

    public Customer disable() {
        enabled = false;

        return this;
    }

}

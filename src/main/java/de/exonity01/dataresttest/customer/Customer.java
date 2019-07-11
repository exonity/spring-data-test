package de.exonity01.dataresttest.customer;

import de.exonity01.dataresttest.storage.Storage;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Builder
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Getter
@Entity
@Table(name = "customer")
public class Customer {
    
}

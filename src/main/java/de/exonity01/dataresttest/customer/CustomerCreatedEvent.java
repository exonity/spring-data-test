package de.exonity01.dataresttest.customer;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CustomerCreatedEvent {

    private long customerId;

}

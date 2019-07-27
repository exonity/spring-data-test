package de.exonity01.dataresttest.customerstorage.listener;

import de.exonity01.dataresttest.customer.CustomerCreatedEvent;
import de.exonity01.dataresttest.customerstorage.StorageManagement;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomerCreatedListener {

    private final @NonNull StorageManagement storageManagement;

    @EventListener
    public void onCustomerCreatedListener(CustomerCreatedEvent customerCreatedEvent) {
        storageManagement.create(customerCreatedEvent.getCustomerId());
    }

}

package de.exonity01.dataresttest.customer.application;

import de.exonity01.dataresttest.customer.Customer;
import de.exonity01.dataresttest.customer.CustomerManagement;
import de.exonity01.dataresttest.customer.web.CustomerCreateDto;
import de.exonity01.dataresttest.weather.StupidWeatherCheck;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.validation.Valid;

@Service
@RequiredArgsConstructor
public class CreateCustomerService {

    private final CustomerManagement customerManagement;

    private final StupidWeatherCheck stupidWeatherCheck;

    public Customer createCustomer(@Valid CustomerCreateDto customerCreateDto) {
        Assert.notNull(customerCreateDto, "CustomerCreateDto must not be null!");

        // Do stupid weather check
        if (!stupidWeatherCheck.weatherIsGood()) {
            throw new BadWeatherException();
        }

        return customerManagement.create(customerCreateDto);
    }

}

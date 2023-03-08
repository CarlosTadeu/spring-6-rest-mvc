package guru.springframework.spring6restmvc.bootstrap;

import guru.springframework.spring6restmvc.entities.Beer;
import guru.springframework.spring6restmvc.entities.Customer;
import guru.springframework.spring6restmvc.model.BeerStyle;
import guru.springframework.spring6restmvc.repositories.BeerRepository;
import guru.springframework.spring6restmvc.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class BootstrapData implements CommandLineRunner {

    private final BeerRepository beerRepository;
    private final CustomerRepository customerRepository;

    @Override
    public void run(String... args) throws Exception {

        loadBeerData();
        loadCustomerData();
    }

    private void loadBeerData() {
        Beer beer = Beer.builder()
                .beerName("First Beer")
                .beerStyle(BeerStyle.GOSE)
                .upc("01")
                .quantityOnHand(0)
                .price(new BigDecimal("7.89"))
                .createdDate(LocalDateTime.now())
                .build();

        beerRepository.save(beer);
    }

    private void loadCustomerData() {
        Customer customer = Customer.builder()
                .name("First Customer")
                .createdDate(LocalDateTime.now())
                .build();

        customerRepository.save(customer);
    }
}

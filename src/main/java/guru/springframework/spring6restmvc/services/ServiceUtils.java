package guru.springframework.spring6restmvc.services;

import guru.springframework.spring6restmvc.entities.Beer;
import guru.springframework.spring6restmvc.entities.Customer;
import guru.springframework.spring6restmvc.model.BeerDTO;
import guru.springframework.spring6restmvc.model.CustomerDTO;
import org.springframework.util.StringUtils;

public class ServiceUtils {

    private ServiceUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static void pathCustomer(CustomerDTO customerDTO, Customer foundCustomer) {
        if (StringUtils.hasText(customerDTO.getName()))
            foundCustomer.setName(customerDTO.getName());
    }

    public static void pathBeer(BeerDTO beerDTO, Beer foundBeer) {
        if (StringUtils.hasText(beerDTO.getBeerName())) {
            foundBeer.setBeerName(beerDTO.getBeerName());
        }
        if (beerDTO.getBeerStyle() != null) {
            foundBeer.setBeerStyle(beerDTO.getBeerStyle());
        }
        if (beerDTO.getPrice() != null) {
            foundBeer.setPrice(beerDTO.getPrice());
        }
        if (beerDTO.getQuantityOnHand() != null) {
            foundBeer.setQuantityOnHand(beerDTO.getQuantityOnHand());
        }
        if (StringUtils.hasText(beerDTO.getUpc())) {
            foundBeer.setUpc(beerDTO.getUpc());
        }
    }
}

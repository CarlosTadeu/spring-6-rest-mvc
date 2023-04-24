package guru.springframework.spring6restmvc.repositories;

import guru.springframework.spring6restmvc.entities.Beer;
import guru.springframework.spring6restmvc.model.BeerStyle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface BeerRepository extends JpaRepository<Beer, UUID> {
    // find beers by name
    List<Beer> findAllByBeerNameIsLikeIgnoreCase(String beerName);

    // find beers by style
    List<Beer> findAllByBeerStyle(BeerStyle beerStyle);

    // find beers by name and Style
    List<Beer> findAllByBeerNameIsLikeIgnoreCaseAndBeerStyle(String beerName, BeerStyle beerStyle);
}

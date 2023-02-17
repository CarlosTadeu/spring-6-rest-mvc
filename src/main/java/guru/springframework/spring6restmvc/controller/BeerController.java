package guru.springframework.spring6restmvc.controller;

import guru.springframework.spring6restmvc.model.Beer;
import guru.springframework.spring6restmvc.services.BeerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping(BeerController.API_V1_BEER)
public class BeerController {

    public static final String API_V1_BEER = "/api/v1/beer";
    private final BeerService beerService;

    @PostMapping
    public ResponseEntity<Void> handlePost(@RequestBody Beer beer) {
        Beer savedBeer = beerService.saveNewBeer(beer);

        HttpHeaders headers = new HttpHeaders();
        Path locationPath = Paths.get(API_V1_BEER, savedBeer.getId().toString());
        headers.add("Location", locationPath.toString());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @GetMapping()
    public List<Beer> listBeers(){
        return beerService.listBeers();
    }

    @GetMapping(value = "{beerId}")
    public Beer getBeerById(@PathVariable("beerId") UUID beerId) {
        log.debug("Get Beer by Id - in controller");
        return beerService.getBeerById(beerId);
    }
}

package guru.springframework.spring6restmvc.controller;

import guru.springframework.spring6restmvc.model.Customer;
import guru.springframework.spring6restmvc.services.CustomerService;
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
@RequestMapping(CustomerController.API_V1_CUSTOMER)
public class CustomerController {

    public static final String API_V1_CUSTOMER = "/api/v1/customer";
    private final CustomerService customerService;

    @PatchMapping(value = "{customerId}")
    public ResponseEntity<Void> updatePatchById(@PathVariable("customerId") UUID customerId,
                                                @RequestBody Customer customer) {
        customerService.patchCustomerById(customerId, customer);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(value = "{customerId}")
    public ResponseEntity<Void> deleteById(@PathVariable("customerId") UUID customerId) {
        customerService.deleteCustomerById(customerId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("{customerId}")
    public ResponseEntity<Void> updateById(@PathVariable("customerId") UUID customerId,
                                           @RequestBody Customer customer) {
        customerService.updateCustomerById(customerId, customer);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity<Void> handlePost(@RequestBody Customer customer) {
        Customer savedCustomer = customerService.saveNewCustomer(customer);

        HttpHeaders headers = new HttpHeaders();
        Path locationPath = Paths.get(API_V1_CUSTOMER, savedCustomer.getId().toString());
        headers.add("Location", locationPath.toString());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @GetMapping()
    public List<Customer> listCustomers(){
        return customerService.listCustomers();
    }

    @GetMapping(value = "{customerId}")
    public Customer getBeerById(@PathVariable("customerId") UUID customerId) {
        log.debug("Get Customer by Id");
        return customerService.getCustomerById(customerId);
    }
}

package com.example.HotelBooking_demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.example.HotelBooking_demo.model.Customer;
import com.example.HotelBooking_demo.services.CustomerService;
import java.util.List;
@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    // :white_check_mark: Get all customers
    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customers = customerService.getAllCustomers();
        return ResponseEntity.ok(customers);
    }
    // :white_check_mark: Get customer by ID
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
        Customer customer = customerService.getCustomerById(id);
        return (customer != null) ? ResponseEntity.ok(customer) : ResponseEntity.notFound().build();
    }
    // :white_check_mark: Add a new customer (Returns 201 Created)
    @PostMapping
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
        Customer newCustomer = customerService.addCustomer(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(newCustomer);
    }
    // :white_check_mark: Update an existing customer
    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customerDetails) {
        Customer updatedCustomer = customerService.updateCustomer(id, customerDetails);
        return (updatedCustomer != null) ? ResponseEntity.ok(updatedCustomer) : ResponseEntity.notFound().build();
    }
    // :white_check_mark: Delete a customer
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        boolean isDeleted = customerService.deleteCustomer(id);
        return (isDeleted) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
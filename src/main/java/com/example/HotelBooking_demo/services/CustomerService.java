package com.example.HotelBooking_demo.services;
import com.example.HotelBooking_demo.model.Customer;
import com.example.HotelBooking_demo.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class CustomerService {
    @Autowired
    private CustomerRepo customerRepository;
    // :white_check_mark: Fetch all customers from database
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
    // :white_check_mark: Save customer to database
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
    // :white_check_mark: Get customer by ID from database
    public Customer getCustomerById(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        return customer.orElse(null); // Returns customer if found, otherwise null
    }
    // :white_check_mark: Update existing customer
    public Customer updateCustomer(Long id, Customer updatedCustomer) {
        if (customerRepository.existsById(id)) {
            updatedCustomer.setId(id); // Ensure ID remains the same
            return customerRepository.save(updatedCustomer);
        }
        return null; // Customer not found
    }
    // :white_check_mark: Delete customer by ID
    public boolean deleteCustomer(Long id) {
        if (customerRepository.existsById(id)) {
            customerRepository.deleteById(id);
            return true;
        }
        return false; // Customer not found
    }
}
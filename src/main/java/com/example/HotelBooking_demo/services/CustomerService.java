package com.example.HotelBooking_demo.services;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import com.example.HotelBooking_demo.model.Customer;
@Service
public class CustomerService {
    private List<Customer> customers = new ArrayList<>();
    public List<Customer> getAllCustomers() {
        return customers;
    }
    public Customer addCustomer(Customer customer) {
        customers.add(customer);
        return customer;
    }
    public Customer getCustomerById(int id) {
        return customers.stream()
                .filter(customer -> customer.getId() == id)
                .findFirst()
                .orElse(null);
    }
    public Customer updateCustomer(int id, Customer updatedCustomer) {
        for (int i = 0; i < customers.size(); i++) {
            Customer customer = customers.get(i);
            if (customer.getId() == id) {
                customers.set(i, updatedCustomer);
                return updatedCustomer;
            }
        }
        return null;
    }
    public boolean deleteCustomer(int id) {
        return customers.removeIf(customer -> customer.getId() == id);
    }
}
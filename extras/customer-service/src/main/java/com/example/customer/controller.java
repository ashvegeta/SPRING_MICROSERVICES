package com.example.customer;

import com.example.customer.Customer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

@RequestMapping("/customers")
@RestController

public class controller
{
    private List<Customer> customers = new ArrayList<>(
        Arrays.asList(
            new Customer(1, "Product A"),
            new Customer(2, "Product B"),
            new Customer(3, "Product C"),
            new Customer(4, "Product D"),
            new Customer(5, "Product E"))
    );

    @GetMapping
    public List<Customer> getAll()
    {
        return customers;
    }

     @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable int id) 
    {
        return customers.stream()
                     .filter(customer -> customer.getId() == id)
                     .findFirst()
                     .orElseThrow(IllegalArgumentException::new);
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable int id) 
    {
        return customers.stream()
                     .filter(customer -> customer.getId() == id)
                     .findFirst()
                     .orElseThrow(IllegalArgumentException::new);
    }

    @GetMapping("/delete/{id}")
    public List<Customer> deleteCustomerById(@PathVariable int id)
    {
       for(int i = customers.size() - 1; i >= 0; --i) 
        {
            if(customers.get(i).getId()==id)
            {
                    customers.remove(i);
            }
        }

        return customers;
    }

}
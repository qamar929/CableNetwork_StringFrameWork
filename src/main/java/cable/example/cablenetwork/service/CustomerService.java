package cable.example.cablenetwork.service;


import cable.example.cablenetwork.entity.Customer;
import cable.example.cablenetwork.exceptions.CustomerException;
import cable.example.cablenetwork.exceptions.CustomerResponseException;
import cable.example.cablenetwork.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

@Autowired
private CustomerRepository customerRepository;


    public List<Customer> getAll()
    {

        return customerRepository.findAll();
    }


public Customer getById(Long id)
{
    Optional<Customer> customer = customerRepository.findById(id);
    if(customer.isPresent())
    {
        return customer.get();
    }

   throw  new CustomerException("Customer with" + id + "does not exists!");
}

public Customer create(Customer customer)
{

customerRepository.save(customer);
return  customer;

}

    public Customer update(Customer customer)
    {

        customerRepository.save(customer);
        return  customer;
    }



    public  boolean delete(Long id)
    {
        Optional<Customer> customer = customerRepository.findById(id);
        if(customer.isPresent())
        {
            customerRepository.delete(customer.get());
            return true;
        }

        throw  new CustomerException("Customer with" + id + "does not exists!");

    }
}

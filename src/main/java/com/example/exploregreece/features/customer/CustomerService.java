package com.example.exploregreece.features.customer;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    private CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public List<CustomerResponse> getAllCustomers() {
        Iterable<Customer> retrievedCustomers = repository.findAll();
        List<CustomerResponse> customersToReturn = new ArrayList<>();
        for (Customer customer: retrievedCustomers) {
            customersToReturn.add(mapToCustomerResponse(customer));
        }
        return customersToReturn;
    }
    public List<CustomerResponse> getCustomersByStatus(Status status) {
        Iterable<Customer> retrievedCustomers = repository.findAll();
        List<CustomerResponse> customersToReturn = new ArrayList<>();
        for (Customer customer: retrievedCustomers) {
            if (customer.getStatus() == status) {
                CustomerResponse mappedCustomer = mapToCustomerResponse(customer);
                customersToReturn.add(mappedCustomer);
            }
        }
        return customersToReturn;
    }


    public CustomerResponse createCustomer(CustomerInput input){
        Customer customerToSave = mapFromInputToCustomer(input);
        Customer savedCustomer = repository.save(customerToSave);
        CustomerResponse customerToReturn = mapToCustomerResponse(savedCustomer);
        return  customerToReturn;

    }

    public CustomerResponse deleteCustomerById(long id) {
        Optional<Customer> customerToDelete = repository.findById(id);
        repository.deleteById(id);
        CustomerResponse customerToReturn = mapToCustomerResponse(customerToDelete.get());
        return customerToReturn;
    }

    public CustomerResponse updateCustomerById(CustomerInput input, long id) throws CustomerNotFoundException {
        Optional<Customer> retrievedCustomerOptional = repository.findById(id);
        if (retrievedCustomerOptional.isEmpty())
            throw new CustomerNotFoundException();
        else {
            Customer retrievedCustomer = retrievedCustomerOptional.get();
            Customer customerToUpdate = retrievedCustomer;
            if (input.getName()!=null){
                customerToUpdate.setName(input.getName());
            }
            if (input.getSurname()!=null){
                customerToUpdate.setSurname(input.getSurname());
            }
            if (input.getEmail()!=null){
                customerToUpdate.setEmail(input.getEmail());
            }
            if (input.getTelephone()!=null){
                customerToUpdate.setTelephone(input.getTelephone());
            }
            if (input.getNumberOfBookings()!=null){
                customerToUpdate.setNumberOfBookings(input.getNumberOfBookings());
            }
            Customer savedCustomer = repository.save(customerToUpdate);
            return mapToCustomerResponse(savedCustomer);

        }

    }

    private Customer mapFromInputToCustomer(CustomerInput input) {
        return new Customer(
                input.getName(),
                input.getSurname(),
                input.getEmail(),
                input.getTelephone(),
                mapCustomerStatus(input.getNumberOfBookings()),
                input.getNumberOfBookings()

        );
    }
    private Status mapCustomerStatus(int numberOfBookings) {
        if(numberOfBookings < 5)
            return Status.NEW;
        else if(numberOfBookings <10)
            return Status.LOYAL;
        else if(numberOfBookings <15)
            return Status.GOLD;
        else
            return Status.PLATINUM;
    }

    private CustomerResponse mapToCustomerResponse(Customer customer){
        return new CustomerResponse(
                customer.getId(),
                mapFullName(customer),
                customer.getEmail(),
                customer.getTelephone(),
                customer.getStatus(),
                customer.getNumberOfBookings()
        );
    }

    private String mapFullName(Customer customer) {
        return customer.getName() + " " + customer.getSurname();
    }

}

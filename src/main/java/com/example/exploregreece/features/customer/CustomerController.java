package com.example.exploregreece.features.customer;

import com.example.exploregreece.features.CustomError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.transform.OutputKeys;
import java.util.List;

@RestController
public class CustomerController {

    private CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @GetMapping(path = "customers")
    public List<CustomerResponse> getAllCustomers() {
        return service.getAllCustomers();
    }

    @GetMapping(path = "customer/{status}")
    public ResponseEntity getCustomerByStatus(@PathVariable("status") String status) {
        if (status.equalsIgnoreCase("new"))
            return new ResponseEntity(service.getCustomersByStatus(Status.NEW), HttpStatus.OK);
        if (status.equalsIgnoreCase("loyal"))
            return new ResponseEntity(service.getCustomersByStatus(Status.LOYAL), HttpStatus.OK);
        if (status.equalsIgnoreCase("platinum"))
            return new ResponseEntity(service.getCustomersByStatus(Status.PLATINUM), HttpStatus.OK);
        if (status.equalsIgnoreCase("gold"))
            return new ResponseEntity(service.getCustomersByStatus(Status.GOLD), HttpStatus.OK);
        else
            return new ResponseEntity(new CustomError(0,
                    "Wrong Customer Status",
                    "Customer status must be one of: new, loyal, gold, platinum"),
                    HttpStatus.BAD_REQUEST);
    }

    @PostMapping(path = "customer")
    public ResponseEntity createCustomer(@RequestBody CustomerInput customerInput){
        if (!customerInput.getEmail().contains("@"))
            return new ResponseEntity(new CustomError(0,"Wrong mail",
                    "Mail should contain @"), HttpStatus.BAD_REQUEST);
        else if (customerInput.getName().length() < 3 || customerInput.getSurname().length()<3)
            return new ResponseEntity(new CustomError(0,"Wrong name",
                    "Your name can not be less than 3 characters"), HttpStatus.BAD_REQUEST);
        else if (customerInput.getNumberOfBookings()<0)
            return new ResponseEntity(new CustomError(0,"Negative Number of Bookings",
                    "Number of bookings can not be negative"), HttpStatus.BAD_REQUEST);

        return new ResponseEntity(service.createCustomer(customerInput), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "customer/{id}")
    public ResponseEntity deleteCustomerById(@PathVariable long id){
        return new ResponseEntity(service.deleteCustomerById(id), HttpStatus.OK  );
    }

    @PatchMapping(path = "customer/{id}")
    public ResponseEntity patchCustomerById(@RequestBody CustomerInput input,
                                            @PathVariable long id){
        try {
            return new ResponseEntity(service.updateCustomerById(input,id), HttpStatus.OK);
        } catch (CustomerNotFoundException e) {
            CustomError error = new CustomError(0,"Wrong input","The customer does not exist");
            return new ResponseEntity(error,HttpStatus.BAD_REQUEST);
        }
    }


}

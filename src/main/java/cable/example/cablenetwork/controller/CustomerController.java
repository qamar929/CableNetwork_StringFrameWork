package cable.example.cablenetwork.controller;


import cable.example.cablenetwork.entity.Customer;
import cable.example.cablenetwork.service.CustomerService;
import cable.example.cablenetwork.service.ValidationErrorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@CrossOrigin
@RequestMapping("/customer")
public class CustomerController {

@Autowired
    private CustomerService customerService;

    @Autowired
    private ValidationErrorService validationService;




    @GetMapping
    public  ResponseEntity<?> getAll()
    {
        return  new ResponseEntity<>(customerService.getAll(),HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id)
    {
        return new ResponseEntity<>(customerService.getById(id), HttpStatus.OK);

    }
    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody Customer customer, BindingResult result)
    {

        ResponseEntity error = validationService.Validate(result);
        if(error !=null ) return  error;

        Customer saved  =customerService.create(customer);

        return  new ResponseEntity<Customer>(saved,HttpStatus.CREATED);
    }



    @DeleteMapping("/{id}")
    public  ResponseEntity<?> delete(@PathVariable Long id)
    {
        customerService.delete(id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }




    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,@Valid @RequestBody Customer customer, BindingResult result)
    {

        ResponseEntity error = validationService.Validate(result);
        if(error !=null ) return  error;

        customer.setId(id);
        Customer saved  =customerService.update(customer);

        return  new ResponseEntity<Customer>(saved,HttpStatus.OK);
    }



}

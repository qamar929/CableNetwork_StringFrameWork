package cable.example.cablenetwork.controller;


import cable.example.cablenetwork.entity.Transaction;
import cable.example.cablenetwork.service.TransactionService;
import cable.example.cablenetwork.service.ValidationErrorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/transaction")
@CrossOrigin
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @Autowired
    private ValidationErrorService validationService;

    @GetMapping
    public ResponseEntity<?> getAll()
    {
        return  new ResponseEntity<>(transactionService.getAll(), HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable long id)
    {
        return  new ResponseEntity<>(transactionService.getById(id), HttpStatus.OK);

    }
    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody Transaction transaction, BindingResult result)
    {

        ResponseEntity error = validationService.Validate(result);
        if(error !=null ) return  error;

        Transaction transactionsaved  =transactionService.create(transaction);

        return  new ResponseEntity<Transaction>(transactionsaved,HttpStatus.CREATED);
    }



    @DeleteMapping("/{id}")
    public  ResponseEntity<?> delete(@PathVariable Long id)
    {
        transactionService.delete(id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }




    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody Transaction transaction, BindingResult result)
    {

        ResponseEntity error = validationService.Validate(result);
        if(error !=null ) return  error;

        transaction.setId(id);
        Transaction transactionsaved  =transactionService.update(transaction);

        return  new ResponseEntity<Transaction>(transactionsaved,HttpStatus.OK);
    }



}

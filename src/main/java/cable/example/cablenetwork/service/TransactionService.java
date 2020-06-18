package cable.example.cablenetwork.service;


import cable.example.cablenetwork.entity.Transaction;
import cable.example.cablenetwork.exceptions.CustomerException;
import cable.example.cablenetwork.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;


    public List<Transaction> getAll()
    {


            return transactionRepository.findAll();


    }



    public  Transaction getById(Long id)
    {


            Optional<Transaction> transaction = transactionRepository.findById(id);
            if (transaction.isPresent()) {
                return transaction.get();
            }

        throw  new CustomerException("Transaction with" + id + "does not exists!");

    }

    public Transaction create(Transaction transaction)
    {


            transactionRepository.save(transaction);
            return transaction;




    }

    public Transaction update(Transaction transaction)
    {

            transactionRepository.save(transaction);
            return transaction;

    }

    public  boolean delete(Long id)
    {


            Optional<Transaction> transaction = transactionRepository.findById(id);
            if (transaction.isPresent()) {
                transactionRepository.delete(transaction.get());
                return true;
            }
            throw  new CustomerException("Transaction with" + id + "does not exists!");


    }


}

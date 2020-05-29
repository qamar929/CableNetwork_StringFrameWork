package cable.example.cablenetwork.repository;

import cable.example.cablenetwork.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {


}

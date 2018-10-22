package br.com.conciliator.repository;

import java.util.List;

import br.com.conciliator.entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface CustomerRepository extends MongoRepository<Customer, String> {

    Customer findByFirstName(String firstName);
    Customer findByDocumentNumber(String documentNumber);
    Customer findByEmail(String email);

    List<Customer> findByLastName(String lastName);

}

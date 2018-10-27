package br.com.rh.repository;

import java.util.List;

import br.com.rh.entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface CustomerRepository extends MongoRepository<Customer, String> {

    Customer findByFirstName(String firstName);
    Customer findByDocumentNumber(String documentNumber);
    Customer findByEmail(String email);

    List<Customer> findByLastName(String lastName);

}

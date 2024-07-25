package QLIA_Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import QLIA_Model.Customer;
@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
}

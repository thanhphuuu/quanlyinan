package QLIA_Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import QLIA_Model.Bill;
@Repository
public interface IBillRepository extends JpaRepository<Bill, Integer> {
}

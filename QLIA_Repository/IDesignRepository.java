package QLIA_Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import QLIA_Model.Design;

@Repository
public interface IDesignRepository extends JpaRepository<Design, Integer> {
}

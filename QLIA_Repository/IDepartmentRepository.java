package QLIA_Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import QLIA_Model.Department;
@Repository
public interface IDepartmentRepository extends JpaRepository<Department, Integer> {

}

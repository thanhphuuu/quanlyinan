package QLIA_Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import QLIA_Model.Role;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Integer> {
}

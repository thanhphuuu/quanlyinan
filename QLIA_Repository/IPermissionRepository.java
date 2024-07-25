package QLIA_Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import QLIA_Model.Permission;

@Repository
public interface IPermissionRepository extends JpaRepository<Permission, Integer> {
}

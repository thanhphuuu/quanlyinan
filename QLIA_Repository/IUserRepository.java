package QLIA_Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import QLIA_Model.User;
@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {
	List<User> findByDepartmentId(int departmentId);
    List<User> findByRole(String role);
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    Optional<User> findByResetToken(String resetToken);
    Optional<User> findByUserName(String userName);
}

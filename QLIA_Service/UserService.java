package QLIA_Service;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import QLIA_Model.Department;
import QLIA_Model.User;
import QLIA_Repository.IDepartmentRepository;
import QLIA_Repository.IUserRepository;
@Service
public class UserService {
    @Autowired
    private IUserRepository userRepository;
    private IDepartmentRepository departmentRepository;
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    public User createUser(User user) {
        return userRepository.save(user);
    }
    public Optional<User> getUserById(int id) {
        return userRepository.findById(id);
    }
    public User saveUser(User user) {
        return userRepository.save(user);
    }
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }
    
    public User updateUser(int id, User userDetails) {
        User user = userRepository.findById(id)
                                  .orElseThrow(() -> new NoSuchElementException("User not found with id: " + id));
        user.setUserName(userDetails.getUserName());
        user.setPassword(userDetails.getPassword());
        user.setFullName(userDetails.getFullName());
        user.setDateOfBirth(userDetails.getDateOfBirth());
        user.setAvatar(userDetails.getAvatar());
        user.setEmail(userDetails.getEmail());
        user.setCreateTime(userDetails.getCreateTime());
        user.setUpdateTime(userDetails.getUpdateTime());
        user.setPhoneNumber(userDetails.getPhoneNumber());
        user.setActive(userDetails.isActive());
        user.setTeam(userDetails.getTeam());
        return userRepository.save(user);
    }
    public List<User> getUsersByDepartment(int departmentId) {
        return userRepository.findByDepartmentId(departmentId);
    }

    public User changeUserDepartment(int userId, int departmentId) {
        User user = userRepository.findById(userId).orElseThrow();
        Department department = departmentRepository.findById(departmentId).orElseThrow();
        user.setDepartment(department);
        return userRepository.save(user);
    }

    public List<User> getUsersByRole(String role) {
        return userRepository.findByRole(role);
    }
    
    
}

package QLIA_Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import QLIA_Model.User;
import QLIA_Service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id) {
        return userService.getUserById(id).orElseThrow();
    }

    @GetMapping("/department/{departmentId}")
    public List<User> getUsersByDepartment(@PathVariable int departmentId) {
        return userService.getUsersByDepartment(departmentId);
    }

    @PutMapping("/change-department/{userId}")
    public User changeUserDepartment(@PathVariable int userId, @RequestBody int departmentId) {
        return userService.changeUserDepartment(userId, departmentId);
    }

    @GetMapping("/role/{role}")
    public List<User> getUsersByRole(@PathVariable String role) {
        return userService.getUsersByRole(role);
    }
}


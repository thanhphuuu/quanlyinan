package QLIA_Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import QLIA_Model.Department;
import QLIA_Model.User;
import QLIA_Repository.IDepartmentRepository;
import QLIA_Repository.IUserRepository;

public class DepartmentService {
	@Autowired
    private IDepartmentRepository departmentRepository;
	private IUserRepository userRepository;

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Optional<Department> getDepartmentById(int id) {
        return departmentRepository.findById(id);
    }

    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public void deleteDepartment(int id) {
        departmentRepository.deleteById(id);
    }

    public Department changeManager(int departmentId, int managerId) {
        Department department = departmentRepository.findById(departmentId).orElseThrow();
        User manager = userRepository.findById(managerId).orElseThrow();
        department.setManager(manager);
        return departmentRepository.save(department);
    }
}

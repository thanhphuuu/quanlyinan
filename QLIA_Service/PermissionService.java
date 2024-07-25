package QLIA_Service;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import QLIA_Model.Permission;
import QLIA_Repository.IPermissionRepository;

@Service
public class PermissionService {

    @Autowired
    private IPermissionRepository permissionRepository;
    public List<Permission> getAllPermissions() {
        return permissionRepository.findAll();
    }
    public Permission createPermission(Permission permission) {
        return permissionRepository.save(permission);
    }
    public Permission updatePermission(int id, Permission permissionDetails) {
        Permission permission = permissionRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Permission not found with id: " + id));
        permission.setUser(permissionDetails.getUser());
        permission.setRole(permissionDetails.getRole());
        return permissionRepository.save(permission);
    }
}

package QLIA_Service;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import QLIA_Model.Project;
import QLIA_Model.User;
import QLIA_Repository.IProjectRepository;
import QLIA_Repository.IUserRepository;

@Service
public class ProjectService {

    @Autowired
    private IProjectRepository projectRepository;
    @Autowired
    private IUserRepository userRepository;
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }
    public Project createProject(Project project) {
        User leader = userRepository.findById(project.getEmployee().getId())
                                     .orElseThrow(() -> new NoSuchElementException("Leader not found"));
        project.setEmployee(leader);
        return projectRepository.save(project);
    }
    public Project updateProject(int id, Project projectDetails) {
        Project project = projectRepository.findById(id)
                                            .orElseThrow(() -> new NoSuchElementException("Project not found with id: " + id));
        project.setProjectName(projectDetails.getProjectName());
        project.setRequestDescriptionFromCustomer(projectDetails.getRequestDescriptionFromCustomer());
        project.setStartDate(projectDetails.getStartDate());
        project.setExpectedEndDate(projectDetails.getExpectedEndDate());
        project.setProjectStatus(projectDetails.getProjectStatus());
        project.setCustomer(projectDetails.getCustomer());
        project.setEmployee(projectDetails.getEmployee());
        return projectRepository.save(project);
    }
}

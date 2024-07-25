package QLIA_Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import QLIA_Model.Project;
@Repository
public interface IProjectRepository extends JpaRepository<Project, Integer> {
}

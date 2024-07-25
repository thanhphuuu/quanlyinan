package QLIA_Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import QLIA_Model.Team;
@Repository
public interface ITeamRepository extends JpaRepository<Team, Integer> {
}

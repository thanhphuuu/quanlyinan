package QLIA_Service;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import QLIA_Model.Team;
import QLIA_Model.User;
import QLIA_Repository.ITeamRepository;
import QLIA_Repository.IUserRepository;

@Service
public class TeamService {
    @Autowired
    private ITeamRepository teamRepository;
    @Autowired
    private IUserRepository userRepository;
    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }
    public Team createTeam(Team team) {
        User manager = userRepository.findById(team.getManager().getId())
                                     .orElseThrow(() -> new NoSuchElementException("Manager not found"));
        team.setManager(manager);
        return teamRepository.save(team);
    }
    public Team updateTeam(int id, Team teamDetails) {
        Team team = teamRepository.findById(id)
                                  .orElseThrow(() -> new NoSuchElementException("Team not found with id: " + id));
        User manager = userRepository.findById(teamDetails.getManager().getId())
                                     .orElseThrow(() -> new NoSuchElementException("Manager not found"));
        team.setName(teamDetails.getName());
        team.setDescription(teamDetails.getDescription());
        team.setNumberOfMember(teamDetails.getNumberOfMember());
        team.setCreateTime(teamDetails.getCreateTime());
        team.setUpdateTime(teamDetails.getUpdateTime());
        team.setManager(manager);
        return teamRepository.save(team);
    }
}

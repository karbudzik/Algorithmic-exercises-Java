package team_reshuffle;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class ReshuffleTest {

    @Test
    public void should_have_empty_lists_in_reshuffle_before_calling_generateNewTeams_method() {
        // given:
        Reshuffle reshuffle = new Reshuffle();

        // when:
        List<Team> oldTeams = reshuffle.getOldTeams();
        List<Team> newTeams = reshuffle.getNewTeams();

        // then:
        assertEquals(0, newTeams.size());
        assertEquals(0, oldTeams.size());
    }

    @Test
    public void should_old_and_new_teams_list_have_same_number_of_teams() {
        // given:
        Reshuffle reshuffle = new Reshuffle();

        // when:
        reshuffle.setOldTeams(generateOldTeams());
        reshuffle.generateNewTeams();

        // then:
        assertEquals(reshuffle.getOldTeams().size(), reshuffle.getNewTeams().size());
    }

    @Test
    public void should_old_and_new_teams_list_have_same_number_of_students() {
        // given:
        Reshuffle reshuffle = new Reshuffle();

        // when:
        reshuffle.setOldTeams(generateOldTeams());
        int oldTeamsStudentsNumber = reshuffle.getOldTeams().stream()
                .reduce(0, (partialResult, team) -> partialResult + team.getMembers().size(), Integer::sum);
        reshuffle.generateNewTeams();
        int newTeamsStudentsNumber = reshuffle.getNewTeams().stream()
                .reduce(0, (partialResult, team) -> partialResult + team.getMembers().size(), Integer::sum);

        // then:
        assertEquals(oldTeamsStudentsNumber, newTeamsStudentsNumber);
    }

    @Test
    public void should_generate_teams_with_members_that_were_not_together_in_previous_round() {
        // given:
        Reshuffle reshuffle = new Reshuffle();

        // when:
        reshuffle.setOldTeams(generateOldTeams());
        reshuffle.generateNewTeams();

        // then:
        assertFalse(checkIfAnyTeamHasElementsFromPreviousTeams(reshuffle.getNewTeams()));
    }

    private List<Team> generateOldTeams() {
        List<Team> oldTeamsMock = new ArrayList<>();
        Team team1 = new Team();
        team1.addMember("A1");
        team1.addMember("A2");
        team1.addMember("A3");
        team1.addMember("A4");

        Team team2 = new Team();
        team2.addMember("B1");
        team2.addMember("B2");
        team2.addMember("B3");
        team2.addMember("B4");

        Team team3 = new Team();
        team3.addMember("C1");
        team3.addMember("C2");
        team3.addMember("C3");
        team3.addMember("C4");

        Team team4 = new Team();
        team4.addMember("D1");
        team4.addMember("D2");
        team4.addMember("D3");
        team4.addMember("D4");

        oldTeamsMock.add(team1);
        oldTeamsMock.add(team2);
        oldTeamsMock.add(team3);
        oldTeamsMock.add(team4);

        return oldTeamsMock;
    }

    private boolean checkIfAnyTeamHasElementsFromPreviousTeams(List<Team> teamsList) {
        teamsList.stream()
                .map(team -> team.getMembers().stream()
                        .map(s -> s.substring(0, 1)));

        return teamsList.stream()
                .anyMatch(team -> team.getMembers().size() != new HashSet<>(team.getMembers()).size());
    }
}
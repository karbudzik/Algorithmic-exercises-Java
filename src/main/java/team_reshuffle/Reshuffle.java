package team_reshuffle;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Reshuffle {

    private List<Team> oldTeams = new ArrayList<>();
    private List<Team> newTeams = new ArrayList<>();

    public void generateNewTeams() {
        final int STUDENTS_NUMBER_IN_TEAM = 4;
        final int TEAMS_COUNT = oldTeams.size();

        int numberOfStudentsLeft = STUDENTS_NUMBER_IN_TEAM * TEAMS_COUNT;
        int teamIndex = 0;

        while (numberOfStudentsLeft > 0) {
            Team newTeam = new Team();
            for (int i = 1; i <= STUDENTS_NUMBER_IN_TEAM; i++) {
                teamIndex = (teamIndex < TEAMS_COUNT) ? teamIndex : 0;
                boolean successfullyAdded = false;
                while (!successfullyAdded && teamIndex<=TEAMS_COUNT) {
                    if (oldTeams.get(teamIndex).getMembers().size() != 0) {
                        newTeam.addMember(oldTeams.get(teamIndex).getMembers().remove(0));
                        successfullyAdded = true;
                    }
                    teamIndex++;
                }
            }
            newTeams.add(newTeam);
            numberOfStudentsLeft -= STUDENTS_NUMBER_IN_TEAM;
        }
    }

    public void loadOldTeams(String fileName) {
        oldTeams.clear();
        try {
            Scanner s = new Scanner(new File(fileName));
            Team team = null;
            while (s.hasNext()) {
                String nextLine = s.next();
                if (nextLine.contentEquals("#")) {
                    team = null;
                } else {
                    if (team == null) {
                        team = new Team();
                        oldTeams.add(team);
                    }
                    team.addMember(nextLine);
                }
            }
            s.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<Team> getOldTeams() {
        return oldTeams;
    }

    public void setOldTeams(List<Team> list) {
        oldTeams = list;
    }

    public List<Team> getNewTeams() {
        return newTeams;
    }

    public void printOldTeams() {
        System.out.println("Old: " + oldTeams);
    }

    public void printNewTeams() {
        System.out.println("New: " + newTeams);
    }

    public static void main(String[] args) {
        Reshuffle reshuffle = new Reshuffle();
        reshuffle.loadOldTeams("src/main/resources/team_reshuffle/teams_sample.txt");
        reshuffle.printOldTeams();
        reshuffle.generateNewTeams();
        reshuffle.printNewTeams();
    }
}

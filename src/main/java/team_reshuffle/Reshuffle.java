package team_reshuffle;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Reshuffle {

    private final List<Team> oldTeams = new ArrayList<>();
    private final List<Team> newTeams = new ArrayList<>();

    public void generateNewTeams(int maxNumberOfStudentsInTeam) {
        int oldTeamsCount = oldTeams.size();
        int allStudentsCount = oldTeams.stream()
                .reduce(0, (partialResult, team) -> partialResult + team.getMembers().size(), Integer::sum);
        if (maxNumberOfStudentsInTeam > oldTeamsCount) {
            throw new IllegalArgumentException("The number of");
        }
        int numberOfStudentsLeft = allStudentsCount;

        while (numberOfStudentsLeft > 0) {
            Team newTeam = new Team();
            int studentsNumberInTeam = Math.min(maxNumberOfStudentsInTeam, numberOfStudentsLeft);
            int teamIndex = 0;
            for(int i = 1; i <= studentsNumberInTeam; i++) {
                Team team = oldTeams.get(teamIndex);
                
            }
            numberOfStudentsLeft -= studentsNumberInTeam;
        }
    }



//    pętlaWPętli (powtarzana razy numOfStudInTeam):
//    biorę team 0
//    sprawdzam czy ma elementy
//    jeśli tak to losuję randomowego Stringa i go stamtąd wycinam, i wrzucam do newTeam
//    jeśli nie to idę do kolejnego teamu
//    przechodzę do teamu 1 etc.
//odejmowanie od numberOfStudentsLeft
//    po zakończeniu pętli w pętli, wrzucam team do listyteamów i sprawdzam czy jacyś studenci zostali


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
        reshuffle.generateNewTeams(4);
        reshuffle.printNewTeams();
    }

}

package tinker_tailor;

import java.util.ArrayList;
import java.util.List;

public class TinkerTailor {

    public List<Integer> play(int numberOfParticipants, int sequenceLength) {
        if (numberOfParticipants <= 0 || sequenceLength <= 0) {
            throw new IllegalArgumentException("Both arguments need to be numbers above 0");
        }

        List<Integer> players = generatePlayersList(numberOfParticipants);
        List<Integer> excludedPlayers = new ArrayList<>();
        int index = 0;

        while (players.size() > 1) {
            for (int i = 1; i < sequenceLength; i++) {
                if (index + 1 < players.size()) {
                    index++;
                } else if (index + 1 == players.size()){
                    index = 0;
                } else {
                    index = 1;
                }
            }
            excludedPlayers.add(players.remove(index));
        }
        excludedPlayers.add(players.remove(0));

        return excludedPlayers;
    }

    protected List<Integer> generatePlayersList(int numberOfParticipants) {
        List<Integer> participants = new ArrayList<>();

        for (int i = 0; i < numberOfParticipants; i++) {
            participants.add(i + 1);
        }
        return participants;
    }

    private void printList(List<Integer> participants) {
        participants
                .forEach(i -> System.out.print(i + " "));
        System.out.println("");
    }

    public static void main(String[] args) {
        TinkerTailor tinkerTailor = new TinkerTailor();
        System.out.println("\n" + "Numbers before playing:");
        tinkerTailor.printList(tinkerTailor.generatePlayersList(20));
        System.out.println("Numbers excluded from the list (in the exclusion order):");
        tinkerTailor.printList(tinkerTailor.play(20, 2));
    }
}

package optimus_prime;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OptimusPrime {

    public List<Integer> getPrimeNumbersWithList(List<Integer> numbersList) {
        if (numbersList.stream().anyMatch(x -> x <= 1)) {
            throw new IllegalArgumentException("Given numbers should be greater than 1");
        }
        for (int index = 0; index < numbersList.size(); index++) {
            Integer currentNumber = numbersList.get(index);
            numbersList.removeIf(comparedNumber -> !comparedNumber.equals(currentNumber) && (comparedNumber % currentNumber == 0));
        }

        return numbersList;
    }

    public Map<Integer, Boolean> getPrimeNumbersWithMap(Map<Integer, Boolean> numbersMap) {
        for (Map.Entry<Integer, Boolean> currentEntry : numbersMap.entrySet()) {
            if (currentEntry.getValue()) {
                for (Map.Entry<Integer, Boolean> comparedEntry : numbersMap.entrySet()) {
                    if (!comparedEntry.equals(currentEntry) && comparedEntry.getKey() % currentEntry.getKey() == 0) {
                        comparedEntry.setValue(false);
                    }
                }
            }
        }
        return numbersMap;
    }

    private List<Integer> populateList(int lowerInclusiveLimit, int upperInclusiveLimit) {
        int listSize = upperInclusiveLimit - lowerInclusiveLimit + 1;
        List<Integer> numbersList = new ArrayList<>(listSize);
        for (int i = lowerInclusiveLimit; i <= upperInclusiveLimit; i++) {
            numbersList.add(i);
        }
        return numbersList;
    }

    private Map<Integer, Boolean> populateMap(int lowerInclusiveLimit, int upperInclusiveLimit) {
        int mapSize = upperInclusiveLimit - lowerInclusiveLimit + 1;
        Map<Integer, Boolean> numbersMap = new HashMap<>(mapSize);
        for (int i = lowerInclusiveLimit; i <= upperInclusiveLimit; i++) {
            numbersMap.put(i, true);
        }
        return numbersMap;
    }
}

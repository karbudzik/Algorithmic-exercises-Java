package optimus_prime;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class OptimusPrimeTest {

    private OptimusPrime optimusPrime;

    @Before
    public void populateData() {
        this.optimusPrime = new OptimusPrime();
    }

    @Test
    public void should_return_only_prime_numbers_when_given_list() {
        // given:
        List<Integer> smallNumbersList = new ArrayList<>(Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9, 10));

        // when:
        List<Integer> expectedListOfPrimeNumbers = new ArrayList<>(Arrays.asList(2, 3, 5, 7));
        List<Integer> realResultsOfCalculation = optimusPrime.getPrimeNumbersWithList(smallNumbersList);

        // then:
        assertIterableEquals(expectedListOfPrimeNumbers, realResultsOfCalculation);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_IllegalArgumentException_when_given_number_smaller_than_2() {
        // given:
        List<Integer> illegalList = new ArrayList<>(Arrays.asList(1, 2, 3, 5, 7));

        // when:
        List<Integer> results = optimusPrime.getPrimeNumbersWithList(illegalList);
    }
}

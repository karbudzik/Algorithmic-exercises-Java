package tinker_tailor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TinkerTailorTest {

    private TinkerTailor tinkerTailor;

    @BeforeEach
    public void init() {
        tinkerTailor = new TinkerTailor();
    }

    @Test
    public void should_return_as_many_elements_as_specified() {
        // given:
        int EXPECTED_ELEMENTS_NUMBER = 6;
        int RANDOM_SEQUENCE_LENGTH = 3;

        // when:
        List<Integer> resultList = tinkerTailor.play(EXPECTED_ELEMENTS_NUMBER, RANDOM_SEQUENCE_LENGTH);

        // then:
        assertEquals(6, resultList.size());
    }

    @Test
    public void should_return_list_of_1_when_given_1_element() {
        // given:
        int EXPECTED_ELEMENTS_NUMBER = 1;
        int RANDOM_SEQUENCE_LENGTH = 3;
        List<Integer> EXPECTED_RESULT_LIST = new ArrayList<>(Arrays.asList(1));

        // when:
        List<Integer> resultList = tinkerTailor.play(EXPECTED_ELEMENTS_NUMBER, RANDOM_SEQUENCE_LENGTH);

        // then:
        assertIterableEquals(resultList, EXPECTED_RESULT_LIST);
    }

    @Test
    public void should_return_proper_result_when_sequence_length_is_1() {
        // given:
        List<Integer> EXPECTED_LIST = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        int NUMBER_OF_ELEMENTS = 6;
        int SEQUENCE_LENGTH = 1;

        // when:
        List<Integer> resultList = tinkerTailor.play(NUMBER_OF_ELEMENTS, SEQUENCE_LENGTH);

        // then:
        assertIterableEquals(resultList, EXPECTED_LIST);
    }

    @Test
    public void should_return_proper_result_when_sequence_length_is_bigger_than_number_of_elements() {
        // given:
        List<Integer> EXPECTED_LIST = new ArrayList<>(Arrays.asList(5, 4, 2, 1, 3));
        int NUMBER_OF_ELEMENTS = 5;
        int SEQUENCE_LENGTH = 20;

        // when:
        List<Integer> resultList = tinkerTailor.play(NUMBER_OF_ELEMENTS, SEQUENCE_LENGTH);

        // then:
        assertIterableEquals(resultList, EXPECTED_LIST);
    }

    @Test
    public void should_throw_IllegalArgumentException_when_provided_at_least_one_argument_lower_than_1() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            tinkerTailor.play(0, 0);
        });

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            tinkerTailor.play(5, 0);
        });

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            tinkerTailor.play(0, 5);
        });

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            tinkerTailor.play(-2, -4);
        });
    }
}
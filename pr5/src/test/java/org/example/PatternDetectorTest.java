package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PatternDetectorTest {

    static Stream<Object[]> provideTestCases() {
        return Stream.of(
                new Object[]{"t", "P1"},
                new Object[]{"te", "P2"},
                new Object[]{"tes", "P3"},
                new Object[]{"test", "F"},
                new Object[]{"tA", "S"},
                new Object[]{"teA", "S"},
                new Object[]{"tesA", "S"},
                new Object[]{"testA", "F"},
                new Object[]{"At", "P1"},
                new Object[]{"Ate", "P2"},
                new Object[]{"Ates", "P3"},
                new Object[]{"Atest", "F"},
                new Object[]{"AtestA", "F"},
                new Object[]{"", "S"},
                new Object[]{"a", "S"}
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void testPatternDetector(String input, String expectedPhase) {
        PatternDetector detector = new PatternDetector();

        for (char symbol : input.toCharArray()) {
            detector.evaluateCharacter(symbol);
        }

        assertEquals(PatternDetector.Phase.valueOf(expectedPhase), detector.getCurrentState());
    }
}

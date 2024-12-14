package org.example;

public class PatternDetector {
    public enum Phase {
        S, P1, P2, P3, F
    }

    private Phase currentState;

    public PatternDetector() {
        this.currentState = Phase.S;
    }

    public Phase evaluateCharacter(char inputSymbol) {
        char upperCaseSymbol = Character.toUpperCase(inputSymbol);

        currentState = switch (currentState) {
            case S -> (upperCaseSymbol == 'T') ? Phase.P1 : Phase.S;
            case P1 -> (upperCaseSymbol == 'E') ? Phase.P2 : (upperCaseSymbol == 'T' ? Phase.P1 : Phase.S);
            case P2 -> (upperCaseSymbol == 'S') ? Phase.P3 : (upperCaseSymbol == 'T' ? Phase.P1 : Phase.S);
            case P3 -> (upperCaseSymbol == 'T') ? Phase.F : Phase.S;
            case F -> Phase.F;
        };
        return currentState;
    }

    public Phase getCurrentState() {
        return currentState;
    }
}

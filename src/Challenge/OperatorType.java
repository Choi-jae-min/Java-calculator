package Challenge;

public enum OperatorType {
    PLUS('+'),
    MINUS('_'),
    MULTIPLY('*'),
    DIVIDE('/');

    private char symbol;
    OperatorType(char symbol) {
        this.symbol = symbol;
    }

    public static OperatorType setSymbol(char symbol) {
        switch (symbol) {
            case '+' -> {
                return PLUS;
            }
            case '-' -> {
                return MINUS;
            }
            case '*' -> {
                return MULTIPLY;
            }
            case '/' -> {
                return DIVIDE;
            }
            default -> throw new IllegalArgumentException("지원하지 않는 연산자: " + symbol);
        }
    }
    public char getSymbol() {
        return symbol;
    }
}

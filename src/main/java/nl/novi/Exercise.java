package nl.novi;

import java.util.List;

public abstract class Exercise<I,R> {
    public abstract I parseInput(List<String> input);
    public abstract R solver(I input);

    public R solve(List<String> input) {
        I parsed = parseInput(input);
        return solver(parsed);
    }
}

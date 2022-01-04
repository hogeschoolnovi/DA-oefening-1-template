package nl.novi;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import nl.novi.utils.ExerciseInputLoader;

public class SolveExerciseTest {
    @Rule
    public ExerciseInputLoader input = new ExerciseInputLoader(1);

    SolveExercise solver;
    
    @Before
    public void before() {
        solver = new SolveExercise();
    }

    @Test
    public void testSample() {
        assertEquals(List.of(List.of(-1,1)), solver.solve(input.getSampleData()));
    }

    @Test
    public void testReal() {
        assertEquals(16, solver.solve(input.getRealData()).size());
    }
}

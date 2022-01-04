package nl.novi.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.rules.ExternalResource;

public class ExerciseInputLoader extends ExternalResource {
    int exercise = 1;
    List<String> sampleData = null;
    List<String> realData = null;

    public ExerciseInputLoader(int exercise) {
        this.exercise = exercise;
    }

    @Override
    protected void before() throws Throwable {
        String filename = String.format("/sample-%02d.txt", exercise);
        sampleData = readFile(filename);
        filename = String.format("/real-%02d.txt", exercise);
        realData = readFile(filename);
    }

    private List<String> readFile(String file) {
        String filename = file;

        InputStream stream = this.getClass().getResourceAsStream(filename);
        try (BufferedReader r = new BufferedReader(new InputStreamReader(stream))) {
            return r.lines().collect(Collectors.toList());
        } catch (IOException ex) {
            throw new UncheckedIOException(ex);
        }
    }

    public List<String> getSampleData() {
        return sampleData;
    }

    public List<String> getRealData() {
        return realData;
    }
}

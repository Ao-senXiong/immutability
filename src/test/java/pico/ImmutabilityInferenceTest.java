package pico;

import org.checkerframework.framework.test.TestUtilities;
import org.checkerframework.javacutil.Pair;
import org.junit.runners.Parameterized.Parameters;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import checkers.inference.test.CFInferenceTest;
import pico.inference.PICOInferenceChecker;
import pico.inference.solver.PICOSolverEngine;

public class ImmutabilityInferenceTest extends CFInferenceTest {

    public ImmutabilityInferenceTest(File testFile) {
        super(
                testFile,
                PICOInferenceChecker.class,
                "",
                "-Anomsgtext",
                "-Astubs=src/main/java/pico/typecheck/jdk.astub",
                "-d",
                "testdata/inference/inferrable");
    }

    @Override
    public Pair<String, List<String>> getSolverNameAndOptions() {
        return Pair.of(
                PICOSolverEngine.class.getCanonicalName(),
                new ArrayList<>(Arrays.asList("useGraph=false", "collectStatistic=true")));
    }

    @Override
    public boolean useHacks() {
        return true;
    }

    @Parameters
    public static List<File> getTestFiles() {
        // InferenceTestUtilities.findAllSystemTests();
        return new ArrayList<>(
                TestUtilities.findRelativeNestedJavaFiles("testinput", "inference/inferrable"));
    }
}

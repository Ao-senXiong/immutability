package pico;

import org.checkerframework.framework.test.CheckerFrameworkPerFileTest;
import org.checkerframework.framework.test.TestUtilities;
import org.junit.runners.Parameterized;
import pico.typecheck.PICOChecker;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ObservationalPurityTest extends CheckerFrameworkPerFileTest {
    public ObservationalPurityTest(File testFile) {
        super(testFile, PICOChecker.class, "", "-Anomsgtext",
                "-Anocheckjdk", "-d", "testTmp/abstractStateOnly", "-AabstractStateOnly");
    }

    @Parameterized.Parameters
    public static List<File> getTestFiles(){
        return new ArrayList<>(TestUtilities.findRelativeNestedJavaFiles("testinput", "abstractStateOnly"));
    }
}

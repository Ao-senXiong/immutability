package typecheck;

import org.checkerframework.checker.pico.qual.Readonly;

public class BinaryOperator {
    @Readonly Object o;

    String test1() {
        return "Object is: " + o;
    }

    String test2() {
        return o.toString();
    }
}

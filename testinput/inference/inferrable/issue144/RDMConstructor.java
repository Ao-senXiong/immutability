
import org.checkerframework.checker.pico.qual.Assignable;
import org.checkerframework.checker.pico.qual.Immutable;
import org.checkerframework.checker.pico.qual.Mutable;
import org.checkerframework.checker.pico.qual.ReceiverDependentMutable;

import java.util.Date;

class A {
    @Assignable Date d;
    A() {
        // :: fixable-error: (assignment.type.incompatible)
        d = new @ReceiverDependentMutable Date();
    }
}

public class RDMConstructor {
    void test1() {
        // No more assignability error because the validator will tell the error first
        // :: fixable-error: (type.invalid.annotations.on.use)
        @Immutable A la = new A();
        la.toString();
    }

    void test2() {
        A la = new A();
        // :: fixable-error: (assignment.type.incompatible)
        la.d = new @Immutable Date();
    }
}

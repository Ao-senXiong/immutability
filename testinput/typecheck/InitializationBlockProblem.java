package typecheck;

import org.checkerframework.checker.pico.qual.Immutable;
import org.checkerframework.checker.pico.qual.Mutable;
import org.checkerframework.checker.pico.qual.ReceiverDependentMutable;

class InitializationBlockProblem {
    @ReceiverDependentMutable Object o;

    {
        this.o = new @Mutable Object();
        // :: error: (assignment.type.incompatible)
        this.o = new @Immutable Object();
    }
}

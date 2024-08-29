import org.checkerframework.checker.pico.qual.Immutable;
import org.checkerframework.checker.pico.qual.Mutable;
import org.checkerframework.checker.pico.qual.ReceiverDependentMutable;

class InitializationBlockProblem {
    @ReceiverDependentMutable Object o;

    {
        // :: fixable-error: (assignment.type.incompatible)
        this.o = new @Immutable Object();
    }
}

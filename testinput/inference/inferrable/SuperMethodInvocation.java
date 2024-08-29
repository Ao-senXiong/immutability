import org.checkerframework.checker.initialization.qual.UnderInitialization;
import org.checkerframework.checker.pico.qual.Immutable;
import org.checkerframework.checker.pico.qual.Mutable;
import org.checkerframework.checker.pico.qual.ReceiverDependentMutable;

public class SuperMethodInvocation {

    @ReceiverDependentMutable Object f;

    void foo(@UnderInitialization SuperMethodInvocation this) {
        // :: fixable-error: (assignment.type.incompatible)
        this.f = new @Immutable Object();
    }
}

class SubClass extends SuperMethodInvocation{

    @Override
    void foo(@UnderInitialization SubClass this) {
        super.foo();
    }
}

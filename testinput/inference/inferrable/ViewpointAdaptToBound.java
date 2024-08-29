import org.checkerframework.checker.pico.qual.Immutable;
import org.checkerframework.checker.pico.qual.Mutable;
import org.checkerframework.checker.pico.qual.ReceiverDependentMutable;

@Immutable
public class ViewpointAdaptToBound {
    // :: fixable-error: (assignment.type.incompatible)
    @ReceiverDependentMutable Object o = new Object();
    // :: fixable-error: (assignment.type.incompatible)
    @Immutable Object x = new Object();
    @Mutable Object y = new Object();

    {
        // :: fixable-error: (assignment.type.incompatible)
        o = new Object();
    }
}

@Mutable
class A {
    @ReceiverDependentMutable Object o = new Object();
    // :: fixable-error: (assignment.type.incompatible)
    @Immutable Object x = new Object();
    @Mutable Object y = new Object();

    {
        o = new Object();
    }
}

@ReceiverDependentMutable
class B {
    // :: fixable-error: (assignment.type.incompatible)
    @ReceiverDependentMutable Object o = new Object();
    // :: fixable-error: (assignment.type.incompatible)
    @Immutable Object x = new Object();
    @Mutable Object y = new Object();

    {
        // :: fixable-error: (assignment.type.incompatible)
        o = new Object();
    }
}

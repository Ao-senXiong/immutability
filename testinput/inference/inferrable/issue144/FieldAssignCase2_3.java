import org.checkerframework.checker.initialization.qual.UnderInitialization;
import org.checkerframework.checker.pico.qual.ReceiverDependentMutable;

public class FieldAssignCase2_3 {
    @ReceiverDependentMutable Object o;
    FieldAssignCase2_3() {
        init();
    }

    void init(@UnderInitialization FieldAssignCase2_3 this) {
        // :: fixable-error: (assignment.type.incompatible)
        o = new @ReceiverDependentMutable Object();
    }
}

import org.checkerframework.checker.pico.qual.ReceiverDependentMutable;

public class FieldAssignCase2_2 {
    @ReceiverDependentMutable Object o;
    FieldAssignCase2_2(@ReceiverDependentMutable Object o) {
        // :: fixable-error: (assignment.type.incompatible)
        this.o = o;
    }
}

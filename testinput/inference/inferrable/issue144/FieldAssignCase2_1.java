import org.checkerframework.checker.pico.qual.Immutable;
import org.checkerframework.checker.pico.qual.ReceiverDependentMutable;

public class FieldAssignCase2_1 {
    @ReceiverDependentMutable Object o;
    FieldAssignCase2_1(@Immutable Object ao) {
        // :: fixable-error: (assignment.type.incompatible)
        o = ao;
    }
}

import org.checkerframework.checker.pico.qual.Assignable;
import org.checkerframework.checker.pico.qual.Immutable;
import org.checkerframework.checker.pico.qual.Readonly;
import org.checkerframework.checker.pico.qual.ReceiverDependentMutable;

@Immutable
public class FieldAssignCase1 {

    // 1) forbidden() method restricts "o" to be anything but not @ReceiverDependentMutable
    // 2) Adding @ReceiverDependentMutable manually caused inference to fail, which indicates
    // that implication constraint serialization logic is correct!
    @Assignable Object o;
    FieldAssignCase1(Object o) {
        // :: fixable-error: (assignment.type.incompatible)
        this.o = o;
    }
}

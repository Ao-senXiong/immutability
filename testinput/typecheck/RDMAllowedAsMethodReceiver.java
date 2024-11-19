import org.checkerframework.checker.pico.qual.Mutable;
import org.checkerframework.checker.pico.qual.ReceiverDependentMutable;
import org.checkerframework.checker.pico.qual.Immutable;

@Immutable class RDMAllowedAsMethodReceiver {
    // :: error: (type.invalid.annotations.on.use)
    void foo(@ReceiverDependentMutable RDMAllowedAsMethodReceiver this) {}
}

@Mutable
class AnotherExample {
    // :: error: (type.invalid.annotations.on.use)
    void foo(@ReceiverDependentMutable AnotherExample this) {}
}

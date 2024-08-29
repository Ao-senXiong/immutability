package typecheck;

import org.checkerframework.checker.pico.qual.Assignable;
import org.checkerframework.checker.pico.qual.Immutable;
import org.checkerframework.checker.pico.qual.Mutable;
import org.checkerframework.checker.pico.qual.Readonly;
import org.checkerframework.checker.pico.qual.ReceiverDependentMutable;

@ReceiverDependentMutable
public class FieldsInitialized {
    final @Immutable Object f1;
    @Immutable Object f2;
    final @ReceiverDependentMutable Object f3;
    @ReceiverDependentMutable Object f4;

    @Mutable Object f5;
    @Readonly Object f6;
    @Assignable @Immutable Object f7;
    @Assignable @ReceiverDependentMutable Object f8;
    @Assignable @Mutable Object f9;
    @Assignable @Readonly Object f10;
    @ReceiverDependentMutable FieldsInitialized() {
        f1 = new @Immutable Object();
        f2 = new @Immutable Object();
        f3 = new @ReceiverDependentMutable Object();
        f4 = new @ReceiverDependentMutable Object();
        f5 = new @Mutable Object();
        f6 = new @Immutable Object();
    }
}

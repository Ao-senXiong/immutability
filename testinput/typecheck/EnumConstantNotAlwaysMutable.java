import org.checkerframework.checker.pico.qual.Immutable;
import org.checkerframework.checker.pico.qual.Mutable;
import org.checkerframework.checker.pico.qual.Readonly;
import org.checkerframework.checker.pico.qual.ReceiverDependentMutable;

// It's equivalent to having @Immutable on every enum type
enum Kind {
    SOME;// Enum constant is also @Immutable
}

public class EnumConstantNotAlwaysMutable {

    // Shouldn't get warning. Implicitly applied @Immutable
    Kind defKind;
    // Enum is implicitly @Immutable, so using explicit @Immutable is allowed
    @Immutable Kind kind;
    // :: error: (type.invalid.annotations.on.use)
    @ReceiverDependentMutable Kind invalidKind;
    // :: error: (type.invalid.annotations.on.use)
    @Mutable Kind invalidKind2;
    // no error now
    @Readonly Kind invalidKind3;
    EnumConstantNotAlwaysMutable() {
        // Kind.SOME should be @Immutable
        kind = Kind.SOME;
    }
}

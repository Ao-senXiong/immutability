package typecheck;

import org.checkerframework.checker.pico.qual.Readonly;
import org.checkerframework.checker.pico.qual.Mutable;
import org.checkerframework.checker.pico.qual.Immutable;

public class OnlyOneModifierIsUse {

    // :: error: (type.invalid.conflicting.annos)
    @Readonly @Immutable Object field;
    // :: error: (type.invalid.conflicting.annos)
    String @Readonly @Immutable [] array;
}

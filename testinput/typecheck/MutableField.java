package typecheck;

import org.checkerframework.checker.pico.qual.Immutable;
import org.checkerframework.checker.pico.qual.Mutable;

public class MutableField {

    // Allow mutable field now
    @Mutable Object f;
    static @Mutable Object sf = new @Mutable Object();

    MutableField() {
        f = new @Mutable Object();
    }
}

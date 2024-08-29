import org.checkerframework.checker.pico.qual.Immutable;
import org.checkerframework.checker.pico.qual.Mutable;
import org.checkerframework.checker.pico.qual.Readonly;

class ShouldFailButDidnot {
    void foo() {
        @Readonly Object o = new @Immutable Object();
        o = new @Mutable Object();
    }
}

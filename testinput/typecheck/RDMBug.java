package typecheck;

import org.checkerframework.checker.pico.qual.Assignable;
import org.checkerframework.checker.pico.qual.Immutable;
import org.checkerframework.checker.pico.qual.Mutable;
import org.checkerframework.checker.pico.qual.Readonly;

@Immutable class RDMBug {
    // :: error: (initialization.field.uninitialized)
    @Mutable Object o;
    // :: error: (initialization.field.uninitialized)
    @Readonly Object o2;
    void foo(@Immutable RDMBug this) {
        // :: error: (illegal.field.write)
        this.o = new @Mutable Object();
        // :: error: (illegal.field.write)
        this.o2 = new @Immutable Object();
    }
}

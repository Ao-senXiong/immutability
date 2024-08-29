package typecheck;

import org.checkerframework.checker.pico.qual.Immutable;
import org.checkerframework.checker.pico.qual.Readonly;
import org.checkerframework.checker.pico.qual.Mutable;
import org.checkerframework.checker.pico.qual.ReceiverDependentMutable;

@ReceiverDependentMutable
public class ReadonlyMayCaptureMutable {
    static @Mutable Object smf = new @Mutable Object();

    @Readonly Object rof;
    @ReceiverDependentMutable ReadonlyMayCaptureMutable() {
        // Not a problem anymore, because readonly field is out of the abstract state
        rof = smf;
    }

    @Immutable ReadonlyMayCaptureMutable(@Immutable Object o) {
        // The same argument applies as above
        rof = smf;
    }

    @Mutable ReadonlyMayCaptureMutable(Object o1, Object o2) {
        rof = smf;
    }
}

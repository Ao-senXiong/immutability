package typecheck;

import qual.Assignable;
import qual.Immutable;

public class InvalidAssignability {
    int a;
    @Assignable int b;
    final int c;
    // :: error: (one.assignability.invalid)
    final @Assignable int d;
    final @Immutable Object io = null;
    @Immutable Object io2;
    @Assignable @Immutable Object io3;
    static final @Immutable Object io4 = null;
    // :: error: (initialization.static.field.uninitialized)
    static @Assignable @Immutable Object io5;
    // :: error: (one.assignability.invalid)
    final @Assignable @Immutable Object o = null;
    // :: error: (one.assignability.invalid)
    static final @Assignable @Immutable Object o2 = null;
    // :: error: (initialization.fields.uninitialized)
    InvalidAssignability() {
        c = 1;
        d = 1;
    }
}

package typecheck;

import org.checkerframework.checker.pico.qual.Mutable;
import org.checkerframework.checker.pico.qual.Immutable;
import org.checkerframework.checker.pico.qual.ReceiverDependentMutable;
import org.checkerframework.checker.pico.qual.Readonly;

@ReceiverDependentMutable
public class ReceiverDependentMutableConstructor {

    @Readonly Object rof;
    @ReceiverDependentMutable Object pif;
    @Immutable Object imf;

    // :: error: (initialization.fields.uninitialized)
    @ReceiverDependentMutable ReceiverDependentMutableConstructor(@Mutable Object mo, @ReceiverDependentMutable Object po, @Immutable Object io) {
    }

    @ReceiverDependentMutable ReceiverDependentMutableConstructor(@ReceiverDependentMutable Object po, @Immutable Object io) {
        this.rof = po;
        this.rof = io;

        this.pif = po;
        // :: error: (assignment.type.incompatible)
        this.pif = io;

        // :: error: (assignment.type.incompatible)
        this.imf = po;
        this.imf = io;
    }

    void invokeConstructor(@Readonly Object ro, @Mutable Object mo, @ReceiverDependentMutable Object po, @Immutable Object io) {
        new @Mutable ReceiverDependentMutableConstructor(mo, io);
        // :: error: (argument.type.incompatible)
        new @Mutable ReceiverDependentMutableConstructor(ro, io);
        // :: error: (argument.type.incompatible)
        new @Mutable ReceiverDependentMutableConstructor(po, io);
        // :: error: (argument.type.incompatible)
        new @Mutable ReceiverDependentMutableConstructor(io, io);

        new @ReceiverDependentMutable ReceiverDependentMutableConstructor(po, io);
        // :: error: (argument.type.incompatible)
        new @ReceiverDependentMutable ReceiverDependentMutableConstructor(ro, io);
        // :: error: (argument.type.incompatible)
        new @ReceiverDependentMutable ReceiverDependentMutableConstructor(mo, io);
        // :: error: (argument.type.incompatible)
        new @ReceiverDependentMutable ReceiverDependentMutableConstructor(io, io);

        new @Immutable ReceiverDependentMutableConstructor(io, io);
        // :: error: (argument.type.incompatible)
        new @Immutable ReceiverDependentMutableConstructor(ro, io);
        // :: error: (argument.type.incompatible)
        new @Immutable ReceiverDependentMutableConstructor(mo, io);
        // :: error: (argument.type.incompatible)
        new @Immutable ReceiverDependentMutableConstructor(po, io);

        // :: error: (pico.new.invalid) :: error: (argument.type.incompatible) :: error: (constructor.invocation.invalid)
        new @Readonly ReceiverDependentMutableConstructor(ro, io);
    }
}

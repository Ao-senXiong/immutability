import org.checkerframework.checker.pico.qual.*;
public class DefiniteAssignmentCheck {
    @Immutable class ImmutableBox {
        // :: error: (initialization.field.uninitialized)
        /*RDA*/ /*RDM*/ Object a; // initialization should be checked
        // :: error: (initialization.field.uninitialized)
        /*RDA*/ @Immutable Object b; // initialization should be checked
        // :: error: (initialization.field.uninitialized)
        /*RDA*/ @Mutable Object c; // initialization should be checked
        // :: error: (initialization.field.uninitialized)
        /*RDA*/ @ReceiverDependentMutable Object d; // initialization should be checked
        @Assignable /*RDM*/ Object e;
        @Assignable @Immutable Object f;
        @Assignable @Mutable Object g;
        @Assignable @ReceiverDependentMutable Object h;
    }

    @ReceiverDependentMutable class RDMBox {
        // :: error: (initialization.field.uninitialized)
        /*RDA*/ /*RDM*/ Object a; // initialization should be checked
        // :: error: (initialization.field.uninitialized)
        /*RDA*/ @Immutable Object b; // initialization should be checked
        // :: error: (initialization.field.uninitialized)
        /*RDA*/ @Mutable Object c; // initialization should be checked
        // :: error: (initialization.field.uninitialized)
        /*RDA*/ @ReceiverDependentMutable Object d; // initialization should be checked
        @Assignable /*RDM*/ Object e;
        @Assignable @Immutable Object f;
        @Assignable @Mutable Object g;
        @Assignable @ReceiverDependentMutable Object h;
    }

    class MutableBox {
        /*RDA*/ /*RDM*/ Object a;
        /*RDA*/ @Immutable Object b;
        /*RDA*/ @Mutable Object c;
        /*RDA*/ @ReceiverDependentMutable Object d;
        @Assignable /*RDM*/ Object e;
        @Assignable @Immutable Object f;
        @Assignable @Mutable Object g;
        @Assignable @ReceiverDependentMutable Object h;
    }

    @Mutable class ExplictMutableBox {
        /*RDA*/ /*RDM*/ Object a;
        /*RDA*/ @Immutable Object b;
        /*RDA*/ @Mutable Object c;
        /*RDA*/ @ReceiverDependentMutable Object d;
        @Assignable /*RDM*/ Object e;
        @Assignable @Immutable Object f;
        @Assignable @Mutable Object g;
        @Assignable @ReceiverDependentMutable Object h;
    }
}
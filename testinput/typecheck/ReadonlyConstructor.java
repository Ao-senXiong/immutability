package typecheck;

import org.checkerframework.checker.pico.qual.Readonly;

public class ReadonlyConstructor {
    //TODO: should we check the return type of constructor?
    // :: error: (constructor.return.invalid) :: error: (super.invocation.invalid)
    @Readonly ReadonlyConstructor() {}
}

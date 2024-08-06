package typecheck;

import qual.Readonly;

public class ReadonlyConstructor {
    //TODO: should we check the return type of constructor?
    // :: error: (constructor.return.invalid) :: error: (super.invocation.invalid)
    @Readonly ReadonlyConstructor() {}
}

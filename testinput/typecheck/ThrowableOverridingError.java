import qual.Readonly;

class A extends Throwable {
    @Override
    public String getMessage(@Readonly A this) {
        // :: error: (method.invocation.invalid)
        return super.getMessage();
    }
}

public class ThrowableOverridingError extends Throwable{

    @Override public String getMessage() {
        return super.getMessage();
    }
}

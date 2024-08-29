import org.checkerframework.checker.pico.qual.Readonly;

public class ConstructorReturnInvalid {
    Object o;

    // :: error: (constructor.return.invalid)
    @Readonly ConstructorReturnInvalid(Object o) {
        this.o = o;
    }
}

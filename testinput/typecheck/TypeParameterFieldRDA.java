import org.checkerframework.checker.pico.qual.Assignable;
import org.checkerframework.checker.pico.qual.Immutable;
import org.checkerframework.checker.pico.qual.Mutable;

@Immutable
public class TypeParameterFieldRDA<T> {
    T t;// RDA
    TypeParameterFieldRDA(T t) {
        this.t = t;
    }
}

class A {
    static void foo() {
        @Immutable TypeParameterFieldRDA<@Mutable Object> t = new TypeParameterFieldRDA<>(new @Mutable Object());
        // :: error: (illegal.field.write)
        t.t = new @Mutable Object();
    }
}

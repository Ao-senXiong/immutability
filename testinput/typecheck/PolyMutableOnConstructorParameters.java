package typecheck;

import org.checkerframework.checker.pico.qual.Immutable;
import org.checkerframework.checker.pico.qual.PolyMutable;

@Immutable
public class PolyMutableOnConstructorParameters<T> {
    @Immutable PolyMutableOnConstructorParameters(@PolyMutable Object o) {
    }

    public static void main(String[] args) {
        @Immutable PolyMutableOnConstructorParameters o1 = new @Immutable PolyMutableOnConstructorParameters(new @Immutable Object());
    }
}

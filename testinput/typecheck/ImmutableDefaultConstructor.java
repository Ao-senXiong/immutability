import org.checkerframework.checker.pico.qual.Immutable;

@Immutable
public class ImmutableDefaultConstructor {
    static void foo() {
        // Main type of "new" is also inheritted "@Immutable"
        @Immutable ImmutableDefaultConstructor l = new ImmutableDefaultConstructor();
    }
}

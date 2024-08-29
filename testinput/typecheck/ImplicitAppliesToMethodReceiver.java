package typecheck;

import org.checkerframework.checker.pico.qual.Immutable;
import org.checkerframework.checker.pico.qual.Mutable;

public class ImplicitAppliesToMethodReceiver {
    void foo() {
        double delta = Double.valueOf(1.0);
    }
}

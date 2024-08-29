import org.checkerframework.checker.pico.qual.Immutable;
import org.checkerframework.checker.pico.qual.Mutable;

@Immutable
public class MethodReceiverNotInhericClassBound {

    // :: error: (method.receiver.incompatible)  :: error: (type.invalid.annotations.on.use)
   void bar(@Mutable MethodReceiverNotInhericClassBound this) {}
}

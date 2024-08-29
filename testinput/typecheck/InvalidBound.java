import org.checkerframework.checker.pico.qual.Bottom;
import org.checkerframework.checker.pico.qual.Immutable;
import org.checkerframework.checker.pico.qual.Mutable;
import org.checkerframework.checker.pico.qual.PolyMutable;
import org.checkerframework.checker.pico.qual.Readonly;
import org.checkerframework.checker.pico.qual.ReceiverDependentMutable;

// :: error: (class.bound.invalid)
@Readonly public class InvalidBound {}

// :: error: (class.bound.invalid)
@PolyMutable class A{}

// ok
@Immutable class C{ @Immutable C(){}}

// ok
@Mutable class D{}

// ok
@ReceiverDependentMutable class E{}

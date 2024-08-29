import org.checkerframework.checker.pico.qual.Immutable;
import org.checkerframework.checker.pico.qual.Mutable;
import org.checkerframework.checker.pico.qual.ReceiverDependentMutable;

@ReceiverDependentMutable
public class BoundsCompatible {}

// @Mutable propagates here
class Level1A extends BoundsCompatible {}

// @Immutable propagates here
class Level1B extends BoundsCompatible {}

@Mutable class Level2A extends Level1A {}

// fixable-error subclass.bound.incompatible removed.
// :: fixable-error: (type.invalid.annotations.on.use)  :: fixable-error: (super.invocation.invalid)
@Immutable class Level2B extends Level1B {}

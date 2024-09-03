package typecheck;

import org.checkerframework.checker.pico.qual.Immutable;
import org.checkerframework.checker.pico.qual.Mutable;

import java.util.Date;

// In these two cases, types are not applied computed annotations:
// 1) Has explicit annotation, e.g. d2 and d3
// 2) Has bound annotation on Element, e.g. d. It can be from source file or stub file(jdk.astub)
public class StaticFields {
    // D no longer gets inheritted @ReceiverDependentMutable anymore. It goes back to original
    // implementation - PICOTreeAnnotator adds @Mutable to non-implicitly immutable type. This is the result
    // of not inheritting @ReceiverDependentMutable to the usage because it creates unexpected noises.
    // As a result, d has no annotation on it, and it falls through to PICOTreeAnnotator and gets added
    // @Mutable.
    static Date d;
    static Integer i;// Implicitly immutable type - Handled by PICOImplicitsTypeAnnotator
    static @Mutable Date d2;
    static @Immutable Date d3;
    static ImmutableInner ii; // Default to @Immutable handled by PICOTreeAnnotator

    static {
        // (not the case anymore) new instance creation also has @ReceiverDependentMutable type
        // which is from element declaration in stub file(bound)
        d = new Date();// (this case again) Handled by addComputedTypeAnnotations(Element, AnnotatedTypeMirror) when used
        i = 2;// Handled by PICOImplicitsTypeAnnotator when used
        d2 = new @Mutable Date();
        d3 = new @Immutable Date();
        ii = new ImmutableInner(); // Default to @Immutable handled by addComputedTypeAnnotations(Element, AnnotatedTypeMirror)
    }
    @Immutable
    static class ImmutableInner {}
}

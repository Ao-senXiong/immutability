import org.checkerframework.checker.pico.qual.Immutable;
import org.checkerframework.checker.pico.qual.Mutable;
import org.checkerframework.checker.pico.qual.ReceiverDependentMutable;

public class BoundIncompatible implements java.io.Serializable{}

@Mutable
class A implements java.io.Serializable{}

@ReceiverDependentMutable
class B implements java.io.Serializable{}

@Immutable
class C implements java.io.Serializable{}

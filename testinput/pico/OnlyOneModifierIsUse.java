import qual.Readonly;
import qual.Mutable;
import qual.Immutable;

//:: error: (initialization.fields.uninitialized)
public class OnlyOneModifierIsUse {

    //:: error: (type.invalid)
    @Readonly @Immutable Object field;
    //:: error: (type.invalid)
    String @Readonly @Immutable [] array;
}
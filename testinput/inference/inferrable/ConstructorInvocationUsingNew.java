import qual.Immutable;
import qual.Mutable;
import qual.ReceiverDependentMutable;

public class ConstructorInvocationUsingNew {

    // :: fixable-error: (type.invalid.annotations.on.use)
    @ReceiverDependentMutable ConstructorInvocationUsingNew() {}

    public static void main(String[] args) {
        // Handled by PICOInferenceVisito#checkConstructorInvocability
        // No more assignability error because the validator will tell the error first
        // :: fixable-error: (type.invalid.annotations.on.use)
        @Immutable ConstructorInvocationUsingNew c = new ConstructorInvocationUsingNew();
    }
}

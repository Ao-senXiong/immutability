package pico.inference;

import checkers.inference.BaseInferrableChecker;
import checkers.inference.InferenceAnnotatedTypeFactory;
import checkers.inference.InferenceChecker;
import checkers.inference.InferenceVisitor;
import checkers.inference.InferrableChecker;
import checkers.inference.SlotManager;
import checkers.inference.model.ConstraintManager;
import org.checkerframework.common.basetype.BaseAnnotatedTypeFactory;
import org.checkerframework.javacutil.AnnotationBuilder;
import qual.Bottom;
import qual.Immutable;
import qual.Mutable;
import qual.Readonly;
import qual.ReceiverDependantMutable;

import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.util.Elements;

/**
 * Main entry class
 */
public class PICOInferenceChecker extends BaseInferrableChecker {

    public static AnnotationMirror READONLY, MUTABLE, RECEIVERDEPENDANTMUTABLE, IMMUTABLE, BOTTOM;

    @Override
    public void initChecker() {
        final Elements elements = processingEnv.getElementUtils();
        READONLY = AnnotationBuilder.fromClass(elements, Readonly.class);
        MUTABLE = AnnotationBuilder.fromClass(elements, Mutable.class);
        RECEIVERDEPENDANTMUTABLE = AnnotationBuilder.fromClass(elements, ReceiverDependantMutable.class);
        IMMUTABLE = AnnotationBuilder.fromClass(elements, Immutable.class);
        BOTTOM = AnnotationBuilder.fromClass(elements, Bottom.class);
        super.initChecker();
    }

    @Override
    public BaseAnnotatedTypeFactory createRealTypeFactory() {
        return new PICOInferenceRealTypeFactory(this, true);
    }

    @Override
    public InferenceAnnotatedTypeFactory createInferenceATF(InferenceChecker inferenceChecker, InferrableChecker realChecker, BaseAnnotatedTypeFactory realTypeFactory, SlotManager slotManager, ConstraintManager constraintManager) {
        return new PICOInferenceAnnotatedTypeFactory(inferenceChecker, realChecker.withCombineConstraints(), realTypeFactory, realChecker, slotManager, constraintManager);
    }

    @Override
    public InferenceVisitor<?, ?> createVisitor(InferenceChecker ichecker, BaseAnnotatedTypeFactory factory, boolean infer) {
        return new PICOInferenceVisitor(this, ichecker, factory, infer);
    }

    @Override
    public boolean withCombineConstraints() {
        return true;
    }

    @Override
    public boolean isInsertMainModOfLocalVar() {
        return true;
    }
}

package pico.typecheck;

import org.checkerframework.framework.type.GenericAnnotatedTypeFactory;
import org.checkerframework.framework.type.NoElementQualifierHierarchy;
import qual.Bottom;
import qual.Lost;

import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.util.Elements;
import java.lang.annotation.Annotation;
import java.util.Collection;

/** A qualifier hierarchy for the PICO checker. */
public class PICOQualifierHierarchy extends NoElementQualifierHierarchy {

    /**
     * Creates a PICOQualifierHierarchy from the given classes.
     *
     * @param qualifierClasses classes of annotations that are the qualifiers
     * @param elements         element utils
     * @param atypeFactory     the associated type factory
     */
    public PICOQualifierHierarchy(Collection<Class<? extends Annotation>> qualifierClasses, Elements elements, GenericAnnotatedTypeFactory<?, ?, ?, ?> atypeFactory) {
        super(qualifierClasses, elements, atypeFactory);
    }

    @Override
    public boolean isSubtypeQualifiers(AnnotationMirror subAnno, AnnotationMirror superAnno) {
        // Lost is not reflexive and the only subtype is Bottom
        if (atypeFactory.areSameByClass(superAnno, Lost.class)
                && !atypeFactory.areSameByClass(subAnno, Bottom.class)) {
            return false;
        }
        return super.isSubtypeQualifiers(subAnno, superAnno);
    }
}

package pico.typecheck;

import org.checkerframework.checker.initialization.InitializationChecker;
import org.checkerframework.common.basetype.BaseTypeChecker;

public class PICOChecker extends InitializationChecker {

    public PICOChecker() {}

    @Override
    public Class<? extends BaseTypeChecker> getTargetCheckerClass() {
        return PICONoInitSubchecker.class;
    }

    @Override
    public void initChecker() {
        super.initChecker();
        PICOAnnotationMirrorHolder.init(this);
    }

    @Override
    public boolean checkPrimitives() {
        return true;
    }

    @Override
    protected boolean shouldAddShutdownHook() {
        return super.shouldAddShutdownHook();
    }

    @Override
    protected void shutdownHook() {
        super.shutdownHook();
    }
}

package typecheck;

import org.checkerframework.checker.pico.qual.Immutable;
import org.checkerframework.checker.pico.qual.Mutable;
import org.checkerframework.checker.pico.qual.PolyMutable;
import org.checkerframework.checker.pico.qual.Readonly;

import java.util.Date;

public class DateCell3{

    /*This poly return type can be instantiated according to assignment context now*/
    @PolyMutable Date getPolyMutableDate(@Readonly DateCell3 this) {
        return new @PolyMutable Date();
    }

    /*Allowed in new PICO now*/
    void testGetPolyImmutableDate(@Readonly DateCell3 this) {
        @Mutable Date md = this.getPolyMutableDate();
        @Immutable Date imd = this.getPolyMutableDate();
    }
}

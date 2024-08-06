package qual;

import org.checkerframework.framework.qual.SubtypeOf;

import java.lang.annotation.*;

@SubtypeOf({Readonly.class})
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE_USE, ElementType.TYPE_PARAMETER})
public @interface Lost {
}

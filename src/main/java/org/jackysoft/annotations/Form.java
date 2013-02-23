package org.jackysoft.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface Form {
    String id() default "entityForm";
    String className() default "entityFrom";
    String label() default "";
    String action() default "";
    FormEncType enctype() default FormEncType.NORMAL;
    FormMethod method() default FormMethod.GET;
    String target() default "_blank";
    
}

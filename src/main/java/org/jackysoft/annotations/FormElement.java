package org.jackysoft.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * description of the form element field
 * */

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD })
public @interface FormElement {
	String id() default "";

	String name() default "";

	String label() default "";

	FieldType type() default FieldType.textfield;

	String className() default "";

	String value() default "";

	boolean listable() default true;

	boolean readOnly() default false;

	boolean disabled() default false;

	boolean checked() default false;
}

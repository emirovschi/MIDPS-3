package com.emirovschi.midps3.users.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EqualsValidator.class)
public @interface Equals
{
    String message();

    String property();

    String with();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

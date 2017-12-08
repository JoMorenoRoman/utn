package com.utn.annotations;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(FIELD)
//clase contenedora para poder implementar @Repeatable
public @interface CampoContainer {
	Campo[] value();
}

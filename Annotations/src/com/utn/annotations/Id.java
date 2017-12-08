package com.utn.annotations;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(FIELD)
@Repeatable(IdContainer.class)
//clase que define el Id de una tabla, se asume que este Id lo asigna la tabla asi que se omite a la
//hora de insertar un objeto
public @interface Id {
	String campo();
	String tabla();

}

package com.utn.annotations;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(FIELD)
@Repeatable(CampoContainer.class)
/*
 * Esta anotacion va a quedar en la clase donde este presente
 * despues de que se compile, esta hecha para ser usada en campos de una clase
 * y se puede repetir varias veces ojo con @Repeatable porque solo existe a partir de 
 * java 1.8 no esta en versiones anteriores
 */
public @interface Campo {
	String campo();
	String tabla();

}

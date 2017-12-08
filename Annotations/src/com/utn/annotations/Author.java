package com.utn.annotations;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.SOURCE;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(SOURCE)
@Target(TYPE)
/**
 * 
 * @author Java
 *	anotacion que contiene info sobre el autor de la clase
 *  asi como comentarios, el estado de la clase y hasta que etapa de produccion llega
 *  como el tipo de @Retention es SOURCE esta anotacion se desecha de las clases donde esta presente 
 *  a la hora de compilarlas
 */
public @ interface Author {
	
	String autor();
	String fecha();
	 enum Scope {DEV,PRODUCTION,DEPRECATED }
	Scope scope();
	enum State {FINISHED,UNFINISHED }
	State estado ();
	String[] comentarios();
}

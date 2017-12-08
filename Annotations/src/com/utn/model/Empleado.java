package com.utn.model;

import com.utn.annotations.Author;
import com.utn.annotations.Entity;
import com.utn.annotations.Id;
import com.utn.annotations.Campo;
import com.utn.annotations.Author.Scope;
import com.utn.annotations.Author.State;

@Author(autor = "Amilcar", comentarios = { "falta la implementacion del resto de los metodos fuera del get/set/constructor",
		"No esta anotada para la base de datos" },
estado = State.UNFINISHED, fecha = "05/12/2017", scope = Scope.PRODUCTION)
@Entity(tabla = "empleados")
@Entity(tabla = "usuarios")
public class Empleado {
	
	@Id(campo = "ID", tabla = "usuarios")
	private int idUsuario;
	@Campo(campo = "NOMBRE", tabla = "usuarios")
	@Campo(campo = "NOMBRE", tabla = "empleados")
	private String nombre;
	@Campo(campo = "APELLIDO", tabla = "usuarios")
	@Campo(campo = "APELLIDO", tabla = "empleados")
	private String apellido;
	@Id(campo = "ID", tabla = "empleados")
	private int id;
	@Campo(campo = "PUESTO", tabla = "empleados")
	private String Puesto;
	@Campo(campo = "SUELDO", tabla = "empleados")
	private double sueldo;
	@Campo(campo = "DNI", tabla = "usuarios")
	@Campo(campo = "DNI", tabla = "empleados")
	private String dni;
	
	
	public Empleado(int idUsuario, String nombre, String apellido, int id, String puesto, double sueldo, String dni) {
		super();
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.apellido = apellido;
		this.id = id;
		Puesto = puesto;
		this.sueldo = sueldo;
		this.dni = dni;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPuesto() {
		return Puesto;
	}
	public void setPuesto(String puesto) {
		Puesto = puesto;
	}
	public double getSueldo() {
		return sueldo;
	}
	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	

}

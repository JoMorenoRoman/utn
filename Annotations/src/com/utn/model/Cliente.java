package com.utn.model;

import com.utn.annotations.Author;
import com.utn.annotations.Entity;
import com.utn.annotations.Id;
import com.utn.annotations.Campo;
import com.utn.annotations.Author.Scope;
import com.utn.annotations.Author.State;


@Author(autor = "Hmno. Makana", comentarios = { "" },
estado = State.FINISHED, fecha = "28/11/2017", 
scope = Scope.PRODUCTION)
@Entity(tabla = "clientes")
@Entity(tabla = "usuarios")
public class Cliente {
	
	@Id(campo="ID", tabla ="usuarios")
	@Id(campo="ID", tabla ="clientes")
	private int id;
	@Campo(campo = "NOMBRE", tabla ="usuarios")
	@Campo(campo = "NOMBRE", tabla ="clientes")
	private String nombre;
	@Campo(campo = "APELLIDO", tabla = "usuarios")
	@Campo(campo = "APELLIDO", tabla = "clientes")
	private String apellido;
	@Campo(campo = "BALANCE", tabla = "clientes")
	private double balance;
	@Campo(campo = "DNI", tabla = "clientes")
	@Campo(campo = "DNI", tabla = "usuarios")
	private String dni;
	

	public double Deposito(double deposito) throws InstantiationException, IllegalAccessException {
		this.balance += deposito;
		return balance;
	}
	
	public double Extraccion(double retirar) throws FondosInsuficientes {
		try {
			if ((this.balance - retirar) > 0) { return this.balance-=retirar;
			} else {
				throw new FondosInsuficientes();
			} 
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return balance;
		
		
	}
	
	public Cliente(int id, String nombre, String apellido, double balance, String dni) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.balance = balance;
		this.setDni(dni);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}




	public String getDni() {
		return dni;
	}




	public void setDni(String dni) {
		this.dni = dni;
	}
	
	
}

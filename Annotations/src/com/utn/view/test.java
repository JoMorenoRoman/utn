package com.utn.view;

import com.utn.controller.ConexionMySQL;
import com.utn.model.Cliente;
import com.utn.model.Empleado;

public class test {

	public static void main(String[] args) {
		Cliente cl = new Cliente(1, "julio", "margana", 4000.0, "1234");
		Empleado emp = new Empleado(2,"Alberto","Ramirez",23,"Jefazo",120000.0,"1235");
		ConexionMySQL conex = new ConexionMySQL();
		conex.Insertar(emp);
		conex.Insertar(cl);

	}

}

package com.utn.controller;

import java.lang.reflect.Field;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.jdbc.Connection;
import com.utn.annotations.Campo;
import com.utn.annotations.Entity;

public class ConexionMySQL {

	
	public static Connection conectoMysql(){
		
		Connection conn=null;
		try {
			Class.forName("com.mysql.jdbc.Driver"); 
			
			conn = (Connection)DriverManager.getConnection("jdbc:mysql://localhost/utnbanco","root","");
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
		
	}
	/**
	 * El metodo toma un Object pero usa como referencia la clase que fue instanciada
	 * de manera que la clase que querramos darle tiene que estar anotada con las anotaciones
	 * @Entity y @Campo para que pueda insertarla en la base de datos, y los nombres de campo y table
	 * tienen que coincidir con los nombres de la base de datos
	 */
	public  void Insertar(Object o) {
		try {
			//se usa un objeto Class para saber que anotaciones tiene la clase a nivel TYPE
			Class<? extends Object> claset =o.getClass();
			Entity[] anotaciones = claset.getDeclaredAnnotationsByType(com.utn.annotations.Entity.class);
			//checkeamos que la clase tenga al menos 1 anotacion del tipo @Entity
			if(anotaciones.length > 0) {
				for (Entity entity : anotaciones) {
					//usamos dos StringBuilder para construir el comando que se va a enviar a la base de datos
					//se crea un comando por cada anotacion @Entity que tiene la clase
					StringBuilder strk = new StringBuilder("insert into ");
					strk.append(entity.tabla()+" (");
					StringBuilder strk2 = new StringBuilder("values ('");
					//usamos un array de Field para recuperar los campos y averiguar cuales estan anotados con @Campo
					for (Field field : claset.getDeclaredFields()) {
						field.setAccessible(true);
						Campo[] array = field.getDeclaredAnnotationsByType(com.utn.annotations.Campo.class);
						if( array.length != 0) {
							for (Campo campo : array) {
								//chequeamos que la anotacion @Campo que recuperamos se incluya en el comando que estamos construyendo 
								//si pertenece a la misma tabla que la @Entity que estamos usando usa el objeto para completar el valor del campo
								if(campo.tabla().equals(entity.tabla())) {
									strk.append(campo.campo());
									strk.append(",");
									strk2.append(field.get(o).toString());
									strk2.append("','");
								}		
							}
						}	
					}
					//limpiamos los Stringbuilders y los combinamos para terminar el comando
					//creamos la conexion a la base y lo enviamos
					strk.deleteCharAt(strk.length()-1);
					strk.append(") ");
					strk2.deleteCharAt(strk2.length()-1);
					strk2.deleteCharAt(strk2.length()-1);
					strk2.append(")");
					strk.append(strk2);
					System.out.println(strk.toString());
					com.mysql.jdbc.PreparedStatement ps = (com.mysql.jdbc.PreparedStatement) ConexionMySQL.conectoMysql()
							.prepareStatement(strk.toString());
					ps.execute();
				}
			}
		System.out.println("listo");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
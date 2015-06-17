package com.ejemplo.JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.hibernate.Session;

import com.ejemplo.interfaz.IRecuperable;

public class EmpJDBCDAO implements IRecuperable{

	Connection connection;
	ResultSet rs;
	Statement st;
	
	
	public Object leerEmpleado(int n) {
		// TODO Auto-generated method stub
		return null;
	}
	

}

package br.com.fiap.fintech.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

public class ConexaoBanco {
	
	private static Connection conn;
	private static String usuario = "RM93678";
	private static String senha = "DtNasc#190896";
	private static String urlBanco = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl";
	private static String driver = "oracle.jdbc.driver.OracleDriver";
	
	
	
	public static Connection getConexao(){
		try {
			
			Class.forName(driver);
			conn = DriverManager.getConnection(urlBanco, usuario, senha);
			
		}catch (SQLException e){
			System.err.println("Não conseguiu conectar no Banco de Dados");
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			System.err.println("O Driver JDBC nao foi encontrado!");
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void closeResult(ResultSet rs) {
		
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	public static void closeStatement (Statement stmt) {
		
		try {
			if (stmt != null) {
				stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	} 
	
	protected static void closeConnection(Connection conn) {
		
		try {
			if ((conn != null) && (!conn.isClosed())) {
				conn.close();
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	protected void setInteger(PreparedStatement stmt, int paramPosition, Integer paramValue) throws SQLException {
		
		if (paramValue == null) {
			stmt.setNull(paramPosition, Types.INTEGER);
		}
		else {
			stmt.setInt(paramPosition, paramValue.intValue());
		}
	}
}

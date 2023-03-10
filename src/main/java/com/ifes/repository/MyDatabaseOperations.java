package com.ifes.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.ifes.repository.MyConnection;

public class MyDatabaseOperations {
	
	/*
		Tabela utiliza no teste
	 
		create table teste(
			cod_teste		int			not null
		,	nom_teste		varchar(10)	not null
		);
		
		alter table teste add primary key (cod_teste);
	 
	 */
	
	public static void runExamples() {
		
		
		MyConnection myConnection = MyConnection.createMyConnection();
		myConnection.setDriver("org.postgresql.Driver");
		myConnection.setUrl("jdbc:postgresql://localhost:5432/");
		myConnection.setDatabaseName("myTest");
		myConnection.setUser("postgres");
		myConnection.setPassword("admin");
		
		try {
			
			runInserts(myConnection);
			
			runUpdate(myConnection);
			
			runDelete(myConnection);
			
			System.out.println("Dados slavos com sucesso.");
			
			runSelect(myConnection);
			
			myConnection.closeConnection();
			
		} catch (ClassNotFoundException e) {
			System.out.println("Mensagem de erro: " + e.getMessage());
			System.out.println("O Java exibiindo o Strack Trace abaixo\n\n");
			e.printStackTrace();
			try {
				myConnection.getConnection().rollback();
				myConnection.closeConnection();
			} catch (Exception e1) {
				System.out.println("Erro ao realizar o rollback");
				e1.printStackTrace();
			};
		} catch (SQLException e) {
			System.out.println("Mensagem de erro: " + e.getMessage());
			System.out.println("O Java exibiindo o Strack Trace abaixo\n\n");
			try {
				myConnection.getConnection().rollback();
				myConnection.closeConnection();
			} catch (Exception e1) {
				System.out.println("Erro ao realizar o rollback");
				e1.printStackTrace();
			};
		} catch (Exception e) {
			System.out.println("Mensagem de erro: " + e.getMessage());
			System.out.println("O Java exibiindo o Strack Trace abaixo\n\n");
			try {
				myConnection.getConnection().rollback();
				myConnection.closeConnection();
			} catch (Exception e1) {
				System.out.println("Erro ao realizar o rollback");
				e1.printStackTrace();
			};
		}
	}
	
	private static void runInserts(MyConnection myConnection) throws SQLException, ClassNotFoundException {
		String script;
		
		Connection connection = myConnection.getConnection();
		
		// O padr�o � TRUE. Isso significa que a cada insert o java abre e fecha a transa��o pra voc�
		connection.setAutoCommit(false);
		
		Statement statement = connection.createStatement();
		
		script = "INSERT INTO teste (cod_teste, nom_teste) VALUES (1, 'teste1')";
		
		statement.executeUpdate(script);
		
		script = "INSERT INTO teste (cod_teste, nom_teste) VALUES (2, 'teste2')";
		
		statement.executeUpdate(script);
		
		script = "INSERT INTO teste (cod_teste, nom_teste) VALUES (3, 'teste3')";
		
		statement.executeUpdate(script);
		statement.close();
		
		connection.commit();
	}
	
	private static void runUpdate(MyConnection myConnection) throws ClassNotFoundException, SQLException {
		String script;
		
		Connection connection = myConnection.getConnection();
		// O padr�o � TRUE. Isso significa que a cada insert o java abre e fecha a transa��o pra voc�
		connection.setAutoCommit(true);
		
		Statement statement = connection.createStatement();
		
		script = "UPDATE teste SET nom_teste = 'teste 222' WHERE cod_teste = 2";
		
		statement.executeUpdate(script);
		statement.close();
	}
	
	public static void runDelete(MyConnection myConnection) throws ClassNotFoundException, SQLException {
		String script;
		
		Connection connection = myConnection.getConnection();
		// O padr�o � TRUE. Isso significa que a cada insert o java abre e fecha a transa��o pra voc�
		connection.setAutoCommit(true);
		
		Statement statement = connection.createStatement();
		
		script = "DELETE FROM teste WHERE cod_teste = 3";
		
		statement.executeUpdate(script);
		statement.close();
	}
	
	public static void runSelect(MyConnection myConnection) throws ClassNotFoundException, SQLException {
		String codTeste;
		String nomTeste;
		Connection connection = myConnection.getConnection();
		Statement statement = connection.createStatement();
		
		
		ResultSet rs = statement.executeQuery("SELECT cod_teste, nom_teste FROM teste");

		while(rs.next()) {
			codTeste = rs.getString(1);
			nomTeste = rs.getString(2);
			
			System.out.println("Código: " + codTeste + "\tNome: " + nomTeste);
		}
		rs.close();
		statement.close();
	}
}

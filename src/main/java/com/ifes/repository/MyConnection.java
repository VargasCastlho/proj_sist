package com.ifes.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {

	private String myUrl = "jdbc:postgresql://localhost:5432/";
	private String myDriver = "org.postgresql.Driver";
	private String myDatabaseName = "postgres";
	private String myUser = "postgres";
	private String myPassword = "postgres";

	private Connection connection;

	private static MyConnection myConnection;

	private MyConnection() {
	}

	public String getUrl() {
		return myUrl;
	}

	public void setUrl(String url) {
		myUrl = url;
	}

	public String getDriver() {
		return myDriver;
	}

	public void setDriver(String driver) {
		myDriver = driver;
	}

	public String getDatabaseName() {
		return myDatabaseName;
	}

	public void setDatabaseName(String databaseName) {
		myDatabaseName = databaseName;
	}

	public String getUser() {
		return myUser;
	}

	public void setUser(String user) {
		myUser = user;
	}

	public String getPassword() {
		return myPassword;
	}

	public void setPassword(String password) {
		myPassword = password;
	}

	public static MyConnection createMyConnection() {
		if (myConnection == null)
			myConnection = new MyConnection();
		return myConnection;
	}

	public Connection getConnection() throws ClassNotFoundException, SQLException {
		if (connection == null || connection.isClosed()) {
			if (myDriver == null) {
				throw new ClassNotFoundException("Driver não informado!");
			}
			if (myUrl == null) {
				throw new ClassNotFoundException("URL não informada!");
			}
			if (myDatabaseName == null) {
				throw new ClassNotFoundException("DatabaseName não informado!");
			}
			if (myUser == null) {
				throw new ClassNotFoundException("User não informado!");
			}
			if (myPassword == null) {
				throw new ClassNotFoundException("Password não informado!");
			}

			Class.forName(myDriver);
			connection = DriverManager.getConnection(myUrl + myDatabaseName, myUser, myPassword);
		}
		return connection;
	}
	
	public void closeConnection() throws SQLException {
		connection.close();
		connection = null;
	}

}

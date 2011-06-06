package com.cs.srs.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.Date;

import com.cs.srs.Config;

public class Model {
    private static volatile Connection connect;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private String table;

    public Model(String table) {
	this.table = table;
	try {
	    Class.forName("com.mysql.jdbc.Driver");
	} catch(ClassNotFoundException e) {
	    e.printStackTrace();
	}

	try {
	    connect = getConnect();
	    statement = connect.createStatement();
	} catch(SQLException e) {
	    e.printStackTrace();
	}
    }

    public Connection getConnect() throws SQLException {
	if (connect == null) {
	    synchronized(Connection.class) {
		if (connect == null) {
		    connect = DriverManager.getConnection("jdbc:mysql://"
							  + Config.db_host + "/"
							  + Config.db_name + "?user="
							  + Config.db_username + "&password="
							  + Config.db_password);
		}
	    }
	}
	return connect;
    }

    public boolean update(String updateQuery) {
	try {
	    return statement.execute(updateQuery);
	} catch(SQLException e) {
	    e.printStackTrace();
	}
	return false;
    }

    public ResultSet query(String query) {
	try {
	    return statement.executeQuery(query);
	} catch(SQLException e) {
	    e.printStackTrace();
	}
	return null;
    }
}
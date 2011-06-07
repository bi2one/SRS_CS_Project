package com.cs.srs.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.Date;
import java.util.HashMap;
import java.util.ArrayList;

import com.cs.srs.Config;
import com.cs.srs.model.data.SRSData;

public abstract class Model {
    private static volatile Connection connect;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private String table;

    protected abstract SRSData createDataByResultSet(ResultSet result) throws SQLException;

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

    public String getTableName() {
	return table;
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

    public boolean insert(String[] values) {
	String query = "INSERT INTO " + table + " VALUES (";
	for(int i = 0; i < values.length - 1; i++) {
	    query += values[i] + ", ";
	}
	query += values[values.length - 1] + ")";

	// System.out.println(query);
	return update(query);
    }

    public boolean updateById(HashMap<String, String> valuePairs, int id) {
	String query = "UPDATE " + table + " SET ";
	Object[] colNames = valuePairs.keySet().toArray();

	for (int i = 0; i < colNames.length - 1; i++) {
	    query += colNames[i] + "=" + valuePairs.get(colNames[i]) + ", ";
	}
	query += colNames[colNames.length - 1] + "=" + valuePairs.get(colNames[colNames.length - 1]) + " WHERE id=" + id;

	// System.out.println(query);
	return update(query);
    }

    public ResultSet findById(int id) {
	return simpleFind("id", id + "", "id", true);
    }

    public ResultSet simpleFind(String field, String value, String orderBase, boolean isAsc) {
	String order = (isAsc)? "ASC":"DESC";
	String findQuery = "SELECT * FROM " + table + " WHERE " + field + "=" + value + " ORDER BY " + orderBase + " " + order;
	return query(findQuery);
    }

    public ResultSet findAll() {
	return query("SELECT * FROM " + table);
    }

    public ArrayList<SRSData> simpleFindItem(String field, String value, String orderBase, boolean isAsc) {
	ArrayList<SRSData> items = new ArrayList<SRSData>();
	ResultSet result = simpleFind(field, value, orderBase, isAsc);

	try {
	    while(result.next()) {
		SRSData item = createDataByResultSet(result);
		items.add(item);
	    }
	} catch(SQLException e) {
	    e.printStackTrace();
	}
	return items;
    }

    public ArrayList<SRSData> findAllItem() {
	return simpleFindItem("1", "1", "id", true);
    }

    public SRSData findItemById(int id) {
	ResultSet result = findById(id);
	try {
	    if (result.next()) {
		SRSData data = createDataByResultSet(result);
		data.setId(id);
		return data;
	    } else {
		return null;
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	    return null;
	}
    }

    public boolean save(SRSData data) {
	if (data.getId() != 0) {
	    ResultSet existingData = findById(data.getId());
	    try {
		if(existingData.next()) {
		    return updateById(data.getValuePair(), data.getId());
		} else {
		    return insert(data.getValueTuple());
		}
	    } catch(SQLException e) {
		e.printStackTrace();
	    }
	} else {
	    return insert(data.getValueTuple());
	}
	return false;
    }

    public boolean remove(SRSData data) {
	return remove(data.getId());
    }

    public boolean remove(int id) {
	return remove("id", id + "");
    }

    public boolean remove(String field, String value) {
	String removeQuery = "DELETE FROM " + table + " WHERE " + field + "=" + value;
	return update(removeQuery);
    }
}
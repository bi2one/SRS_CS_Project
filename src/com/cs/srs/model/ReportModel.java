package com.cs.srs.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.cs.srs.model.data.Report;
import com.cs.srs.model.data.SRSData;

public class ReportModel extends Model {
    public ReportModel() {
	super("reports");
    }

    protected SRSData createDataByResultSet(ResultSet result) throws SQLException {
	return new Report(result.getString("filename"),
			  result.getInt("members_id"));
    }    
}
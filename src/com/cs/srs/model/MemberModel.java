package com.cs.srs.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cs.srs.model.data.Member;
import com.cs.srs.model.data.Member.Kind;
import com.cs.srs.model.data.SRSData;

public class MemberModel extends Model {
    public static final String TABLE = "members";
    public static final String TN_KIND = "kind";
    public static final String TN_USERNAME = "username";
    public static final String TN_PASSWORD = "password";
    
    
    public MemberModel() {
	super(TABLE);
    }

    protected SRSData createDataByResultSet(ResultSet result) throws SQLException {
	return new Member(Kind.toKind(result.getString(TN_KIND)),
			  result.getString(TN_USERNAME),
			  result.getString(TN_PASSWORD));
    }

    public ArrayList<SRSData> findItemByKind(Kind kind) {
	return simpleFindItem(TN_KIND, "\"" + kind.toString() + "\"", "id", true);
    }
}
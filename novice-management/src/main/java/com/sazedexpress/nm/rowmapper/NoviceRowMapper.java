package com.sazedexpress.nm.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sazedexpress.nm.api.Novice;

public class NoviceRowMapper implements RowMapper<Novice>{

	@Override
	public Novice mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Novice novice=new Novice();
		novice.setId(rs.getInt("id"));
		novice.setName(rs.getString("name"));
		novice.setMobile(rs.getLong("mobile"));
		novice.setCountry(rs.getString("country"));
		return novice;
	}

}

package com.sazedexpress.nm.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sazedexpress.nm.api.Novice;
import com.sazedexpress.nm.rowmapper.NoviceRowMapper;



@Repository
public class NoviceDAOImpl implements NoviceDAO{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public List<Novice> loadNovice() {
		String sql="SELECT * FROM mazedexpress.students";
		List<Novice> noviceList=jdbcTemplate.query(sql, new NoviceRowMapper());
		return noviceList;
	}

	@Override
	public Novice getNoviceById(int id) {
		String sqlString="SELECT * FROM students WHERE id=?";
		Novice novice=jdbcTemplate.queryForObject(sqlString, new NoviceRowMapper(), id);
		return novice;
	}

	@Override
	public void saveNovice(Novice novice) {
		String sqlString="INSERT INTO students(name,mobile,country) VALUES(?,?,?)";
		Object[] sqlParam= {novice.getName(),novice.getMobile(),novice.getCountry()};
		int numOfRowAffected=jdbcTemplate.update(sqlString, sqlParam);
		if (numOfRowAffected>0) {
			System.out.println("Data Saved Successfully");
		}else {
			System.out.println("Data Not Saved ! Please Try Again");
		}
		
	}

	@Override
	public void deleteNovice(int id) {
		
		String sqlString="DELETE from students WHERE id=?";
		int numOfRowAffected=jdbcTemplate.update(sqlString, id);
		if (numOfRowAffected>0) {
			System.out.println("Data Deleted");
		}else {
			System.out.println("Data not Deleted");
		}
		
	}

	@Override
	public void updateNovice(Novice novice) {
		String sqlString="UPDATE students set name=?, mobile=?, country=? where id=?";
		Object[] sqlParam= {novice.getName(),novice.getMobile(),novice.getCountry(),novice.getId()};
		int numOfRowAffected=jdbcTemplate.update(sqlString, sqlParam);
		if (numOfRowAffected>0) {
			System.out.println("Data Updated Successfully");
		}else {
			System.out.println("Data Not Updated ! Please Try Again");
		}
		
	}

}

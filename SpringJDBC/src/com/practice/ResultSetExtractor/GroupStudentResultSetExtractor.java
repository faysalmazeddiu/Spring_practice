package com.practice.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

public class GroupStudentResultSetExtractor implements ResultSetExtractor<Map<String, List<String>>> {

	@Override
	public Map<String, List<String>> extractData(ResultSet rs) throws SQLException, DataAccessException {
		// TODO Auto-generated method stub
		Map<String, List<String>> studentMap = new HashMap<String, List<String>>();
		while (rs.next()) {
			String studenDept = rs.getString("student_dept");  //key 
			String studentName = rs.getString("student_name"); //value
			List<String> studentNameList = studentMap.get(studenDept);
			if (studentNameList == null) {
				ArrayList<String> newStudentNameList = new ArrayList<String>();
				newStudentNameList.add(studentName);
				studentMap.put(studenDept, newStudentNameList);
			} else {
				studentNameList.add(studentName);
				studentMap.put(studenDept, studentNameList); // Abilas did not do that
			}

		}

		return studentMap;
	}

}

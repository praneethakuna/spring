package com.inautix.Spring;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;




public class PatientMapper implements RowMapper<Patient>{

	public Patient mapRow(ResultSet rs, int rowNum) throws SQLException {
		Patient patient = new Patient();
		patient.setId(rs.getInt(1));
		patient. setAge(rs.getInt(3));
		patient.setName(rs.getString(2));
	      return patient;
	   }	
}


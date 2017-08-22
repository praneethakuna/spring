package com.inautix.Spring;

import java.awt.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;



public class Patientdao {
	
	private DataSource dataSource;
	   private JdbcTemplate jdbcTemplateObject;
	   
	   public void setDataSource(DataSource dataSource) {
		      this.dataSource = dataSource;
		      this.jdbcTemplateObject = new JdbcTemplate(dataSource);
		   }

	
	public String createPatient(Patient patient){
		
      String sql ="insert into patient_xbbnhdu values ("+patient.getId()+",'"+patient.getName()+"','"+patient.getAge()+"')";
      System.out.println("sql "+sql);			

      jdbcTemplateObject.update(sql);
	return "inserted";
			
			
   }
	public Patient getPatient(Integer id) {
		 Patient patient =null;
		try{
	      String SQL = "select * from patient_xbbnhdu where patientid ='"+id+"'";
	      patient =jdbcTemplateObject.queryForObject(SQL,new Object[]{} ,new PatientMapper());
	      return patient;
		}
		catch(Exception e)
		{
			System.out.println(e);}
		return patient;
		}


	public String updatePatient(int id, Patient p) {
		
			String sql="update patient_xbbnhdu set pateintname='"+p.getName()+"' where patientid="+id+"";
			jdbcTemplateObject.update(sql);
			// TODO Auto-generated method stub
			return "updated";
		}
	public List getAll() {
		// TODO Auto-generated method stub
		String sql="select * from patient_xbbnhdu";
		java.util.List<Patient> l1=jdbcTemplateObject.query(sql,new PatientMapper());
		return (List) l1;
	}
		










}

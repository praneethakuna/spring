package com.inautix.Spring;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class PatientService {
	


	
		@Autowired
		Patientdao patientdao;

	   	

	    
@RequestMapping(value="/patients",method=RequestMethod.POST)
public @ResponseBody String createPatient(@RequestBody Patient p)
{
	String s1=patientdao.createPatient(p);
	return s1;
}


@RequestMapping(value="/patient/{id}",method=RequestMethod.GET)
public @ResponseBody Patient getPatient(@PathVariable("id") int id){
	Patient patient = patientdao.getPatient(id);
	return patient;
}
@RequestMapping(value="/patient/{id}",method=RequestMethod.PUT)
public @ResponseBody String getPatient(@PathVariable("id") int id,@RequestBody Patient p){
	String patient = patientdao.updatePatient(id,p);
	return patient;
	
  
}
@RequestMapping(value="/students",method=RequestMethod.GET)
public @ResponseBody List<Patient> createPatient()
{
	List l=new ArrayList();
	l=(List) patientdao.getAll();
	return l;
}
}
	    
	



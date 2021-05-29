package com.ncu.jdbcDemo.Dao;
import java.util.List;

import com.ncu.model.customer;

public interface CustomerDao {
	  
	

	

	

		    public void save(customer user);
			public customer getcustomerById(String Email);

		    public void Update(customer user);
		     
		    public void delete(String email);
		     
		    public customer get(String email);
		     
		    public List<customer> list();
		
	}



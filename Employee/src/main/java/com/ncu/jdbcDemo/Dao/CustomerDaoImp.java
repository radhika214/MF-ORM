package com.ncu.jdbcDemo.Dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


import com.ncu.model.customer;

class CustomerMapper implements RowMapper<customer>{
	@Override
	public customer mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		
		customer user = new customer();
		 user.setEmail(rs.getString("email"));
         user.setPassword(rs.getString("password"));
         user.setFname(rs.getString("fname"));
         user.setLname(rs.getString("lname"));
        
		return   user;
		
		
	}
	
}


@Repository
public class CustomerDaoImp implements CustomerDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public CustomerDaoImp(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
	
	@Override
	public void save(customer user) {
		// TODO Auto-generated method stub
		String sql = "insert into user values(?,?,?,?,?,?)";

        jdbcTemplate.update(sql, new Object[]
        { user.getFname(), user.getLname(), user.getEmail(), user.getPno() , user.getGender() , user.getPassword() });
		
	}

		


	@Override
	public void delete(String email) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public customer get(String email) {
		String sql = "SELECT * FROM user where email='" + email + "'";
	    return jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(customer.class));
		
	}

	@Override
	public List<customer> list() {
//		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
//        String sql = "SELECT * from users";
//        List<User> listUser = jdbcTemplate.query(sql,new RowMapper<User>()  {
// 
//         @Override
//			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
//				  User user = new User();
//	                user.setEmail(rs.getString("puneet.gmail.com"));
//	                user.setPassword(rs.getString("abc@123"));
//	                user.setFname(rs.getString("Puneet"));
//	                return user;
//				
//			}
//             
//        });
//        return listUser;
        return null;
	}

	@Override
	public void Update(customer user) {
		// TODO Auto-generated method stub
		String sql = "update user set fname =?, lname=?,pno=?,gender=?,password=? where email=?";
        jdbcTemplate.update(sql, new Object[]
        { user.getFname(), user.getLname(), user.getEmail(), user.getPno() , user.getGender() , user.getPassword() });
		
	}

	@Override
	public customer getcustomerById(String Email) {
		// TODO Auto-generated method stub
		 String sql = "select * from employee where email=?";
		 customer user = ( customer) jdbcTemplate.queryForObject(sql, new Object[]
			        { Email }, new  CustomerMapper());

//						public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
//							Employee employee = new Employee();
//			                employee.setId(rs.getInt(1));
//			                employee.setAge(rs.getInt(2));
//			                employee.setDept(rs.getString(3));
//			                employee.setName(rs.getString(4));
//			                return employee;
//						}
//			 
//			 
//			        });
		return user;
			        
			           
		
		 
		
	}
	
		

}

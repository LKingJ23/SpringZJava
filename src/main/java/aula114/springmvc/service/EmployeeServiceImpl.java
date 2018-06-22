package aula114.springmvc.service;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;


import java.util.List;
import java.util.ArrayList;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aula114.springmvc.domain.Contact;

@Service
public class EmployeeServiceImpl implements EmployeeService {
        @Autowired
        private JdbcTemplate jdbcTemplate;
        //private Jedis conn;
        //public EmployeeServiceImpl() {
          //conn = new Jedis("localhost");
          //conn.select(12);
        //}

	@Override
	public List<Contact> listAllEmployee() {
           List<Contact> laList = new ArrayList<Contact>();
           String sql0 = "select name,telephone,address,email from contact";
           laList = jdbcTemplate.query(sql0, new BeanPropertyRowMapper<Contact>(Contact.class));
          /*
           List<String> list1 = new ArrayList<String>();
           Set<String> list = conn.smembers("nombreUsuarios");
           for(String st : list) { 
             list1.add(st);
           }
           return list1;
          */
        //  return null;
           return laList;
	}
}

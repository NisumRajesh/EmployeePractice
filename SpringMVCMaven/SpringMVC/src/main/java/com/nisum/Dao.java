package com.nisum;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class Dao {
	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public int save(Employee p) {
		String sql = "insert into employee(Id,name,dept,age,salary,location) values('" + p.getId() + "','" + p.getName() + "','"
				+ p.getDept() + "','" + p.getAge() + "','" + p.getSalary() + "','" + p.getLocation() + "')";
		return template.update(sql);
	}

	public int update(Employee p) {
		String sql = "update employee set name='"+p.getName()+"',dept='"+p.getDept()+"',age='"+p.getAge()+"',salary='"+p.getSalary()+"',location='"+p.getLocation()+"' where id='"+p.getId()+"'";
				
		return template.update(sql);
	}

	public int delete(int id) {
		String sql = "delete from employee where id=" + id + "";
		return template.update(sql);
	}

	public Employee getEmpById(int id) {
		String sql = "select * from employee where id=?";
		return template.queryForObject(sql, new Object[] { id }, new BeanPropertyRowMapper<Employee>(Employee.class));
	}

	public List<Employee> getEmployees() {
		return template.query("select * from employee", new RowMapper<Employee>() {
			public Employee mapRow(ResultSet rs, int row) throws SQLException {
				Employee e = new Employee();
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setDept(rs.getString(3));
				e.setAge(rs.getInt(4));
				e.setLocation(rs.getString(6));
				e.setSalary(rs.getInt(5));
				return e;
			}
		});
	}

}
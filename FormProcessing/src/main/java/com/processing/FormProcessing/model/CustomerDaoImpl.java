package com.processing.FormProcessing.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.processing.FormProcessing.view.vo.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {
	@Autowired(required = true)
	private HibernateTemplate hibernateTemplate;

	public CustomerDaoImpl() {
	}

	@Override
	@Transactional(readOnly = false)
	public int save(Customer c) {
		return (Integer) hibernateTemplate.save(c);
	}

	@Override
	public void delete(int eno) {
	}

	@Override
	public Customer get(int eno) {
		return null;
	}

	@Override
	public void update(Customer e) {
	}
}

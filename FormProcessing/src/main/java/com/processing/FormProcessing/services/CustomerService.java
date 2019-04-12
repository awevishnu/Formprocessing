package com.processing.FormProcessing.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.processing.FormProcessing.model.CustomerDao;
import com.processing.FormProcessing.view.vo.Customer;
@Service
public class CustomerService {
	@Autowired
	private CustomerDao customerDao;

	public int processCustomer(Customer c){
		return customerDao.save(c);
	}
}

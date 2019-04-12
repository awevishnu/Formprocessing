package com.processing.FormProcessing.model;

import com.processing.FormProcessing.view.vo.Customer;

public interface CustomerDao {
	public int save(Customer e);
	public void update(Customer e);
	public void delete(int eno);
	public Customer get(int eno);
}

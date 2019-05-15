package com.kitri.service;

import com.kitri.dao.CustomerDao;
import com.kitri.dto.Customer;
import com.kitri.exception.NotFoundException;

public class CustomerService {

	public String login(String id, String pass) {
		try {
			Customer customer = CustomerDao.getCustomerDao().selectById(id);
			if (pass.equals(customer.getPass())) {
				System.out.println("CustomerService// 입력 pass: " + pass + "\t데이터베이스 pass:" + customer.getPass());
				return "1";
			} else {
				return "-1";
			}
		} catch (NotFoundException e) {
			e.printStackTrace();
		}
		return "-1";
	}

}

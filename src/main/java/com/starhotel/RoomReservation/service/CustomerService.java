package com.starhotel.RoomReservation.service;
import com.starhotel.RoomReservation.domain.Customer;
import com.starhotel.RoomReservation.repository.CustomerRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
@Transactional(readOnly = false)
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;


	public List<Customer> getCustomers() {
		return customerRepository.findAll();
	}
	
	public void save(Customer customer) {
		customerRepository.save(customer);
	}
	
	public Customer get(long id) {
		return customerRepository.findById(id).get();
	}
	
	public void delete(long id) {
		customerRepository.deleteById(id);
	}



}

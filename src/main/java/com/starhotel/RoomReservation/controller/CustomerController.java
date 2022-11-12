package com.starhotel.RoomReservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.starhotel.RoomReservation.domain.Customer;
import com.starhotel.RoomReservation.service.CustomerService;

import java.util.List;


// Problem mit der @Controller vs @RestController !!!!
@Controller
public class CustomerController {

	@Autowired
    private CustomerService service;
	
    @GetMapping("/")
    public String viewHomePage(Model model) {
        List<Customer> customers  = service.getCustomers();
        model.addAttribute("customers", customers);
        System.out.print("Get / ");	
        return "index";
    }
   
    
    @GetMapping("/new")
    public String add(Model model) {
        model.addAttribute("customer", new Customer());
        return "new";
    }


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveCustomer(@ModelAttribute("customer") Customer customer) {
        service.save(customer);
        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditCustomerPage(@PathVariable(name = "id") long id) {
        ModelAndView mav = new ModelAndView("new");
        Customer customer = service.get(id);
        mav.addObject("customer", customer);
        return mav;
        
    }
    @RequestMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable(name = "id") long id) {
        service.delete(id);
        return "redirect:/";
    }
    
    
    
}

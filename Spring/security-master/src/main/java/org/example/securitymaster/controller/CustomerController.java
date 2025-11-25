package org.example.securitymaster.controller;

import lombok.RequiredArgsConstructor;
import org.example.securitymaster.dao.CustomerDao;
import org.example.securitymaster.entity.Customer;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerDao customerDao;
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','CUSTOMERS_PAG_VIEW', 'CUSTOMERS_READ')")
    @GetMapping("/customers")
    public String listAllCustomers(Model model){
        model.addAttribute("customers",customerDao.findAll());
        return "customers";
    }
    @PreAuthorize("hasRole('SUPER_ADMIN')")
    @GetMapping("/customer-create")
    public String createCustomer(Model model){
        model.addAttribute("customer",new Customer());
        return "customerForm";
    }
    @PreAuthorize("hasRole('SUPER_ADMIN')")
    @PostMapping("/customer-create")
    public String saveCustomer(Customer customer, BindingResult result){
        if(result.hasErrors()){
            return "customerForm";
        }
        customerDao.save(customer);
        return "redirect:/customers";
    }
    @PreAuthorize("hasRole('SUPER_ADMIN')")
    // /delete-customer?id=
    @GetMapping("/delete-customer")
    public String deleteCustomer(@RequestParam("id")int id){
        customerDao.deleteById(id);
        return "redirect:/customers";
    }
}

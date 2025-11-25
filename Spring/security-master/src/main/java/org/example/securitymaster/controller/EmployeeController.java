package org.example.securitymaster.controller;


import jakarta.annotation.security.RolesAllowed;
import org.example.securitymaster.dao.EmployeeDao;
import org.example.securitymaster.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeDao employeesDao;

    @RolesAllowed({"SUPER_ADMIN","EMPLOYEES_ADMIN"})
    @GetMapping("/employees")
    public ModelAndView index() {
        return new ModelAndView("employees", "employees", employeesDao.findAll());
    }

    @RolesAllowed({"SUPER_ADMIN","EMPLOYEES_ADMIN"})
    @GetMapping("/employees/create")
    public ModelAndView create() {
        return new ModelAndView("employee-create", "employee", new Employee());
    }

    @RolesAllowed({"SUPER_ADMIN","EMPLOYEES_ADMIN"})
    @PostMapping("/employees/create")
    public String create(@ModelAttribute Employee employee, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "employee-create";
        } else {
            employeesDao.save(employee);

            return "redirect:/employees";
        }
    }

    @RolesAllowed({"SUPER_ADMIN","EMPLOYEES_ADMIN"})
    @GetMapping("/employees/delete/{id}")
    public String delete(@PathVariable Integer id) {
        employeesDao.deleteById(id);

        return "redirect:/employees";
    }
}

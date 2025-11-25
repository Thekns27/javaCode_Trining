package org.example.securitymaster.controller;

import org.example.securitymaster.dao.DepartmentDao;
import org.example.securitymaster.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DepartmentController {
    @Autowired
    private DepartmentDao departmentsDao;
    @Secured({"ROLE_DEPARTMENTS_PAG_VIEW","ROLE_SUPER_ADMIN"})
    @GetMapping("/departments")
    public ModelAndView index() {
        return new ModelAndView("departments", "departments", departmentsDao.findAll());
    }

    @Secured({"ROLE_DEPARTMENTS_PAG_VIEW","ROLE_SUPER_ADMIN"})
    @GetMapping("/departments/create")
    public ModelAndView create() {
        return new ModelAndView("department-create", "department", new Department());
    }
    @Secured({"ROLE_DEPARTMENTS_PAG_VIEW","ROLE_SUPER_ADMIN"})
    @PostMapping("/departments/create")
    public String create(@ModelAttribute Department department, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "department-create";
        } else {
            departmentsDao.save(department);

            return "redirect:/departments";
        }
    }

    @Secured({"ROLE_SUPER_ADMIN"})
    @GetMapping("/departments/delete/{id}")
    public String delete(@PathVariable Integer id) {
        departmentsDao.deleteById(id);

        return "redirect:/departments";
    }
}

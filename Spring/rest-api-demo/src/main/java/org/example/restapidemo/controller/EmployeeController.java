package org.example.restapidemo.controller;

import lombok.RequiredArgsConstructor;
import org.example.restapidemo.ds.EmployeeDto;
import org.example.restapidemo.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id")int employeeId){
        employeeService.deleteEmployee(employeeId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping(value = "/{id}",consumes = MediaType.TEXT_PLAIN_VALUE)
    public EmployeeDto updateEmployeeEmail(@RequestBody String email,
                                           @PathVariable("id")int id){
        return employeeService.updateEmployeeEmail(email,id);
    }
    @PutMapping("/{id}")
    public EmployeeDto updateEmployee(@PathVariable("id")int id,
                                      @RequestBody EmployeeDto employeeDto){
        return employeeService.updateEmployee(employeeDto,id);
    }

    @GetMapping(value="/V2",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<EmployeeDto> listAllEmployees(){

        return employeeService.listAllEmployee();
    }
    @GetMapping("/{id}")
    public EmployeeDto findEmployeeById(@PathVariable("id")int id){

        return employeeService.findEmployeeById(id);
    }
    @GetMapping(value = "/{id}/{type}")
    public ResponseEntity<EmployeeDto>
        findEmployeeByIdV2(@PathVariable("id")int id,
                           @PathVariable("type")String type){
        if("XML".equalsIgnoreCase(type)){
            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_XML)
                    .body(employeeService.findEmployeeById(id));
        }
        else if("JSON".equalsIgnoreCase(type)){
            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(employeeService.findEmployeeById(id));
        }
        else throw new RuntimeException("No Format Media Type!");


p qqz
    }
    /*
    curl-xpost-H "content-type: application/json" -d '{"firstName": "John", "lastName": "Doe","email": "john@gmail.com", "phoneNumber": "55-555-55", "salary": 2000.0}'
     */
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public EmployeeDto createEmployee(@RequestBody EmployeeDto employeeDto){
        return employeeService.createEmployee(employeeDto);
    }

}

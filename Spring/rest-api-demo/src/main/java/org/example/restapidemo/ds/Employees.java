package org.example.restapidemo.ds;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@ToString
@JacksonXmlRootElement(localName = "employees")
public class Employees {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "employee")
    private List<EmployeeDto> employees;

    public Employees(List<EmployeeDto> employees) {
        this.employees = employees;
    }
}

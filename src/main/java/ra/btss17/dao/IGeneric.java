package ra.btss17.dao;

import ra.btss17.entity.Employee;

import java.util.List;

public interface IGeneric {
    List<Employee> getEmployee();
    public Employee getEmployeeById(Integer empId);
    public boolean insertEmployee(Employee emp);
    public boolean updateEmployee(Employee emp);
    public boolean deleteEmployee(Integer empId);
    public List<Employee> getEmployeeByName(String name);
}

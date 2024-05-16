package ra.btss17.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.btss17.dao.EmployeeDaoImpl;
import ra.btss17.dao.IEmployeeDao;
import ra.btss17.entity.Employee;

import java.util.List;
@Service
public class EmployeeService implements IEmployeeService{
    @Autowired
    private IEmployeeDao employeeDao;
    @Override
    public List<Employee> getEmployee() {
        return employeeDao.getEmployee();
    }

    @Override
    public Employee getEmployeeById(Integer empId) {
        return employeeDao.getEmployeeById(empId);
    }

    @Override
    public boolean insertEmployee(Employee emp) {
        return employeeDao.insertEmployee(emp);
    }

    @Override
    public boolean updateEmployee(Employee emp) {
        return employeeDao.updateEmployee(emp);
    }

    @Override
    public boolean deleteEmployee(Integer empId) {
        return employeeDao.deleteEmployee(empId);
    }

    @Override
    public List<Employee> getEmployeeByName(String name) {
        return employeeDao.getEmployeeByName(name);
    }
}

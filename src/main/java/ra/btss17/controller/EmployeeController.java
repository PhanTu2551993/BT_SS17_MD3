package ra.btss17.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ra.btss17.entity.Employee;
import ra.btss17.service.IEmployeeService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = {"/","/Employee"})
public class EmployeeController {
    private final IEmployeeService employeeService;
    @Autowired
    public EmployeeController(IEmployeeService employeeService){
        this.employeeService = employeeService;
    }
    @GetMapping
    public String home(Model model) {
        List<Employee> employee = employeeService.getEmployee();
        model.addAttribute("employee",employee);
        return "/home";
    }
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("employee", new Employee());
        return "/create";
    }

    @PostMapping("/save")
    public String actionCreate(@Valid @ModelAttribute("employee") Employee employee, BindingResult result,Model model) {
        if (result.hasErrors())
        {
            model.addAttribute("employee", employee);
            return "/create";
        }
        employeeService.insertEmployee(employee);
        return "redirect:/";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        employeeService.deleteEmployee(id);
        return "redirect:/";
    }
    @GetMapping("//edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("employee", employeeService.getEmployeeById(id));
        return "/edit";
    }
    @PostMapping("/update")
    public String update(Employee employee) {
        employeeService.updateEmployee(employee);
        return "redirect:/";
    }
    @GetMapping("/view/{id}")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("employee", employeeService.getEmployeeById(id));
        return "/view";
    }
}

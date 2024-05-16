package ra.btss17.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ra.btss17.entity.Employee;

import java.util.List;
@Repository
public class EmployeeDaoImpl implements IEmployeeDao{
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<Employee> getEmployee() {
        Session session = sessionFactory.openSession();
        try{
            List list = session.createQuery("from Employee").list();
            return list;
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            session.close();
        }
        return null;
    }

    @Override
    public Employee getEmployeeById(Integer empId) {
        Session session = sessionFactory.openSession();
        try{
            Employee employee = session.get(Employee.class, empId);
            return employee;
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            session.close();
        }
        return null;
    }

    @Override
    public boolean insertEmployee(Employee emp) {
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            session.save(emp);
            session.getTransaction().commit();
            return true;
        }catch (Exception ex){
            ex.printStackTrace();
            session.getTransaction().rollback();
        }finally {
            session.close();
        }
        return false;
    }

    @Override
    public boolean updateEmployee(Employee emp) {
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            session.update(emp);
            session.getTransaction().commit(); //Lưu dữ liệu vào ổ đĩa vật lý
            return true;
        }catch (Exception ex){
            ex.printStackTrace();
            session.getTransaction().rollback(); //Hồi phục lai dữ liệu trước khi bị lỗi
        }finally {
            session.close();
        }
        return false;
    }

    @Override
    public boolean deleteEmployee(Integer empId) {
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            session.delete(getEmployeeById(empId)); //Xóa theo object
//            int i = session.createQuery("delete from Student where stuId = :stuId").setParameter("stuId", stuId).executeUpdate();
            session.getTransaction().commit(); //Lưu dữ liệu vào ổ đĩa vật lý
            return true;
        }catch (Exception ex){
            ex.printStackTrace();
            session.getTransaction().rollback(); //Hồi phục lai dữ liệu trước khi bị lỗi
        }finally {
            session.close();
        }
        return false;
    }

    @Override
    public List<Employee> getEmployeeByName(String name) {
        Session session = sessionFactory.openSession();
        try{
            if(name==null || name.length()==0)
                name = "%";
            else
                name = "%"+name+"%";
            List list = session.createQuery("from Employee where empName like :empName")
                    .setParameter("empName",name)
                    .list();
            return list;
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            session.close();
        }
        return null;
    }
}

package com.dao;

import com.bean.Employee;
import com.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class EmployeeDaoImplementation {
    public int addEmployee(Employee employee) {
        Transaction transaction = null;
        int i = 0;

        try (Session session = HibernateUtil.getFactory().openSession()) {
            transaction = session.beginTransaction();

            i = (int) session.save(employee);

            transaction.commit();


        } catch (Exception e) {

        }


        return i;

    }

    public void updateEmployee(Employee employee) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFactory().openSession()) {
            transaction = session.beginTransaction();

            session.saveOrUpdate(employee);

            transaction.commit();

        } catch (Exception e) {

        }
    }

    public void deleteEmployee(int id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFactory().openSession()) {

            transaction = session.beginTransaction();
            Employee employee = session.get(Employee.class, id);
            session.delete(employee);
            transaction.commit();

        } catch (Exception e) {

        }

    }


    public List<Employee> getAllEmployees() {
        Transaction transaction = null;
        List<Employee> employeeList = null;

        try (Session session = HibernateUtil.getFactory().openSession()) {
            transaction = session.beginTransaction();
            employeeList = session.createQuery("from Employee").list();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return employeeList;
    }
}

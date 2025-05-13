package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {
	public static void main(String[]args) {
	
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("===== Test 1: Department findById =====");
		Department dep =  departmentDao.findById(2);
		System.out.println(dep);
		
		System.out.println("\n===== Test 2: Department findAll ======");
		departmentDao.findAll().stream().forEach(System.out::println);
		
		System.out.println("\n===== Test 3: Department Insert ======");
		Department newDepartment = new Department(null, "Human Resource");
		departmentDao.insert(newDepartment);
		System.out.println("Insert! New id = " + newDepartment.getId());
		
		System.out.println("\n===== Test 4: Department Update ======");
		dep = departmentDao.findById(6);
		dep.setName("Deposit");
		departmentDao.update(dep);
		System.out.println("Update completed!");

		System.out.println("\n===== Test 5: Department Delete ======");
        departmentDao.deleteById(8);
		System.out.println("Delete completed!");
	}
}

package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		
		System.out.println("===== TEST 1: Seller findById ======");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		
		System.out.println("\n===== TEST 2: Seller findByDepartment ======");
		Department department = new Department(2, null);
		sellerDao.findByDepartment(department).stream().forEach(System.out::println);;
		

		System.out.println("\n===== TEST 3: Seller findAll ======");
		sellerDao.findAll().stream().forEach(System.out::println);;
		
		
		System.out.println("\n===== TEST 4: Seller Insert ======");
		Seller newSeller = new Seller(null, "greg", "greg@outlook.com", new Date(), 4000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Insert! New id = " + newSeller.getId());
		
		
		System.out.println("\n===== TEST 5: Seller Update ======");
		seller = sellerDao.findById(1);
		seller.setName("Marta Waine");
		sellerDao.update(seller);
		System.out.println("Update completed!");
		
		System.out.println("\n===== TEST 6: Seller Delete ======");
		sellerDao.deleteById(10);
		System.out.println("Delete completed!");
		
	}

}

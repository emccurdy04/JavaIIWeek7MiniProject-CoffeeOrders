package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.ListCustomer;

public class ListCustomerHelper{
	
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("CoffeeShop");
	
	
	public void cleanUp(){
		emfactory.close();
	}
	
	public void deleteCustomer(ListCustomer toDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListCustomer> typedQuery = em.createQuery("select li from ListCustomer li where li.fname = :selectedFName and li.lname = :selectedLNameand li.phoneNumber = :selectedPhoneNumber", ListCustomer.class);
		typedQuery.setParameter("selectedFName", toDelete.getFName());
		typedQuery.setParameter("selectedLastName", toDelete.getLName());
		typedQuery.setParameter("selectedPhoneNumber", toDelete.getPhoneNumber());
		typedQuery.setMaxResults(1);
		ListCustomer result = typedQuery.getSingleResult();
		em.remove(result);
		
		em.getTransaction().commit();
		em.close();
		
	}
	

	
	public void insertCustomer(ListCustomer li){
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(li);
		em.getTransaction().commit();
		em.close();
	}
//Search for customer by First Name
	public List<ListCustomer> searchForItemByFName(String CustomerFName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListCustomer> typedQuery = em.createQuery("select li from ListCustomer li where li.fname = :selectedFName", ListCustomer.class);
		typedQuery.setParameter("selectedCustomer", CustomerFName);

		List<ListCustomer> foundCustomer = typedQuery.getResultList();
		em.close();
		return foundCustomer;
	}
//Search for customer by Last Name
	public List<ListCustomer> searchForItemByLName(String CustomerLName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListCustomer> typedQuery = em.createQuery("select li from ListCustomer li where li.Lname = :selectedLName", ListCustomer.class);
		typedQuery.setParameter("selectedCustomer", CustomerLName);

		List<ListCustomer> foundCustomer = typedQuery.getResultList();
		em.close();
		return foundCustomer;
	}
//Search for customer by Phone Number

	public List<ListCustomer> searchForCustomerByPhoneNumber(String CustomerPhoneNumber) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListCustomer> typedQuery = em.createQuery("select li from ListCustomer li where li.phoneNumber = :selectedPhoneNumber", ListCustomer.class);
		typedQuery.setParameter("selectedCustomer", CustomerPhoneNumber);

		List<ListCustomer> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
		
	}
//Search for customer by ID
	public ListCustomer searchForCustomerById(int id){
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		ListCustomer found = em.find(ListCustomer.class, id);
		em.close();
		return found;
	}
//Show all customers 
	public List<ListCustomer> showAllCustomers(){
		EntityManager em = emfactory.createEntityManager();
		TypedQuery<ListCustomer> typedQuery = em.createQuery("select li from ListCustomer li", ListCustomer.class);
		List<ListCustomer> allCustomers = typedQuery.getResultList();
		em.close();
		return allCustomers;
	}

//Update Customer
	public void updateCustomer(ListCustomer toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

}

package com.app;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.Session;

import com.app.model.UserDetailsComplexData;
import com.app.model.UserDetailsComplexDataEmbeddedOverride;
import com.app.model.UserDetailsComplexKey;
import com.app.model.UserDetailsCustomKey;
import com.app.model.UserDetailsSequenceBasedKey;
import com.app.model.UserDetailsSimpleKey;
import com.app.model.UserDetailsTableBasedKey;
import com.app.model.UserDetailsUUIDKey;
import com.app.model.UserDetailsWithList;
import com.app.model.UserDetailsWithMap;
import com.app.model.vo.Address;
import com.app.model.vo.SubscriberIdentifier;
import com.app.util.HibernateUtil;
import com.app.util.Utils;

public class ORMApplication {
	
	private Session session;
	
	public ORMApplication() {
		this.session = HibernateUtil.getSession();
	}
	
	public void insertSimpleKey() {
		session.beginTransaction();
		session.save(new UserDetailsSimpleKey("First User"));
		session.save(new UserDetailsSimpleKey("Second User"));
		session.getTransaction().commit();
	}
	
	public void insertUuidKey() {
		session.beginTransaction();
		session.save(new UserDetailsUUIDKey("First User"));
		session.save(new UserDetailsUUIDKey("Second User"));
		session.getTransaction().commit();
	}
	
	public void insertTableBasedKey() {
		session.beginTransaction();
		session.save(new UserDetailsTableBasedKey("First User"));
		session.save(new UserDetailsTableBasedKey("Second User"));
		session.getTransaction().commit();
	}
	
	public void insertSequenceBasedKey() {
		session.beginTransaction();
		session.save(new UserDetailsSequenceBasedKey("First User"));
		session.save(new UserDetailsSequenceBasedKey("Second User"));
		session.getTransaction().commit();
	}
	
	public void insertCustomKey() {
		session.beginTransaction();
		session.save(new UserDetailsCustomKey("First User"));
		session.save(new UserDetailsCustomKey("Second User"));
		session.getTransaction().commit();
	}
	
	public void insertComplexKey() {
		session.beginTransaction();
		session.save(new UserDetailsComplexKey(new SubscriberIdentifier("9903123499", "santanu.bh6@gmail.com"), "First User"));
		session.getTransaction().commit();
	}
	
	public void insertDataWithValueObject() {
		Address address = new Address("8/B Bhattacharjee Lane", "Serampore", "WB", "712201");
		UserDetailsComplexData data = new UserDetailsComplexData("Santanu", address, "9903123499", Utils.dob());
		session.beginTransaction();
		session.save(data);
		session.getTransaction().commit();
	}
	
	public void insertDataWithMultipleValueObject() {
		Address homeaddress = new Address("8/B Bhattacharjee Lane", "Serampore", "WB", "712201");
		Address offcaddress = new Address("DLF2, Rajarhat-Newtown", "Kolkata", "WB", "700156");
		UserDetailsComplexDataEmbeddedOverride data = new UserDetailsComplexDataEmbeddedOverride("Santanu", homeaddress, offcaddress, "9903123499", Utils.dob());
		session.beginTransaction();
		session.save(data);
		session.getTransaction().commit();
	}
	
	public void insertDataWithListObject() {
		Address homeaddress = new Address("8/B Bhattacharjee Lane", "Serampore", "WB", "712201");
		Address offcaddress = new Address("DLF2, Rajarhat-Newtown", "Kolkata", "WB", "700156");
		UserDetailsWithList data = new UserDetailsWithList("Santanu", new Address[] {homeaddress, offcaddress});
		session.beginTransaction();
		session.save(data);
		session.getTransaction().commit();
	}
	
	public void getDataWithListObject() {
		UserDetailsWithList data = session.get(UserDetailsWithList.class, 23);
		session.close();
		System.out.println("Now going to get Address"); // Lazy Fetch Type
		System.out.println("Data: "+data.getAddresses().size());
		// session.close();
	}
	
	public void insertDataWithMapObject() {
		Address homeaddress = new Address("8/B Bhattacharjee Lane", "Serampore", "WB", "712201");
		Map<String, Address> address = new HashMap<String, Address>();
		address.put("home", homeaddress);
		UserDetailsWithMap data = new UserDetailsWithMap("Santanu", address);
		session.beginTransaction();
		session.save(data);
		session.getTransaction().commit();
	}

}

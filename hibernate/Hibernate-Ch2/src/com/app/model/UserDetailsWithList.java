package com.app.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import com.app.model.vo.Address;

@Entity
@Table(name = "USER_DETAILS_LIST_OBJECT")
public class UserDetailsWithList {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;

	private String username;

	@ElementCollection(fetch = FetchType.LAZY)
	@JoinTable(name = "USER_ADDRESSES", joinColumns = @JoinColumn(name= "USER_ID"))
	@CollectionId(columns = { @Column(name= "ADDRESS_ID") }, generator = "increment-gen", type = @Type(type= "long"))
	@GenericGenerator(name = "increment-gen", strategy = "increment")
	private List<Address> addresses;

	public UserDetailsWithList(String username, Address[] addresses) {
		super();
		this.username = username;
		if (null != addresses && addresses.length > 0) {
			for (Address address : addresses) {
				this.addAddresses(address);
			}
		}
	}

	public UserDetailsWithList() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public void addAddresses(Address address) {
		if (null == addresses) {
			addresses = new ArrayList<Address>();
		}
		this.addresses.add(address);
	}

	@Override
	public String toString() {
		return "UserDetailsWithList [userId=" + userId + ", username=" + username + ", addresses=" + addresses + "]";
	}

}

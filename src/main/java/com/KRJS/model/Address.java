package com.KRJS.model;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import org.springframework.stereotype.Component;

/*@Entity
@Table(name = "member_address")*/
@Embeddable
public class Address {
	/*@Id
	@GeneratedValue(generator = "gen")
	@GenericGenerator(name = "gen", strategy = "foreign", parameters = {
			@Parameter(name = "property", value = "member") })
	@Column(name = "app_no")
	int appNo;*/

	@Column(name = "address")
	String address;


	@Column(name = "taluk/city")
	String taluk;

	@Column(name = "district")
	String district;

	@Column(name = "village/Area")
	String city;

	@Column(name = "state")
	String state;

	@Column(name = "pincode")
	int pincode;

	/*@OneToOne
	@PrimaryKeyJoinColumn
	Member member = new Member();
*/
	/*public int getAppNo() {
		return appNo;
	}

	public void setAppNo(int appNo) {
		this.appNo = appNo;
	}*/

	
	

	public String getTaluk() {
		return taluk;
	}

	public void setTaluk(String taluk) {
		this.taluk = taluk;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Address [address=" + address + ", taluk=" + taluk + ", district=" + district + ", city=" + city
				+ ", state=" + state + ", pincode=" + pincode + "]";
	}

	

	
}

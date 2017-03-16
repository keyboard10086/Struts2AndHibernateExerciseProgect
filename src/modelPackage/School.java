package modelPackage;

import javax.persistence.*;

@Entity
@Table(name="schools")
@SequenceGenerator(name = "school",sequenceName="school_DB", allocationSize=1)
public class School {
	
	private int id;
	private String name;
	private String district;
	private String address;
	private String email;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="school")
	@Column(name="s_id")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name="s_name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name="s_district")
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	@Column(name="s_address")
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Column(name="s_email")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}

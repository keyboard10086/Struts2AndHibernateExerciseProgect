package modelPackage;

import javax.persistence.*;

@Entity
@Table(name="administrator")
@SequenceGenerator(name="admin",sequenceName="admin_DB",allocationSize=1)
public class Administrator {
	
	private int id;
	private String name;
	private String password;
	private String email;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="admin")
	@Column(name="ad_id")
	public int getid() {
		return id;
	}
	public void setid(int id) {
		this.id = id;
	}
	@Column(name="ad_name")
	public String getname() {
		return name;
	}
	public void setname(String name) {
		this.name = name;
	}
	@Column(name="ad_password")
	public String getpassword() {
		return password;
	}
	public void setpassword(String password) {
		this.password = password;
	}
	@Column(name="ad_email")
	public String getemail() {
		return email;
	}
	public void setemail(String email) {
		this.email = email;
	}
}

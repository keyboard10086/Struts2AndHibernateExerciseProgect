package actionPackage;

import org.apache.struts2.json.annotations.JSON;
import org.hibernate.Session;
import com.opensymphony.xwork2.ActionSupport;

import modelPackage.School;

public class SchoolAction extends ActionSupport {
	public String name;
	public String district;
	public String address;
	public String email;
	private School school;
	
	@JSON(serialize=true)
	public School getSchool() {
		return school;
	}
	public void setSchool(School school) {
		this.school = school;
	}

	HibernateGetConfiguration HGC = new HibernateGetConfiguration();
	Session session;
	
	public String Add(){
		school = new School();
		school.setName(name);
		school.setDistrict(district);
		school.setAddress(address);
		school.setEmail(email);
		
		try{
			HGC.setUp();
			session = HGC.getSessionFactory().openSession();
			session.beginTransaction();
			session.save(school);
			session.getTransaction().commit();
		}catch(Exception e){
			session.close();
			e.printStackTrace();
			return "fail";
		}finally{
			session.close();
		}
		return "success";
	}
	
	public String LoadInfo(){
		
		return "success";
	}
}

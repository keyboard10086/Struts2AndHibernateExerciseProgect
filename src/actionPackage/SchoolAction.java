package actionPackage;

import java.util.ArrayList;
import java.util.List;

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
	private List<School> schools = new ArrayList<School>();
	
	@JSON(serialize=true)
	public List<School> getSchools() {
		return schools;
	}
	@JSON(serialize=true)
	public School getSchool() {
		return school;
	}
	public void setSchool(School school) {
		this.school = school;
	}

	Session session;
	
	@SuppressWarnings("unchecked")
	public String Add(){
		school = new School();
		school.setName(name);
		school.setDistrict(district);
		school.setAddress(address);
		school.setEmail(email);
		
		try{
			session = HibernateGetConfiguration.getSessionFactory().openSession();
			session.beginTransaction();
			session.save(school);
			schools = (List<School>)session.createQuery("select s from School s").list();
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
}

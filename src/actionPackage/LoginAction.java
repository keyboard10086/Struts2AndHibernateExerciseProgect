package actionPackage;

import java.util.List;

import org.hibernate.Session;

import com.opensymphony.xwork2.ActionSupport;

import modelPackage.Administrator;

public class LoginAction extends ActionSupport {
	
	public Administrator ad;
	public String username;
	public String password;
	public String email;
	HibernateGetConfiguration HGC = new HibernateGetConfiguration();
	Session session;
	
	public String excute() throws Exception{
		return this.excute();
	}
	
	public String Check() throws Exception{
		if(checkExsit()){
			return "success";
		}else{
			return "fail";
		}
	}
	
	public String Add()throws Exception{
		HGC.setUp();
		session = HGC.getSessionFactory().openSession();
		session.beginTransaction();
		Administrator ad = new Administrator();
		ad.setname(username);
		ad.setpassword(password);
		ad.setemail(email);
		session.save(ad);
		session.getTransaction().commit();
		session.close();
		return "success";
	}
	
	public boolean checkExsit() throws Exception{
		
		HGC.setUp();
		session = HGC.getSessionFactory().openSession();
		session.beginTransaction();
		List<Object> result = session.createQuery("select password from Administrator where name = '" + username+"'").list();
		session.close();
		if(result.size()!=0){
			for(Object o : result){
				System.out.println(o.toString());
			}
			return true;
		}else{
			return false;
		}
	}
	
}

package Model;

public class employee {

	private int id;
	private String uname;
	private String pass;
	private String email;
	private String phone;
	
	
	
	public employee(int id, String uname, String pass, String email, String phone) {
		super();
		this.id = id;
		this.uname = uname;
		this.pass = pass;
		this.email = email;
		this.phone = phone;
	}

	public employee(int id, String uname, String email, String phone) {
		super();
		this.id = id;
		this.uname = uname;
		this.email = email;
		this.phone = phone;
	}




	public employee(String uname, String pass, String email, String phone) {
		super();
		this.uname = uname;
		this.pass = pass;
		this.email = email;
		this.phone = phone;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getUname() {
		return uname;
	}



	public void setUname(String uname) {
		this.uname = uname;
	}



	public String getPass() {
		return pass;
	}



	public void setPass(String pass) {
		this.pass = pass;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	
}

package hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="loginUsers")
public class User {
	@GeneratedValue(strategy=GenerationType.IDENTITY )
	@Id
	private int id;
	private String FirstName;
	private String LastName;
	private String Password;
	private String email;
	User(){
	}
	public User(String fname,String lname ,String password,String email) {
		this.FirstName=fname;
		this.LastName=lname;
		this.Password=password;
		this.email=email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}

	}


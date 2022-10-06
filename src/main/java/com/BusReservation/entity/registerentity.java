package com.busreservation.entity;

import org.springframework.data.annotation.Id;


import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
//import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Email;
//import javax.validation.constraints.Size;
//import javax.validation.constraints.Max;
//import javax.validation.constraints.Min;
@Document(collection = "Users")

public class registerentity {
	 @Id
	    private long id;

	  @Indexed(unique = true)
	  	@NotNull(message = "first Name is cumpolsury")
	  	private String firstName;
	  @NotNull(message = "last Name is cumpolsury")
	  	private String lastName;
	  @NotNull(message = "emailid is cumpolsury")
	  @Email 
	  private String email;
	  @NotNull(message = "password is cumpolsury")
	  @Indexed(unique = true)
	  	private String password;
	  @NotNull(message = "confirmpassword is cumpolsury")
	  @Indexed(unique = true)
	  	private String confirmpassword;
	  @NotNull(message = "contactnumber is cumpolsury")
	  private String contactnumber;
	  	public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public String getConfirmpassword() {
			return confirmpassword;
		}
		public void setConfirmpassword(String confirmpassword) {
			this.confirmpassword = confirmpassword;
		}
		public String getContactnumber() {
			return contactnumber;
		}
		public void setContactnumber(String contactnumber) {
			this.contactnumber = contactnumber;
		}
		
	    public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
		
}

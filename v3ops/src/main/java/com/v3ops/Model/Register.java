package com.v3ops.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="register")
@Entity
public class Register implements Serializable {
	  private static final long serialVersionUID = 1L;
	  @Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	  @Column(name="id")
	  private int id;
	  @Column(name="username")
	  private String username;
	  @Column(name="password")
	  private String password;
	  
	  public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	protected Register() {
		}
	 
		public Register(String username, String password) {
			this.username = username;
			this.password = password;
		}
		@Override
	    public String toString() {
	        return "Employee [id=" + id + ", username=" + username
	                + ", username=" + username + ", password=" + password + "]";
	    }
	
}
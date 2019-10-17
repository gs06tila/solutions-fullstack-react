package se.experis.restaurantdb.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class User {
	@Id //Define primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Define automatically generated ID
	@Column(nullable = false, updatable = false)
	private long userId;

	@Column(length=128, nullable = false, updatable = false)
	private String user;

	@Column(length = 128)
	private String email;

	@Column(nullable = false)
	private String password;

	@Column(length = 50, nullable = false)
	private String role;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(updatable = false)
	@org.hibernate.annotations.CreationTimestamp
	private Date createdAt;

	@org.hibernate.annotations.UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedAt;

	@Column(length = 1)
	private int active;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Review> reviews;


	public User() {}

	public User(String user, String password, String email, String role, int active) {
		super();
		userId=0;
		this.user = user;
		this.email = email;
		this.password = password;
		this.role = role;
		this.active = active;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	//Getters and setters



	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

}

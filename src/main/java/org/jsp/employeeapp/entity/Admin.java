package org.jsp.employeeapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Entity
@Data
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int adminId;

	@Column(unique = true, nullable = false)
	private String username;

	@Column(unique = true, nullable = false)
	@Pattern(regexp = ".*@gmail.com")
	private String email;

	@Column(nullable = false)
	private String password;

}

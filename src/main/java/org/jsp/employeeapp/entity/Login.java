package org.jsp.employeeapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Entity
@Data
public class Login {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long loginId;

	@Column(nullable = false, unique = true)
	private String username;

	@Column(nullable = false, unique = true)
	@Pattern(regexp = ".*@gmail.com")
	private String email;

	@Column(nullable = false)
	private String password;
	
	@OneToOne
	private Employee employee;
}

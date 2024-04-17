package org.jsp.employeeapp.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int empId;

	private String name;
	private String gender;
	private LocalDate dob;

	@Column(nullable = false, unique = true)
	@Pattern(regexp = ".*@gmail.com")
	private String email;

	private long phone;

	private Role role;

	private LocalDateTime doj;

	@Lob
	@Column(name = "imagedata", length = 1000)
	private byte[] imageData;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<EmployeeLeave> employeeLeaves;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Project> projects;
	
	@OneToOne
	private Account account;

//	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	@JoinTable(name = "employee_project", joinColumns = @JoinColumn(name = "employee_id"), inverseJoinColumns = @JoinColumn(name = "project_id"))
//	private List<Project> projects;

}

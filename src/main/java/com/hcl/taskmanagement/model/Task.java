package com.hcl.taskmanagement.model;


import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String taskname;
	private Date startdate;
	private Date enddate;
	private String description;
	private String severity;
	@ManyToOne
	private User user;

}

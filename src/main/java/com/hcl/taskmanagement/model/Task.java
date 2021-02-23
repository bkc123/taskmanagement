package com.hcl.taskmanagement.model;



import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Entity
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String username;
    private String description;
    private Date startDate;
    private Date endDate;

    public Task(String username, String desc, Date startDate, Date endDate, boolean status) {
        super();
        this.username= username;
        this.description= desc;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}

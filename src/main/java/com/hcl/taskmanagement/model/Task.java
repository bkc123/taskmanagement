package com.hcl.taskmanagement.model;



import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Entity
@Table(name = "my-task")
public class Task {

    private int id;
    private String username;
    private String description;
    private Date startDate;
    private Date endDate;

}

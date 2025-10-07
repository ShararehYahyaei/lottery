package org.example.loan.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.loan.entity.baseEntity.BaseEntity;

import java.util.Date;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Fund extends BaseEntity {

    private Long LoanAmount;
    private Date startDate;
    private Date endDate;
    private int durationMonths;
    private String name;
    private int numberOfParticipants;
    @ManyToOne
    private User createdBy;


}

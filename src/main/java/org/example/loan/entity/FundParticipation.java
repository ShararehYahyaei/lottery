package org.example.loan.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.loan.entity.baseEntity.BaseEntity;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FundParticipation  extends BaseEntity {

    @OneToOne
    private Fund fund;
    @OneToOne
    private User user;
    private boolean isApproved = true;
    private boolean isWinner = false;


}

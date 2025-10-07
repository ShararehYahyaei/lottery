package org.example.loan.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.loan.entity.baseEntity.BaseEntity;
import org.example.loan.entity.enums.Status;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rund extends BaseEntity {

    private String title;
    private LocalDate drawnDate;
    @Enumerated(EnumType.STRING)
    private Status status;
    @ManyToOne
    private Fund fund;
    @ManyToOne
    private User winner;
    @ManyToOne
    private User winnerAlternative;


}

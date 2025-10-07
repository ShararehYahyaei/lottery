package org.example.loan.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.loan.entity.baseEntity.BaseEntity;

import java.util.List;

@Entity
@Table(name = "participant")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Participant  extends BaseEntity {

    @OneToMany
    private List<Fund> funds;
    @OneToOne
    private User user;
}

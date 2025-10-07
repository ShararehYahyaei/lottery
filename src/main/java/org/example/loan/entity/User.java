package org.example.loan.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.loan.entity.baseEntity.BaseEntity;
import org.example.loan.entity.enums.Role;

import java.time.LocalDate;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity {

    private String fullName;
    private String email;
    private LocalDate registeredAt;
    private boolean isActive = true;
    @Enumerated(EnumType.STRING)
    private Role role;
    private String password;
    private String phoneNumber;
    private String userName;
    private String creditCardNumber;


}

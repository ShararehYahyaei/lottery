package org.example.loan.entity;

import jakarta.persistence.*;


import java.time.LocalDate;

@Entity
public class LotteryRound {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private LocalDate drawnDate;
    private Integer numberOfWinner;
    @Enumerated(EnumType.STRING)
    private Status status;

    public LotteryRound() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDrawnDate() {
        return drawnDate;
    }

    public void setDrawnDate(LocalDate drawnDate) {
        this.drawnDate = drawnDate;
    }

    public Integer getNumberOfWinner() {
        return numberOfWinner;
    }

    public void setNumberOfWinner(Integer numberOfWinner) {
        this.numberOfWinner = numberOfWinner;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}

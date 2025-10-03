package org.example.loan.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Winner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    private LotteryRound lotteryRound;
    private LocalDateTime winDate;

    public Winner() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LotteryRound getLotteryRound() {
        return lotteryRound;
    }

    public void setLotteryRound(LotteryRound lotteryRound) {
        this.lotteryRound = lotteryRound;
    }

    public LocalDateTime getWinDate() {
        return winDate;
    }

    public void setWinDate(LocalDateTime winDate) {
        this.winDate = winDate;
    }
}

package org.example.loan.service.lotteryService;

import org.example.loan.entity.Rund;

import java.util.List;

public interface LotteryRoundService {
    List<Rund> findAll();

    Rund creaetLotteryRound(Rund rundRound);
}

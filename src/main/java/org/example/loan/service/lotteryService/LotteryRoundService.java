package org.example.loan.service.lotteryService;

import org.example.loan.entity.LotteryRound;

import java.util.List;

public interface LotteryRoundService {
    List<LotteryRound> findAll();

    LotteryRound creaetLotteryRound(LotteryRound lotteryRound);
}

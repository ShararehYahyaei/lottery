package org.example.loan.service.lotteryService;

import org.example.loan.entity.Rund;
import org.example.loan.repository.lotteryRoundRepository.LotteryRoundRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LotteryRoundServiceImpl implements LotteryRoundService {
    private final LotteryRoundRepository lotteryRoundRepository;


    public LotteryRoundServiceImpl(LotteryRoundRepository lotteryRoundService) {
        this.lotteryRoundRepository = lotteryRoundService;
    }


    @Override
    public List<Rund> findAll() {
        return lotteryRoundRepository.findAll();
    }

    @Override
    public Rund creaetLotteryRound(Rund rundRound) {
        return lotteryRoundRepository.save(rundRound);
    }
}

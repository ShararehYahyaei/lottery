package org.example.loan.service.winnerService;

import org.example.loan.entity.LotteryRound;
import org.example.loan.entity.Status;
import org.example.loan.entity.User;
import org.example.loan.entity.Winner;
import org.example.loan.repository.lotteryRoundRepository.LotteryRoundRepository;
import org.example.loan.repository.winnerRepository.WinnerRepository;
import org.example.loan.service.userService.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class WinnerServiceImpl implements WinnerService {
    private final WinnerRepository winnerRepository;
    private final UserService userService;
    private final LotteryRoundRepository lotteryRoundService;

    public WinnerServiceImpl(WinnerRepository winnerRepository,
                             UserService userService,
                             LotteryRoundRepository lotteryRoundService) {
        this.winnerRepository = winnerRepository;
        this.userService = userService;
        this.lotteryRoundService = lotteryRoundService;
    }

    @Transactional
    @Override
    public List<Winner> drawnWinners(Long roundId) {
        LotteryRound round = lotteryRoundService.findById(roundId)
                .orElseThrow(() -> new RuntimeException("Round not found"));
        if (round.getStatus() == Status.drawn) {
            throw new IllegalStateException("Drawn winner already exists");
        }
        List<User> allUsers = userService.findAllUsers();
        Collections.shuffle(allUsers);

        int count = Math.min(round.getNumberOfWinner(), allUsers.size());
        List<User> selected = allUsers.subList(0, count);

        List<Winner> winners = new ArrayList<>();
        for (User u : selected) {
            Winner winner = new Winner();
            winner.setUser(u);
            winner.setLotteryRound(round);
            winner.setWinDate(LocalDateTime.now());
            winners.add(winnerRepository.save(winner));
        }

        round.setStatus(Status.drawn);
        lotteryRoundService.save(round);

        return winners;
    }

    @Override
    public List<Winner> getWinnersByRoundId(Long roundId) {
        return winnerRepository.findByLotteryRoundId(roundId);
    }

}



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
    public List<Winner> drawWinners(Long roundId) {
        LotteryRound round = lotteryRoundService.findById(roundId)
                .orElseThrow(() -> new RuntimeException("Round not found"));

        if (round.getStatus() == Status.drawn) {
            throw new IllegalStateException("Winners already drawn for this round");
        }

        List<User> allParticipants = userService.findAllUsers();
        if (allParticipants.isEmpty()) {
            throw new IllegalStateException("No participants available");
        }

        Collections.shuffle(allParticipants);
        User selected = allParticipants.get(0);

        Winner winner = new Winner();
        winner.setUser(selected);
        winner.setLotteryRound(round);
        winner.setWinDate(LocalDateTime.now());
        winnerRepository.save(winner);

        round.setStatus(Status.drawn);
        lotteryRoundService.save(round);

        return List.of(winner);
    }

    @Override
    public List<Winner> getWinnersByRoundId(Long roundId) {
        return winnerRepository.findByLotteryRoundId(roundId);
    }

}



package org.example.loan.service.winnerService;

import org.example.loan.entity.Winner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface WinnerService {


    @Transactional
    List<Winner> drawWinners(Long roundId);
    List<Winner> getWinnersByRoundId(Long roundId);
}

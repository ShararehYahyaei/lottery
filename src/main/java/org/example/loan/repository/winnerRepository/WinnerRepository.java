package org.example.loan.repository.winnerRepository;

import org.example.loan.entity.Winner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WinnerRepository extends JpaRepository<Winner, Long> {
    List<Winner> findByLotteryRoundId(Long lotteryRoundId);
}

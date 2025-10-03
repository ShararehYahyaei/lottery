package org.example.loan.repository.lotteryRoundRepository;

import org.example.loan.entity.LotteryRound;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LotteryRoundRepository extends JpaRepository<LotteryRound, Long> {
}

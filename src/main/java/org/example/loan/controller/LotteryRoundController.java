package org.example.loan.controller;


import org.example.loan.entity.LotteryRound;
import org.example.loan.service.lotteryService.LotteryRoundService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lotteryround")
public class LotteryRoundController {
    private final LotteryRoundService lotteryRoundService;

    public LotteryRoundController(LotteryRoundService lotteryRoundService) {
        this.lotteryRoundService = lotteryRoundService;
    }

    @PostMapping
    public ResponseEntity<LotteryRound> createLotteryRound(@RequestBody LotteryRound lotteryRound) {
        LotteryRound saved = lotteryRoundService.creaetLotteryRound(lotteryRound);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping("/lottery")
    public List<LotteryRound> getAllLotteryRound() {
        return lotteryRoundService.findAll();
    }
}

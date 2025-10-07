package org.example.loan.controller;


import org.example.loan.entity.Rund;
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
    public ResponseEntity<Rund> createLotteryRound(@RequestBody Rund rundRound) {
        Rund saved = lotteryRoundService.creaetLotteryRound(rundRound);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping("/lottery")
    public List<Rund> getAllLotteryRound() {
        return lotteryRoundService.findAll();
    }
}

package org.example.loan.controller;

import org.example.loan.entity.Winner;
import org.example.loan.service.winnerService.WinnerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/winner")
public class WinnerController {
    private WinnerService winnerService;

    public WinnerController(WinnerService winnerService) {
        this.winnerService = winnerService;
    }

    @PostMapping("/draw/{roundId}")
    public ResponseEntity<List<Winner>> draw(@PathVariable Long roundId) {
        List<Winner> winners = winnerService.drawWinners(roundId);
        return ResponseEntity.ok(winners);
    }

    @GetMapping("/round/{roundId}")
    public ResponseEntity<List<Winner>> getByRound(@PathVariable Long roundId) {
        List<Winner> winners = winnerService.getWinnersByRoundId(roundId);
        return winners.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(winners);
    }

}

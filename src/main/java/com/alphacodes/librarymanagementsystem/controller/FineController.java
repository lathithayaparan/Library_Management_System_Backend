package com.alphacodes.librarymanagementsystem.controller;

import com.alphacodes.librarymanagementsystem.DTO.FineDto;
import com.alphacodes.librarymanagementsystem.service.FineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/fine")
public class FineController {

    @Autowired
    private FineService fineService;

    @GetMapping("/calculate/{memberId}")
    public double calculateFine(@PathVariable String memberId) {
        return fineService.calculateFine(memberId);
    }

    @PostMapping("/settle/{memberId}")
    public String settleFine(@PathVariable String memberId) {
        return fineService.settleFine(memberId);
    }

    @GetMapping("/unpaid")
    public List<FineDto> getAllUnpaidFine() {
        return fineService.getAllUnpaidFine();
    }

    @GetMapping("/history/{memberId}")
    public List<FineDto> getFineHistoryByUser(@PathVariable String memberId) {
        return fineService.getFineHistoryByUser(memberId);
    }
}

package com.faos.controller;


import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.faos.dto.CustomerBookingReport;
import com.faos.service.ReportService;

@RestController
@RequestMapping("/reports")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/max-bookings")
    public ResponseEntity<List<CustomerBookingReport>> getCustomersWithMaxBookings(
            @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {

        List<CustomerBookingReport> report = reportService.getCustomersWithMaxBookings(startDate, endDate);
        return ResponseEntity.ok(report);
    }
}

package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Report;
import za.ac.cput.service.ReportService;

import java.util.List;

@RestController
@RequestMapping("/report")
public class ReportController {
    @Autowired
    private ReportService reportService;
@PostMapping("/create")
    public Report create(@RequestBody Report report) {
        return reportService.create(report);
    }
@PostMapping("/update")
    public Report update(@RequestBody Report report) {
        return reportService.update(report);
    }
@GetMapping("/read/{reportId}")
    public Report read(@PathVariable Long reportId) {
        return reportService.read(reportId);
    }
@GetMapping("/getall")
    public List<Report> getAll() {
        return reportService.getAll();
    }
}

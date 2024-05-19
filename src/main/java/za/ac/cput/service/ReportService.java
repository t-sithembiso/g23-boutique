package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Report;
import za.ac.cput.repository.ReportRepository;

import java.util.List;

@Service
public class ReportService implements IReportService{
    private ReportRepository repository;
    @Autowired
    ReportService(ReportRepository repository){
        this.repository = repository;
    }


    @Override
    public Report create(Report report) {
        return repository.save(report);
    }

    @Override
    public Report update(Report report) {
        return repository.save(report);
    }

    @Override
    public Report read(Long reportId) {

        return repository.findById(reportId).orElse(null);
    }
    @Override
    public List<Report> getAll() {
        return repository.findAll();
    }
}

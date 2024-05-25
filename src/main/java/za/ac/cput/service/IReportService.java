package za.ac.cput.service;

import za.ac.cput.domain.Report;

import java.util.List;

public interface IReportService extends IService<Report, Long>{
    List<Report> getAll();
}

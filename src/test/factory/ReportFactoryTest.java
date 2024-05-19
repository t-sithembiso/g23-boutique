package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Report;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ReportFactoryTest {

    @Test
    void buildReport() {
        Report report = ReportFactory.buildReport(1, "financial", LocalDate.now(), "Only spent R100");
        assertNotNull(report);
        System.out.println(report);
    }
    @Test
    void buildReportThatFail() {
        Report report = ReportFactory.buildReport(1, "financial", LocalDate.now(), "");
        assertNotNull(report);
        System.out.println(report);
    }
}
package za.ac.cput.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Report;
import za.ac.cput.factory.ReportFactory;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class ReportServiceTest {
    @Autowired
    private ReportService reportService;
    private static Report rep1;
    private static Report rep2;
    @BeforeAll
    static void setup() {
        rep1 = ReportFactory.buildReport(1,"Financial report", LocalDate.now(),"We have managed to make 110% profit in the last 35 days.");
        assertNotNull(rep1);
        System.out.println(rep1);
        rep2 = ReportFactory.buildReport(2, "Inventory report", LocalDate.now(),"The inventory has enough products for the following two weeks");
        assertNotNull(rep2);
        System.out.println(rep2);
    }

    @Test
    void a_create() {
        Report reportCreated1 = reportService.create(rep1);
        assertNotNull(reportCreated1);
        System.out.println(reportCreated1);
        Report reportCreated2 = reportService.create(rep2);
        assertNotNull(reportCreated2);
        System.out.println(reportCreated2);
    }

    @Test
    void b_update() {
        Report reportUpdate = new Report.Builder().copy(rep1).setReportType("Profit report").build();
        Report repUpdated = reportService.update(reportUpdate);
        assertNotNull(repUpdated);
        System.out.println(repUpdated);
        Report upDate = new Report.Builder().copy(rep2).setDateGenerated(LocalDate.now()).build();
        Report newDate = reportService.update(upDate);
        assertNotNull(newDate);
        System.out.println(newDate);
    }

    @Test
    void c_read() {
        Report read = reportService.read(rep1.getReportId());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    void d_getAll() {
        System.out.println(reportService.getAll());

    }
}
package za.ac.cput.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Report;
import za.ac.cput.factory.ReportFactory;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.MethodName.class)
class ReportControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private final String Base_Url = "http://localhost:8080/boutique/report/";
    private static Report report;
    private static Report report2;
    @BeforeEach
    void setUp() {
        report = ReportFactory.buildReport(4L, "Monthly inventory cost", LocalDate.now(),"January spent R3200 for inventory, February spent R1350 ");
        report2 = ReportFactory.buildReport(5L, "Number of guest in a week", LocalDate.now(),"We had increase of 15% guest compared to last week");
    }

    @Test
    void a_create() {
        String url = Base_Url+"create";
        ResponseEntity<Report> postResponse = restTemplate.postForEntity(url, report, Report.class);
        assertNotNull(postResponse);
        Report savedReport = postResponse.getBody();
        assertNotNull(savedReport);
        System.out.println(savedReport);
        ResponseEntity<Report> reportResponse = restTemplate.postForEntity(url,report2,Report.class);
        assertNotNull(reportResponse);
        assertNotNull(reportResponse.getBody());
        System.out.println(reportResponse.getBody());

    }

    @Test
    void b_update() {
        String url = Base_Url+"update";
        Report rep = new Report.Builder().copy(report).setReportType("Inventory Cost").build();
        ResponseEntity<Report> updateResponse = restTemplate.postForEntity(url,rep,Report.class);
        assertNotNull(updateResponse);
        assertNotNull(updateResponse.getBody());
        System.out.println(updateResponse.getBody());
    }

    @Test
    void c_read() {
        String url = Base_Url+"read/"+report.getReportId()  ;
        ResponseEntity<Report> read = restTemplate.getForEntity(url, Report.class);
        assertNotNull(read);
        assertNotNull(read.getBody());
        System.out.println(read.getBody());
    }

    @Test
    void d_getAll() {
        String url = Base_Url+"getall";
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, httpHeaders);
        ResponseEntity<String> responseAll = restTemplate.exchange(url, HttpMethod.GET,entity,String.class);
        System.out.println(responseAll.getBody());
    }
}
package za.ac.cput.factory;

import za.ac.cput.domain.Report;
import za.ac.cput.util.Helper;

import java.time.LocalDate;
import java.util.Date;

public class ReportFactory {
    public static Report buildReport(int reportId, String reportType, LocalDate date, String content ){
        if(reportId < 0
            || Helper.isNullorEmpty(reportType)
            || date == null
            || Helper.isNullorEmpty(content))
            return null;

        return new Report.Builder()
                .setReportId(reportId)
                .setReportType(reportType)
                .setDateGenerated(date)
                .setContent(content)
                .build();
    }
}

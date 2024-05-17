package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Report {
    @Id
    private long reportId;
    private String reportType;
    private LocalDate dateGenerated;
    private String content;

    protected Report(){

    }
    private Report(Builder builder){
        this.reportId = builder.reportId;
        this.reportType = builder.reportType;
        this.dateGenerated = builder.dateGenerated;
        this.content = builder.content;

    }

    public long getReportId() {
        return reportId;
    }

    public String getReportType() {
        return reportType;
    }

    public LocalDate getDateGenerated() {
        return dateGenerated;
    }

    public String getContent() {
        return content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Report report)) return false;
        return Objects.equals(getReportId(), report.getReportId()) && Objects.equals(getReportType(), report.getReportType()) && Objects.equals(getDateGenerated(), report.getDateGenerated()) && Objects.equals(getContent(), report.getContent());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getReportId(), getReportType(), getDateGenerated(), getContent());
    }

    @Override
    public String toString() {
        return "Report{" +
                "reportId='" + reportId + '\'' +
                ", reportType='" + reportType + '\'' +
                ", dateGenerated=" + dateGenerated +
                ", content='" + content + '\'' +
                '}';
    }

    public static class Builder{
            private long reportId;
            private String reportType;
            private LocalDate dateGenerated;
            private String content;

        public Builder setReportId(long reportId) {
            this.reportId = reportId;
            return this;
        }

        public Builder setReportType(String reportType) {
            this.reportType = reportType;
            return this;
        }

        public Builder setDateGenerated(LocalDate dateGenerated) {
            this.dateGenerated = dateGenerated;
            return this;
        }

        public Builder setContent(String content) {
            this.content = content;
            return this;
        }

        public  Report.Builder copy(Report report){
            this.reportId = report.reportId;
            this.reportType = report.reportType;
            this.dateGenerated = report.dateGenerated;
            this.content = report.content;
            return this;

        }
        public Report build(){return new Report(this);};
    }
}

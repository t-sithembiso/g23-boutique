package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Date;
import java.util.Objects;

@Entity
public class Housekeeping {
    @Id
    private Long taskId;
    private int roomNumber;
    private String taskType;
    private String staffAssigned;
    private String taskStatus;
    private Date timeStarted;
    private Date timeCompleted;
    private String roomCondition;


protected Housekeeping(){}


    public Housekeeping (Builder builder){
        this.taskId=builder.taskId;
        this.roomNumber=builder.roomNumber;
        this.taskType=builder.taskType;
        this.staffAssigned  =builder.staffAssigned;
        this.timeStarted=builder.timeStarted;
        this.timeCompleted=builder.timeCompleted;
        this.taskStatus= builder.taskStatus;
        this.roomCondition= builder.roomCondition;

    }

public Long getTaskId() {
        return taskId;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getTaskType() {
        return taskType;
    }

    public String getStaffAssigned() {
        return staffAssigned;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public Date getTimeStarted() {
        return timeStarted;
    }

    public Date getTimeCompleted() {
        return timeCompleted;
    }

    public String getRoomCondition() {
        return roomCondition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Housekeeping that)) return false;
        return taskId == that.taskId && roomNumber == that.roomNumber && Objects.equals(taskType, that.taskType) && Objects.equals(staffAssigned, that.staffAssigned) && Objects.equals(taskStatus, that.taskStatus) && Objects.equals(timeStarted, that.timeStarted) && Objects.equals(timeCompleted, that.timeCompleted) && Objects.equals(roomCondition, that.roomCondition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(taskId, roomNumber, taskType, staffAssigned, taskStatus, timeStarted, timeCompleted, roomCondition);
    }

    @Override
    public String toString() {
        return "Housekeeping{" +
                "taskId=" + taskId +
                ", roomNumber=" + roomNumber +
                ", taskType='" + taskType + '\'' +
                ", staffAssigned='" + staffAssigned + '\'' +
                ", taskStatus='" + taskStatus + '\'' +
                ", timeStarted=" + timeStarted +
                ", timeCompleted=" + timeCompleted +
                ", roomCondition='" + roomCondition + '\'' +
                '}';
    }

    public static class Builder{

        private Long taskId;
        private int roomNumber;
        private String taskType;
        private String staffAssigned;
        private String taskStatus;
        private Date timeStarted;
        private Date timeCompleted;
        private String roomCondition;

        public Builder setTaskId(Long taskId) {
            this.taskId = taskId;
            return this;
        }

        public Builder setRoomNumber(int roomNumber) {
            this.roomNumber = roomNumber;
            return this;
        }

        public Builder setTaskType(String taskType) {
            this.taskType = taskType;
            return this;
        }

        public Builder setStaffAssigned(String staffAssigned) {
            this.staffAssigned = staffAssigned;
            return this;
        }

        public Builder setTaskStatus(String taskStatus) {
            this.taskStatus = taskStatus;
            return this;
        }

        public Builder setTimeStarted(Date timeStarted) {
            this.timeStarted = timeStarted;
            return this;
        }

        public Builder setTimeCompleted(Date timeCompleted) {
            this.timeCompleted = timeCompleted;
            return this;
        }

        public Builder setRoomCondition(String roomCondition) {
            this.roomCondition = roomCondition;
            return this;
        }
        public Builder copy(Housekeeping housekeeping){
          this.taskId=housekeeping.taskId;
          this.roomNumber=housekeeping.roomNumber;
          this.taskType=housekeeping.taskType;
          this.staffAssigned  =housekeeping.staffAssigned;
          this.timeStarted=housekeeping.timeStarted;
          this.timeCompleted=housekeeping.timeCompleted;
          this.taskStatus= housekeeping.taskStatus;
          this.roomCondition= housekeeping.roomCondition;
            return this;
        }
        public Housekeeping build(){

            return new Housekeeping(this);
        }

    }


}


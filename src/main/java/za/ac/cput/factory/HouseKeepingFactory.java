package za.ac.cput.factory;

import za.ac.cput.domain.Housekeeping;
import za.ac.cput.util.Helper;

import java.time.LocalTime;
import java.util.Date;

public class HouseKeepingFactory {

    public static Housekeeping buildHouseKeeping(Long taskId,
     int roomNumber, String taskType, String staffAssigned,
     String taskStatus, LocalTime timeStarted, LocalTime timeCompleted, String roomCondition
    ){

      if(Helper.isNullorEmpty(String.valueOf(taskId)) ||(Helper.isNullorEmpty(String.valueOf(roomNumber))
              ||(Helper.isNullorEmpty(taskType)||(Helper.isNullorEmpty(staffAssigned)||(Helper.isNullorEmpty(String.valueOf(timeStarted))
              ||(Helper.isNullorEmpty(String.valueOf(timeCompleted))||(Helper.isNullorEmpty(taskStatus)||(Helper.isNullorEmpty(roomCondition)))))))))
              return null;
return new Housekeeping.Builder().setTaskId(taskId)
        .setRoomNumber(roomNumber)
        .setTaskType(taskType)
        .setStaffAssigned(staffAssigned)
        .setTaskStatus(taskStatus)
        .setTimeStarted(timeStarted)
        .setTimeCompleted(timeCompleted)
        .setRoomCondition(roomCondition)
        .build();






    }

}

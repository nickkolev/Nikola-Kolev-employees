package SirmaSolutionsTask;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Entry {

    public final static String[] FORMATTERS= {"yyyy-MM-d","yyyy/MM/d","yyyy;MM;d","yyyy:MM:d",
            "d-MM-yyyy","d/MM/yyyy","d;MM;yyyy","d:MM:yyyy",
            "MMM d yy", "MMM-d-yy","MMM;d;yy","MMM:d:yy",
            "yyyy MMMM dd","yyyy-MMMM-dd","yyyy:MMMM:dd","yyyy/MMMM/dd",};
    public final static String UP_UNTIL_NOW = "NULL";
    private String employeeID;
    private String projectID;
    private LocalDate startDate;
    private LocalDate endDate;

    public Entry(String employeeID, String projectID, String startDate, String endDate) throws Exception {
        this.employeeID = employeeID.trim();
        this.projectID = projectID.trim();
        this.startDate = date(startDate);
        if(!endDate.trim().equalsIgnoreCase(UP_UNTIL_NOW) ) {
            this.endDate = date(endDate);
        }
        else{
            this.endDate = LocalDate.now();
        }
    }

    private static LocalDate date ( String date ) throws Exception {
        for (int i = 0; i < FORMATTERS.length; i++) {
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern(FORMATTERS[i]);
                LocalDate currentDate = LocalDate.parse(date.trim(), formatter);
                return currentDate;
            }catch (DateTimeParseException e){
                continue;
            }
        }
        throw new Exception("unknown date format");
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public String getProjectID() {
        return projectID;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }
}
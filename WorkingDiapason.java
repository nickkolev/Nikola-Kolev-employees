package SirmaSolutionsTask;

import java.time.LocalDate;

public class WorkingDiapason {

    protected LocalDate startDate;
    protected LocalDate endDate;

    public WorkingDiapason (LocalDate startDate, LocalDate endDate){
        this.startDate = startDate;
        this.endDate = endDate;
    }
}

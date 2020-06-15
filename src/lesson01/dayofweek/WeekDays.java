package lesson01.dayofweek;

public enum WeekDays {
    Monday(8), Tuesday(8), Wednesday(8), Thursday(8), Friday(8), Saturday(0), Sunday(0);

    private int workHours;

    WeekDays(int p) {
        workHours = p;
    }

    public int getWorkHours() {
        return workHours;
    }
}


package lesson01.dayofweek;

import static lesson01.dayofweek.WeekDays.*;

public class Main {

    private static int numOfWorkingHours;

    public static void main(String[] args) {
        WeekDays dw;
        WeekDays startDay = Monday;

        System.out.println(startDay);
        System.out.println();

        workHoursCounter1(startDay);

        workHoursCounter2(startDay);

    }

    public static void workHoursCounter1(WeekDays startDay) {

        switch (startDay) {
            case Monday:
                int workHoursTillEndOfWeek = (Monday.getWorkHours() + Tuesday.getWorkHours() +
                        Wednesday.getWorkHours() + Thursday.getWorkHours() + Friday.getWorkHours());
                System.out.printf("До конца недели осталось %d часов", workHoursTillEndOfWeek);
                break;
            case Tuesday:
                workHoursTillEndOfWeek = (Tuesday.getWorkHours() + Wednesday.getWorkHours()
                        + Thursday.getWorkHours() + Friday.getWorkHours());
                System.out.printf("До конца недели осталось %d часов", workHoursTillEndOfWeek);
                break;
            case Wednesday:
                workHoursTillEndOfWeek = (Wednesday.getWorkHours() + Thursday.getWorkHours()
                        + Friday.getWorkHours());
                System.out.printf("До конца недели осталось %d часов", workHoursTillEndOfWeek);
                break;
            case Thursday:
                workHoursTillEndOfWeek = (Thursday.getWorkHours() + Friday.getWorkHours());
                System.out.printf("До конца недели осталось %d часов", workHoursTillEndOfWeek);
                break;
            case Friday:
                workHoursTillEndOfWeek = Friday.getWorkHours();
                System.out.printf("До конца недели осталось %d часов", workHoursTillEndOfWeek);
                break;
            case Saturday:
            case Sunday:
                System.out.println("Сегодня выходной!");
                break;
        }
        System.out.println();
    }

    public static void workHoursCounter2(WeekDays startDay) {

        WeekDays allDaysArray[] = WeekDays.values();
        for (int i = startDay.ordinal(); i < allDaysArray.length ; i++) {
            numOfWorkingHours += allDaysArray[i].getWorkHours();
        }

        if ((startDay == Saturday|| startDay == Sunday)) {
            System.out.println("Сегодня выходной!");
        } else {
        System.out.printf("До конца недели осталось %d часов", numOfWorkingHours);

        }
    }
}

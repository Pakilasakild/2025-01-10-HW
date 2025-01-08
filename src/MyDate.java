public class MyDate {
    private int year;
    private int month;
    private int day;
    String[] months = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
    String[] days = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
    int[] daysInMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
    int[] yearVal = {6, 4, 2, 0};
    int[] monthVal = {0, 3, 3, 6, 1, 4, 6, 2, 5, 0, 3, 5};

    public boolean isLeapYear(int year) {
        if (year % 4 == 0 && year % 100 != 0) {
            monthVal[0] = 6;
            monthVal[1] = 2;
            daysInMonth[1] = 29;
            return true;
        } else {
            return false;
        }
    }

    public boolean isValidDate(int year, int month, int day) {
        if ((year >= 1 && year <= 9999) && (month >= 1 && month <= 12) && (day <= daysInMonth[month])) {
            return true;
        } else {
            return false;
        }
    }
    public int getDayOfWeek(int year, int month, int day){
        isLeapYear(year);
        return (yearVal[year % 400 / 100] + year % 100 + ((year % 100) / 4) + monthVal[month-1] + day) % 7;
    }

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }
    public void setDate(int year, int month, int day){
        if(isValidDate(year, month, day)){
            this.year = year;
            this.month = month;
            this.day = day;
            System.out.println("Date is valid.");
        }
        else{
            System.out.println("Date is not valid");
        }
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public void setYear(int year){
        if((year >= 1 && year <= 9999)){
            this.year = year;
            System.out.println("Year is valid.");
        }
        else{
            System.out.println("Year is not valid");
        }
    }

    public void setMonth(int month){
        if((month >= 1 && month <= 12)){
            this.month = month;
            System.out.println("Month is valid.");
        }
        else{
            System.out.println("Month is not valid");
        }
    }

    public void setDay(int day){
        if((day >= 1 && day <= daysInMonth[month-1])){
            this.day = day;
            System.out.println("Day is valid.");
        }
        else{
            System.out.println("Day is not valid");
        }
    }

    @Override
    public String toString() {
        return days[getDayOfWeek(year, month, day)] + " " + day + " " + months[month - 1] + " " + year;
    }
    public MyDate nextDay(){
        isLeapYear(year);
        if (day < daysInMonth[month-1]) {
            day++;
        } else {
            day = 1;
            nextMonth();
        }
        return this;
    }
    public MyDate nextMonth() {
        if (month < 12) {
            month++;
        } else {
            month = 1;
            nextYear();
        }
        int maxDays = daysInMonth[month-1];
        if (day > maxDays) {
            day = maxDays;
        }
        return this;
    }

    public MyDate nextYear() {
        if (year < 9999) {
            year++;
        } else {
            System.out.println("Year too big");
        }
        if (month == 2 && day == 29 && !isLeapYear(year)) {
            day = 28;
        }
        return this;
    }
    public MyDate previousDay() {
        if (day > 1) {
            day--;
        } else {
            previousMonth();
            day = daysInMonth[month-1];
        }
        return this;
    }

    public MyDate previousMonth() {
        if (month > 1) {
            month--;
        } else {
            month = 12;
            previousYear();
        }
        int maxDays = daysInMonth[month-1];
        if (day > maxDays) {
            day = maxDays;
        }
        return this;
    }

    public MyDate previousYear() {
        if (year > 1) {
            year--;
        } else {
            System.out.println("Year too big");
        }
        if (month == 2 && day == 29 && !isLeapYear(year)) {
            day = 28;
        }
        return this;
    }
    
}

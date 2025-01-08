public class App {
    public static void main(String[] args) {

        
          MyDate d1 = new MyDate(2012, 2, 28);
          System.out.println(d1); // Tuesday 28 Feb 2012
          System.out.println(d1.nextDay()); // Wednesday 29 Feb 2012
          System.out.println(d1.nextDay()); // Thursday 1 Mar 2012
          System.out.println(d1.nextMonth()); // Sunday 1 Apr 2012
          System.out.println(d1.nextYear()); // Monday 1 Apr 2013
          
          MyDate d2 = new MyDate(2012, 1, 2);
          System.out.println(d2); // Monday 2 Jan 2012
          System.out.println(d2.previousDay()); // Sunday 1 Jan 2012
          System.out.println(d2.previousDay()); // Saturday 31 Dec 2011
          System.out.println(d2.previousMonth()); // Wednesday 30 Nov 2011
          System.out.println(d2.previousYear()); // Tuesday 30 Nov 2010
          
          MyDate d3 = new MyDate(2012, 2, 29);
          System.out.println(d3.previousYear()); // Monday 28 Feb 2011

          System.out.println("\n\n");
          System.out.println("NEXT PART BELOW:\n\n");
         
        MyDate d4 = new MyDate(2011, 12, 28);
        while (3 < 4) {
            if (d4.getDay() == 2 && d4.getMonth() == 3 && d4.getYear() == 2012) {
                break;
            } else {
                System.out.println(d4);
                d4.nextDay();
            }
        }
    }
}

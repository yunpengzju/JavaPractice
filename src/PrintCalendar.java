import java.util.Scanner;

public class PrintCalendar {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("please input the year:");
		int year = input.nextInt();
		System.out.print("please input the month:");
		int month = input.nextInt();
		printCal(year,month);
	}
	
	public static void printCal(int year, int month){
		printTitle(year,month);
		printBody(year,month);
	}
	
	public static void printTitle(int year,int month){
		System.out.println("         "+getMonthName(month)+" "+year);
		System.out.println("----------------------------");
		System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
	}
	
	public static void printBody(int year,int month){
		for(int i = 0; i < getStartDay(year,month); i++){
			System.out.print("    ");
		}
		for(int i = 1; i <= getDayNumber(year,month); i++){
			System.out.printf("%4d", i);
			if((i+getStartDay(year,month))%7==0){
				System.out.println();
			}
		}
	}
	
	public static String getMonthName(int month){
		String s = "";
		switch(month){
			case 1: s = "January"; break;
			case 2: s = "February"; break;
			case 3: s = "March"; break;
			case 4: s = "April"; break;
			case 5: s = "May"; break;
			case 6: s = "June"; break;
			case 7: s = "July"; break;
			case 8: s = "August"; break;
			case 9: s = "September"; break;
			case 10:s = "October"; break;
			case 11:s = "November"; break;
			case 12:s = "December"; break;
		}
		return s;
	}
	
	public static int getStartDay(int year,int month){
		return (3+getTotalDay(year,month-1))%7;
	}
	
	public static int getDayNumber(int year,int month){
		if (month == 1 || month == 3 || month == 5 || month == 7
				 || month == 8 || month == 10 || month == 12)
			return 31;
		if (month == 4 || month == 6 || month == 9 || month == 11){
			return 30;
		}
		if (month ==2) return isLeapYear(year)? 29:28;
		return 0;
			
	}
	
	public static boolean isLeapYear(int year){
		return year%400 == 0 || (year % 4 == 0 && year % 100 != 0);
	}
	
	public static int getTotalDay(int year,int month){
		int total = 0;
		for(int i = 1800; i < year; i++)
			if(isLeapYear(i)) total += 366;
			else total += 365;
		for(int i = 1;i <= month; i++)
			total += getDayNumber(year, i);
		return total;
	}
	

}



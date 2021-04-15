package com.sentha;
import java.util.*;
import java.time.*;
public class OlaApp
{
	public static void Login(long mob, String pass)
	{
		String num=String.valueOf(mob);
		int len=num.length();
		if(len==10)
		{
			System.out.println("Valid Mobile Number");
		}
		else
		{
			System.out.println("Invalid Mobile Number");
		}
		int passLen=pass.length();
		if(passLen>=8)
		{
			if(pass.equals("pass1234"))
				{
					System.out.println("Valid Password");
				}
			else
			{
				System.out.println("Invalid Password");
			}
		}
		else
		{
			System.out.println("Invalid Password");
		}	
	}
	public static void cabTypes()
	{
		System.out.println("Available Cabs");
		System.out.println("1. MICRO (Rs 10/km)");
		System.out.println("2. MINI (Rs 15/km)");
		System.out.println("3. PRIME (Rs 20/km)");
	}
	public static double priceEstimation(String cabType, double dist)
	{
		double amount=0;
		if(cabType.equalsIgnoreCase("MICRO"))
		{
			amount=dist*10;
		}
		else if(cabType.equalsIgnoreCase("MINI"))
		{
			amount=dist*15;
		}
		else if(cabType.equalsIgnoreCase("PRIME"))
		{
			amount=dist*20;
			
		}
		return amount;
	}
	public static double GST(double billAmount)
	{
		System.out.println("GST : 7%");
		double gst=billAmount*0.07;
		System.out.println("Your Bill Amount: "+billAmount);
		System.out.println("Your GST: "+gst);
		double total=billAmount+gst;
		System.out.println("TOTAL: "+total);
		return total;
	}
	public static void Booking(LocalDate journDate, LocalTime pickTime)
	{
		LocalDate now = LocalDate.now();
		if(journDate.isAfter(now) || journDate.isEqual(now))
		{
			System.out.println("Valid Date Format");
		}
		else  		
		{
			System.out.println("Invalid Date Format");
		}
		if((pickTime.getHour()>=0 &&pickTime.getHour()<=23) && (pickTime.getMinute()>=0 && pickTime.getMinute()<=60))
		{
			System.out.println("Valid Time Format");
		}
		else
		{
			System.out.println("Invalid Time Format");
		}
	}
	public static double peakHours(int hour, double tot)
	{
		double peakTotal;
		if(hour>=17.00 && hour<=19.00)// between 5pm to 7pm
		{
			System.out.println("For Peak Hours : 1.25% per KM");
			double peak=tot*0.0125;
			System.out.println("Your Bill Amount + GST: "+tot);
			System.out.println("Your Peak Hours Charge: "+peak);
		    peakTotal=tot+peak;
			System.out.println("TOTAL charges for peak hour: "+peakTotal);
		}
		else
		{
			System.out.println("CAB is booked in normal hours");
			peakTotal=tot;
		}
		return peakTotal;
	}
	public static double seniorCitizen(int yr, double amt)
	{
		int age=2021-yr;
		double discount;
		if(age>=50)
		{
			System.out.println("Senior Citizen");
			discount=amt*0.5;
			System.out.println("Total bill after consession:"+discount);
		}
		else
		{
			discount=amt;
		}
		return discount;	
	}
	public static void main(String[] args) 
	{
		//Level 1
		Scanner in = new Scanner(System.in);
		System.out.println("Enter Mobile Number");
		long mobNo=in.nextLong();
		System.out.println("Enter Password");
		String password=in.next();
		Login(mobNo,password);
		//LEVEL 2
		cabTypes();
		//LEVEL 3
		System.out.println("Enter the type of cab");
		String type=in.next();
		System.out.println("Enter the distance travelled in KM");
		double distance=in.nextDouble();
		double bill=priceEstimation(type,distance);
		System.out.println("Your Total Bill Amount Rs. "+bill);
		//LEVEL 4
		double ttl=GST(bill);
		//LEVEL 5
		System.out.println("Available Cabs");
		System.out.println("1. MICRO");
		System.out.println("2. MINI");
		System.out.println("3. PRIME");
		System.out.println("Enter the cab type");
		String cab=in.next();
		System.out.println("Enter the Journey Date in YYYY-MM-DD Format");
		String Jdate=in.next();
		LocalDate journeyDate = LocalDate.parse(Jdate);
		System.out.println("Enter the Journey Time in HH:MM Format");
		String PTime=in.next();
		LocalTime pickupTime = LocalTime.parse(PTime);
		Booking(journeyDate,pickupTime);
		//LEVEL 6
		int hr=pickupTime.getHour();
		double val=peakHours(hr,ttl);
		//LEVEl 7
		System.out.println("Enter you Date of Birth in YYYY-MM-DD Format");
		String dob=in.next();
		LocalDate dateofbirth = LocalDate.parse(dob);
		int year=dateofbirth.getYear();
		seniorCitizen(year,val);
	}
}

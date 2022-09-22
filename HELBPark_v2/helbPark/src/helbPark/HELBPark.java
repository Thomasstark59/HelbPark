package helbPark;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class HELBPark 
{
	private static Parking parking = new Parking();
	private static ArrayList<Motorized> listOfMotorUnsorted = new ArrayList<Motorized>();
	private static int nbreOfHours = 24;
	private static Fabric fabric = Fabric.getInstance();
	public static void main (String[] args)
	{
		parkEveryCar(sortList(init(listOfMotorUnsorted)));
		System.out.println("Hello world");
	}
	private static void parkEveryCar(ArrayList<Motorized> sortList) 
	{
		for (int i = 0; i >= nbreOfHours; i++) 
		{
			for (Motorized motorized : sortList) 
			{
				if(motorized.getArriveHour() == i)
				{
					parking.searchPlace(motorized);
				}
				else if(motorized.getArriveHour() > i)
				{
					System.out.println(i);

					System.out.println("ok");
					try 
					{
						Thread.sleep(1000);
						return;
					} 
					catch (InterruptedException e) 
					{
						e.printStackTrace();
					}
				}
			}
		}
	}
	private static ArrayList<Motorized> sortList(ArrayList<Motorized> listOfMotorUnsorted) 
	{
		ArrayList<Motorized> listOfMotorSorted = new ArrayList<Motorized>();
		for (int i = 0; i <= nbreOfHours; i++) 
		{
			for (Motorized motorized : listOfMotorUnsorted) 
			{
				if(motorized.getArriveHour() == i) //ca sert ici
				{
					listOfMotorSorted.add(motorized);
				}
			}
		}
		listOfMotorUnsorted = null;
		return listOfMotorSorted;
	}
	private static ArrayList<Motorized> init(ArrayList<Motorized> listOfMotorUnsorted)//must be delete on the final app(after the exam)
	{
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader("D:\\HELBPark v2\\helbPark\\input.txt"));
			String line = reader.readLine();
			while (line != null) 
			{
				String[] arrOfStr = line.split(",", 3);
				fabric.createMotor(arrOfStr[1],Integer.parseInt(arrOfStr[0]),arrOfStr[2], checkDate());
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return listOfMotorUnsorted;
	}
	private static Strategies checkDate() 
	{

		Date today = new Date(); 
		Calendar cal = Calendar.getInstance(); 
		cal.setTime(today); 
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); // 6

		if(String.valueOf(dayOfWeek) == "1")
		{
			NoDiscount othersDay = new NoDiscount();
			return othersDay;
		}
		else if (String.valueOf(dayOfWeek) == "2")
		{
			FiftyPourcentForMoto tuesday = new FiftyPourcentForMoto();
			return tuesday;
		}
		else if (String.valueOf(dayOfWeek) == "3")
		{
			PInPlaque wednesday = new PInPlaque();
			return wednesday;
		}
		if(String.valueOf(dayOfWeek) == "4")
		{
			NoDiscount othersDay = new NoDiscount();
			return othersDay;
		}
		if(String.valueOf(dayOfWeek) == "5")
		{
			FiftyPourcentVan friday = new FiftyPourcentVan();
			return friday;
		}
		if(String.valueOf(dayOfWeek) == "6")
		{
			PairDayAndSaturday saturday = new PairDayAndSaturday();
			return saturday;
		}
		if(String.valueOf(dayOfWeek) == "7")
		{
			NoDiscount othersDay = new NoDiscount();
			return othersDay;
		}
		return null;
	}
	
	}

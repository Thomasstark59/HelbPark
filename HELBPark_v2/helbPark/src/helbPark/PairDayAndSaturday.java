package helbPark;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PairDayAndSaturday implements Strategies
{
	public int discount(Motorized vehicule, int price)
	{
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd");
		LocalDateTime now = LocalDateTime.now();
		String day = dtf.format(now);
		int somme = price;
		if(Integer.parseInt(day) % 2 == 0)
		{
			somme = somme / 2;
		}
		return somme;
	}
}

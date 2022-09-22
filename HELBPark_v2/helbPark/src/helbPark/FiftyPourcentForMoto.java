package helbPark;

public class FiftyPourcentForMoto implements Strategies
{
	public int discount(Motorized vehicule, int price)
	{
		int somme = price;
		if(vehicule instanceof Moto)
		{
			somme = price / 2;
		}
		return somme;
	}
}

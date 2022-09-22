package helbPark;

public class FiftyPourcentVan implements Strategies
{
	public int discount(Motorized vehicule, int price)
	{
		int somme = price;
		if(vehicule instanceof Van)
		{
			somme = somme / 2;
		}
		return somme;
	}
}

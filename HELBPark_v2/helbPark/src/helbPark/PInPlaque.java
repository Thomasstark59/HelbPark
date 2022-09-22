package helbPark;

public class PInPlaque implements Strategies
{
	public int discount(Motorized vehicule, int price)
	{
		int somme = price;
		for (int i = 0; i < vehicule.getPlaque().length(); i++) 
		{
			if (vehicule.getPlaque().charAt(i) == 'p' || vehicule.getPlaque().charAt(i) == 'P')
			{
				somme = (somme / 100) * 25; //to get 25% discount
			}
		}
		return somme;
	}
}

package helbPark;

public class NoDiscount implements Strategies
{

	@Override
	public int discount(Motorized vehicule, int price) 
	{
		return price;
	}

}

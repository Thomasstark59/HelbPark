package helbPark;

public class Standart extends Ticket
{

	public Standart(Place place, String type) 
	{
		super(place, type);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected String generateDiscount() 
	{
		String discount = "";
		int rand = (int)(Math.random()*2);
		if (rand == 1)
		{
			discount = "5";
		}
		else
		{
			discount = "10";
		}
		return discount;
	}

	@Override
	protected String generateGame() 
	{
		return "There is no game";
	}

}

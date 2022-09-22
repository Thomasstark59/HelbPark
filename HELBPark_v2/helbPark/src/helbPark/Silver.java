package helbPark;

public class Silver extends Ticket
{
	private int letter = 2;
	public Silver(Place place, String type) 
	{
		super(place, type);
	}

	@Override
	protected String generateGame() 
	{
		String letterString = "OXP";
		StringBuilder sb = new StringBuilder(letter);
		String game = "";
		for (int j = 0; j < letter; j++) 
		{
			sb.append(letterString.charAt((int) (Math.random() * letterString.length())));
			game = sb.toString();
		}
		return game;	
	}

	@Override
	protected String generateDiscount() 
	{
		String discount = "";
		int rand = (int)(Math.random()*2);
		if (rand == 1)
		{
			discount = "10";
		}
		else
		{
			discount = "15";
		}
		return discount;
	}


}

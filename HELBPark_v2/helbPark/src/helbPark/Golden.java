package helbPark;

public class Golden extends Ticket 
{
	private int letter = 3;
	private int lines = 3;
	public Golden(Place place, String type) 
	{
		super(place, type);
	}

	@Override
	protected String generateGame() 
	{
		String game = "";
		String letterString = "PARKHELB";
		for (int i = 0; i < lines ; i++) 
		{
			StringBuilder sb = new StringBuilder(letter);
			String letterCode = "";
			for (int j = 0; j < letter; j++) 
			{
				sb.append(letterString.charAt((int) (Math.random() * letterString.length())));
				letterCode = sb.toString();
			}
			game += letterCode + "\r";
		}
		return game;	
	}


	@Override
	protected String generateDiscount() 
	{
		String discount = "";
		int rand = (int)(Math.random() * 2);
		if (rand == 0)
		{
			discount = "20";
		}
		else
		{
			discount = "40";
		}
		return discount;
	}



}

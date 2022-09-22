package helbPark;


public abstract class Ticket 
{
	private int numberLetter = 3;
	private Place place = null;
	private String type = "";
	public Ticket(Place place, String type)
	{
		this.place = place;
		this.type = type;
	}

	public void generateTicket()
	{
		String currentDate = "Date : " + java.time.LocalDate.now().toString();
		String currentPlace = "Current place : " + this.place.getId();
		String currentVehiculeType = "Current vehicule : " + this.place.getVehicule().getClass().toString();
		int currentPrice = determinatePrice(this.place.getVehicule().getClass().toString());
		String currentPriceString = "Basic price : " + currentPrice + " euros";
		String currentDiscount = "Current discounted price : " + this.place.getVehicule().discountOnDay();
		String totalPrice = "Total to pay = " + currentPrice + " - " +this.place.getVehicule().discountOnDay() + " = " + (currentPrice - this.place.getVehicule().discountOnDay());
		String currentCodeDiscount = "Cinema discount code : " + generateRandomCode();
		String currentTypeOfTicket = this.type + " : " + generateDiscount() + "%";
		String jeu = "Game : " + generateGame();
		String stringFichier = "//////////////////////////////////////" + "\r" + currentDate + "\r" + currentPlace + "\r" + currentVehiculeType + "\r" + currentPriceString + "\r" + currentDiscount + "\r" + totalPrice + "\r" + currentCodeDiscount + "\r" + currentTypeOfTicket + "\r" + jeu+ "\r" +"//////////////////////////////////////";
		Fichier fichier = new Fichier (stringFichier, this.type, this.place.getVehicule().getPlaque());
		fichier.write();
	}
	
	protected abstract String generateDiscount();
	protected abstract String generateGame();
	private String generateRandomCode() 
	{
		String code = "";
		String letterString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		for (int i = 0; i < numberLetter; i++) {
			StringBuilder sb = new StringBuilder(numberLetter);
			sb.append(letterString.charAt((int) (Math.random() * letterString.length())));
			String letterCode = sb.toString();
			code += letterCode;
		}

		int upperBound = 999;
		int lowerBound = 100;
		int number = lowerBound + (int)(Math.random() * ((upperBound - lowerBound) + 1));
		
		code += number;
		return code;
	}
	
	private int determinatePrice(String type) {
		int price = 0;
		switch (type) 
		{
		case "moto":
			price = 10;
			break;
			
		case "voiture":
			price = 20;
			break;
			
		case "camionette":
			price = 30;
			break;
		}
		return price;
	}
	public Ticket genTicket(Place place)
	{
		String typeOfMotor = place.getVehicule().getClass().toString();
		int randomForPlace = 5;
		int rand = (int) (Math.random()*randomForPlace)+1;
		Ticket ticket = null;
		if((rand < 3 && typeOfMotor == "moto") || (rand < 1 && typeOfMotor != "moto"))
		{
			ticket = new Golden(place, "golden");
		}
		else if ((rand < 3 && typeOfMotor == "voiture") || (rand < 1 && typeOfMotor != "voiture"))
		{
			ticket = new Silver(place, "silver");
		}
		else if ((rand < 3 && typeOfMotor == "camionette") || (rand < 1 && typeOfMotor != "camionette"))
		{
			ticket = new Standart(place, "standart");
		}
		return ticket;
	}
}

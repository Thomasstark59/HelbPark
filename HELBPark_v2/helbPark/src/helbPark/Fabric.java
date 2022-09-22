package helbPark;

public class Fabric 
{
	private static volatile Fabric fabric = null;
	private Fabric()
	{
		super();
	}
	public final static Fabric getInstance()
	{
		if(Fabric.fabric == null)
		{
			synchronized (Fabric.class) 
			{
				if(Fabric.fabric == null)
				{
					return Fabric.fabric = new Fabric();
				}
			}
		}
		return Fabric.fabric;
	}
	
	public Object createMotor(String name, int arriveHour, String plaque ,Strategies strat)
	{
		if (name.matches("camionnette"))
		{
			return new Van(arriveHour, plaque, strat);
		}
		else if(name.matches("moto"))
		{
			return new Moto(arriveHour, plaque, strat);
		}
		else if(name.matches("voiture"))
		{
			return new Car(arriveHour, plaque, strat);
		}
		return "failed";
	}
	public Object createTicket(String name, Place place) 
	{
		if(name.matches("golden"))
		{
			return new Golden(place, name);
		}
		else if(name.matches("silver"))
		{
			return new Silver(place, name);
		}
		else if(name.matches("standart"))
		{
			return new Standart(place, name);
		}
		return null;
	}
}

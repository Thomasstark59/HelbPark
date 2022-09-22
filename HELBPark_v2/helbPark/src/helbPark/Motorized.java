package helbPark;

public abstract class Motorized 
{
	protected Strategies strategy;
	private int arriveHour = 0;
	private String plaque = "";
	String type = "";
	public Motorized(int arriveHour , String plaque, Strategies strategy )
	{
		this.strategy = strategy;
		this.arriveHour = arriveHour;
		this.plaque = plaque;
	}
	public int discountOnDay()
	{
		return this.strategy.discount(this, 10);
	}
	public int getArriveHour() 
	{
		return arriveHour;
	}
	public void setArriveHour(int arriveHour) 
	{
		this.arriveHour = arriveHour;
	}
	public String getPlaque() 
	{
		return plaque;
	}
	public void setPlaque(String plaque) 
	{
		this.plaque = plaque;
	}
}

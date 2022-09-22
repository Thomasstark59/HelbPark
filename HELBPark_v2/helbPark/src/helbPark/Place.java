package helbPark;

public class Place 
{
	private int id = -1;
	private Motorized vehicule = null;
	public Place(int id) 
	{
		this.id = id;
	}
	public void addMotor(Motorized vehicule)
	{
		this.vehicule = vehicule;
	}
	public void delMotor()
	{
		this.vehicule = null;
	}
	public int getId() {
		return id;
	}
	public Motorized getVehicule() {
		return vehicule;
	}
	public void setVehicule(Motorized vehicule) 
	{
		this.vehicule = vehicule;
	}
}

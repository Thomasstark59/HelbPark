package helbPark;

import java.util.ArrayList;

public class Parking 
{
	private final int numberOfPlace = 19;
	private ArrayList<Place> listOfPlace = new ArrayList<Place>();
	private static int id = 0;
	private static boolean parkingFull = false;
	public Parking()
	{
		for (int i = 0; i <= numberOfPlace; i++) 
		{
			Place place = new Place(id);
			id++;
			listOfPlace.add(place);
		}
	}
	public void searchPlace(Motorized vehicule)
	{
		if (!parkingFull) 
		{
			for (Place place : listOfPlace) 
			{
				if(place.getVehicule() == null)
				{
					place.addMotor(vehicule);
					System.out.println("this place is free");
					return;
				}
				else
				{
					System.out.println("this place is use by a " + place.getVehicule().getPlaque());
				}
				if(place.getId()+1 == listOfPlace.size())
				{
					parkingFull = true;
				}
			}
		}
		else {
			System.out.println("no more place");
		}
		
	}
	public void removeMotor(int index)
	{
		for (Place place : listOfPlace) 
		{
			if(place.getId() == index)
			{
				place.delMotor();
			}
		}
	}
	public ArrayList<Place> getListOfPlace() 
	{
		return listOfPlace;
	}
}

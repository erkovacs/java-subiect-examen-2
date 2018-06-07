package classes;

import java.util.List;

import interfaces.Vehicle;

public class VectThread implements Runnable{

	private List<Vehicle> carsList;
	private double avgWeight;
	
	public VectThread(String file) {
		carsList = Utils.readBinaryCars(file);
	}

	@Override
	public void run() {
		double sum = 0;
		for(Vehicle veh : carsList)
		{
			Car car = (Car)veh;
			sum += car.getWeight();
		}
		if(carsList.size() > 0){
			System.out.println("The avg weight is " + (sum/carsList.size()));
			return;
		}
		System.out.println("Cars is empty");
	}

}

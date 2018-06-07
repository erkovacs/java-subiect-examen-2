package classes;

import java.awt.List;
import java.util.ArrayList;

import interfaces.Vehicle;

public class Examen {

	public static void main(String[] args) {
		ArrayList<Car> cars = new ArrayList<Car>();
		Car c1 = new Car();
		try{
			c1.setPrice(1000);
			c1.setProducer("SUZUKI");
			c1.setWeight(1450);
			Car c2 = new Car();
			c2.setPrice(2500);
			c2.setProducer("DACIA");
			c2.setWeight(1600);
			cars.add(c1);
			cars.add(c2);
			Utils.createCars(2);
			Utils.setCars(cars);
			Utils.writeBinaryCars("cars.dat");
			ArrayList<Vehicle> cars2 = (ArrayList<Vehicle>) Utils.readBinaryCars("cars.dat");
			for(Vehicle veh : cars2){
				Car car = (Car)veh;
				System.out.println("Price: "+ car.getPrice() + "; Producer: " + car.getProducer() + "; Weight: "+ car.getWeight());
			}
			VectThread vt = new VectThread("cars.dat");
			vt.run();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}

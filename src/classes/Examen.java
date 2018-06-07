package classes;

import java.awt.List;
import java.util.ArrayList;

import interfaces.Vehicle;

public class Examen {

	public static void main(String[] args) {
		ArrayList<Vehicle> cars = new ArrayList<Vehicle>();
		Car c1 = new Car();
		try{
			// Make sure basic stuff works
			c1.setPrice(1000);
			c1.setProducer("SUZUKI");
			c1.setWeight(1450);
			Car c2 = new Car();
			c2.setPrice(2500);
			c2.setProducer("DACIA");
			c2.setWeight(1600);
			cars.add(c1);
			cars.add(c2);
			
			// Test serialization/deserialization
			Utils.createCars(2);
			Utils.writeBinaryCars("cars.dat", cars);
			ArrayList<Vehicle> cars2 = (ArrayList<Vehicle>) Utils.readBinaryCars("cars.dat");
			for(Vehicle veh : cars2){
				Car car = (Car)veh;
				System.out.println("Price: "+ car.getPrice() + "; Producer: " + car.getProducer() + "; Weight: "+ car.getWeight());
			}
			
			// vect thread part
			VectThread vt = new VectThread("cars.dat");
			vt.run();
			
			// jdbc part
			UtilsDAO.setConnection();
			// Fake the data...
			UtilsDAO.insertData();
			// Make a simple select
			System.out.println(UtilsDAO.selectData());
			// Close db connection
			UtilsDAO.closeConnection();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}

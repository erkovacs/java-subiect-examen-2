package classes;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import interfaces.*;

public class Utils {
	
	private static List<Vehicle> cars;
	
	public Utils() {
	}
	
	public static List<Vehicle> createCars(int n)
	{
		cars = new ArrayList<Vehicle>(n);
		return cars;
	}
	
	public static List<Vehicle> readCars(String file){
		try {
			// Java java why u have to make my job hard ;)
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(
							new FileInputStream(
									new File(file)
									)
							)
					);
			
			String line = "";
			cars = new ArrayList<Vehicle>();
			while((line = reader.readLine()) != null)
			{
				Car c = new Car();
				line = reader.readLine();
				c.setWeight(Float.parseFloat(line));
				line = reader.readLine();
				c.setPrice(Double.parseDouble(line));
				line = reader.readLine();
				c.setProducer(line);
				cars.add(c);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cars;
	}
	
	public static void writeBinaryCars(String file, List<Vehicle> listP){
		
		try {
			for(Vehicle veh : listP)
			{
				Car car = (Car)veh;
				cars.add(car);
			}
			ObjectOutputStream serializer = new ObjectOutputStream (
					new FileOutputStream(
							new File(file)
							)
					);
			serializer.writeObject(cars);
			serializer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static List<Vehicle> readBinaryCars(String file){
		try {
			ObjectInputStream deserializer = new ObjectInputStream (
					new FileInputStream(
							new File(file)
							)
					);
			cars = (List<Vehicle>) deserializer.readObject();
			deserializer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return cars;
	}
	
}

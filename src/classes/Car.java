package classes;

import java.io.Serializable;

import interfaces.Vehicle;

public class Car implements Vehicle, Serializable, Cloneable {
	private float weight;
	private double price;
	private String producer;
	
	@Override
	public String infoVehicle() {
		return producer;
	}
	
	public Car()
	{
	}
	
	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) throws Exception {
		if(weight < 0)
		{
			throw new Exception("Weight is invalid");
		}
		this.weight = weight;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) throws Exception {
		if(price < 0)
		{
			throw new Exception("Price is invalid");
		}
		this.price = price;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}
	
	@Override 
	protected Car clone()
	{
		Car c =  new Car();
		try {
			c.setPrice(price);
			c.setProducer(producer);
			c.setWeight(weight);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}
	
	@Override
	public boolean equals(Object o)
	{
		if(!(o instanceof Car))
		{
			return false;
		}else{
			Car c = (Car)o;
			if(
					weight == c.getWeight() &&
					price == c.getPrice() && 
					producer.equals(c.getProducer())
			){
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int hashCode()
	{
		return super.hashCode();
	}

}

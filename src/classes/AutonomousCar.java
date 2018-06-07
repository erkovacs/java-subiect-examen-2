package classes;

public class AutonomousCar extends Car {
	
	private int softwareVersion;
	
	public AutonomousCar() {
		super();
	}
	
	@Override
	public String infoVehicle() {
		return String.format("%d", softwareVersion);
	}
	
	public int getSoftwareVersion()
	{
		return softwareVersion;
	}
	
	public void setSoftwareVersion(int softwareVersion) throws Exception
	{
		if(softwareVersion < 0)
		{
			throw new Exception("Weight is invalid");
		}
		this.softwareVersion = softwareVersion;
	}
}

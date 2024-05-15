package models;

public class ServiceRegion {
	private int srrgId;
	private String srrgName;
	private int srrgPinfrom;
	private int srrgPinto;
	
	
	public ServiceRegion(int srrgId, String srrgName, int srrgPinfrom, int srrgPinto) {
		super();
		this.srrgId = srrgId;
		this.srrgName = srrgName;
		this.srrgPinfrom = srrgPinfrom;
		this.srrgPinto = srrgPinto;
	}
	
	public int getSrrgId() {
		return srrgId;
	}
	public void setSrrgId(int srrgId) {
		this.srrgId = srrgId;
	}
	public String getSrrgName() {
		return srrgName;
	}
	public void setSrrgName(String srrgName) {
		this.srrgName = srrgName;
	}
	public int getSrrgPinfrom() {
		return srrgPinfrom;
	}
	public void setSrrgPinfrom(int srrgPinfrom) {
		this.srrgPinfrom = srrgPinfrom;
	}
	public int getSrrgPinto() {
		return srrgPinto;
	}
	public void setSrrgPinto(int srrgPinto) {
		this.srrgPinto = srrgPinto;
	}
}

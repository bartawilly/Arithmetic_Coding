

public class harf {
	private String name;
	private double Pro;
	private double upper;
	private double lower;
	harf()
	{
		name=" ";
		Pro=0.0;
	
	}
	harf(harf h)
	{
		name=h.name;
		Pro=h.Pro;
	}
	harf(double pro,String name)
	{
		this.name=name;
		Pro=pro;
	}
	
	public String getname() {
		return name;
	}
	public void setname(String name) {
		this.name = name;
	}
	public double getpro() {
		return Pro;
	}
	public void setpro(double pro) {
		Pro = pro;
	}
	public void setlower(double lower) {
		this.lower=lower ;
	}
	public double getlower() {
	 return lower;
	}
	public void setupper(double upper) {
		this.upper=upper ;
	}
	public double getupper() {
	 return upper;
	}
	
	@Override
	public String toString() {
		return name + " prob "+ Pro+" lower "+lower+ "upper "+upper+": ";
	}
	
	
}

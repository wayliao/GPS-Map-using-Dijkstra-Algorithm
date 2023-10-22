/**
 * An Interface that contains some necessary methods of vertex
 */
public class Vertex {
	//fields
	private String symbol;
	private String address;

	//constructor
	public Vertex(String symbol, String address)
	{
		this.symbol=symbol;
		this.address=address;
	}
	public String getSymbol() {
		return this.symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public String getAddress() {
		return this.address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}

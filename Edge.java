/**
 * An Interface that contains some necessary methods of Edge
 */
public class Edge {
	private Vertex from;
	private Vertex to;
	private Integer cost;
	//constructor
	public Edge(Vertex from, Vertex to, Integer cost)
	{
		this.setTo(to);
		this.setFrom(from);
		this.cost= cost;
		
	}
	public Vertex getFrom() {
		return this.from;
	}
	public void setFrom(Vertex from) {
		this.from = from;
	}
	public Integer getCost() {
		return this.cost;
	}
	public void setCost(Integer cost) {
		this.cost = cost;
	}
	public Vertex getTo() {
		return this.to;
	}
	public void setTo(Vertex to) {
		this.to = to;
	}
	
}

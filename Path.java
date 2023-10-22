/**
 * Path class which includes the most recently visited vertex, the current 
 * cost, and the overall path so far. It also has a compare to method which
 * compares the costs of two paths.
 * @author Anthony Brey
 *
 */
public class Path implements Comparable<Path>{
	String vertex;
	int cost;
	String pathStr;
	
	/**
	 * A constructor method for path which has parameter values for vertex, 
	 * cost, and pathStr
	 * @param vertex
	 * @param cost
	 * @param pathStr
	 */
	public Path(String vertex, int cost, String pathStr) {
		this.setVertex(vertex);
		this.setCost(cost);
		this.setPathStr(pathStr);
	}

	/**
	 * gets the current cost
	 * @return the current cost
	 */
	public int getCost() {
		return cost;
	}

	/**
	 * sets the cost to the parameter value
	 * @param cost the new value of cost
	 */
	public void setCost(int cost) {
		this.cost = cost;
	}

	/**
	 * gets the current vertex
	 * @return the current vertex
	 */
	public String getVertex() {
		return vertex;
	}

	/**
	 * sets the vertex to the parameter value
	 * @param vertex the new value of vertex
	 */
	public void setVertex(String vertex) {
		this.vertex = vertex;
	}

	/**
	 * gets the path string so far
	 * @return the path string so far
	 */
	public String getPathStr() {
		return pathStr;
	}

	/**
	 * sets the path string to the parameter value
	 * @param pathStr the new value of pathStr
	 */
	public void setPathStr(String pathStr) {
		this.pathStr = pathStr;
	}

	/**
	 * Compares this path to another path o by subtracting this cost by o's
	 * cost, which ensures that the shortest path has priority
	 * @param pat the path which this path will be compared to
	 * @return the difference between this cost and o's cost
	 */
	@Override
	public int compareTo(Path pat) {
		return this.cost - pat.cost;
	}
}

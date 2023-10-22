import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.HashMap;
import java.util.HashSet;


/**
 * Graph class that takes a text file and creates vertices and edges
 */

public class Graph {
	private HashMap<Vertex, HashSet<Edge>> adjList;
	public static boolean useDistCost, returnAddress;

	/**
	 * Constructor uses the text file to read the data of
	 * edges and nodes and uses them to build a graph.
	 * 
	 * @param filename
	 * @throws FileNotFoundException
	 */
	public Graph(File filename) throws FileNotFoundException {
		adjList = new HashMap<Vertex, HashSet<Edge>>();
		Scanner in = new Scanner(filename);
		in.nextLine();
		in.nextLine();
		boolean stop = false;
		while (!stop) {
			String line = in.nextLine();
			if (line.equals("</Nodes>")) {
				stop = true;
				in.nextLine();
				in.nextLine();
				break;
			}
			String[] vertex = line.split("\t");
			String symbol = vertex[0];
			String address = vertex[1];
			addVertex(symbol, address);
		}
		stop = false;
		while (!stop) {
			String line = in.nextLine();
			if (line.equals("</Edges>")) {
				stop = true;
				break;
			}
			String[] edge = line.split("\t");
			Vertex source = null;
			Vertex destination = null;
			int cost;
			for (Vertex vertex : adjList.keySet()) {
				if (vertex.getSymbol().equals(edge[0])) {
					source = vertex;
				}
				if (vertex.getSymbol().equals(edge[1])) {
					destination = vertex;
				}
			}
			if (useDistCost) {
				System.out.println(true);
				cost = Integer.parseInt(edge[3]);
			} else {
				cost = Integer.parseInt(edge[2]);
			}
			addEdge(source, destination, cost);
		}
		in.close();
	}

	/**
	 * Adds Vertices to Graph
	 * @param symbol
	 * Symbol of the vertex
	 * @param address
	 * address of the vertex
	 */
	public void addVertex(String symbol, String address) {
		if (this.getVertex(symbol) == null) {
			Vertex v = new Vertex(symbol, address);
			adjList.put(v, new HashSet<Edge>());
		}

	}

	/**
	 * Adds Edges to graph
	 * @param v0
	 * start vertex
	 * @param v1
	 * Destination vertex
	 * @param cost
	 * time OR distance cost
	 */
	public void addEdge(Vertex v0, Vertex v1, Integer cost) {
		for (Vertex x : adjList.keySet()) {
			if (x.equals(v0)) {
				adjList.get(x).add(new Edge(v0, v1, cost));
			}
		}
	}
	/**
	 * getVertex method used to find vertex from hashmap and return it if available.
	 * @param symbol of selected vertex
	 * @return Vertex
	 */
	public Vertex getVertex(String symbol) {
		for (Vertex v : adjList.keySet()) {
			if (v.getSymbol().equals(symbol)) {
				return v;
			}
		}
		return null;

	}

	/**
	 * Display all edges in the hashmap,
	 * and display addresses or symbols based on condition: returnAddress
	 * 
	 * @return string representation of the graph
	 */
	public String toString() {
		String ret = "";
		for (Vertex vert : adjList.keySet()) {
			for (Edge edge : adjList.get(vert)) {
				if (returnAddress) {
					ret = ret + vert.getAddress() + " -> " + edge.getTo().getAddress();
				} else {
					ret = ret + vert.getSymbol() + " -> " + edge.getTo().getSymbol();
				}
				if (useDistCost) {
					ret = ret + " (" + edge.getCost() + " miles), \n";
				} else {
					ret = ret + " (" + edge.getCost() + " minutes), \n";
				}
			}
		}
		return ret.substring(0, ret.length() - 3);
	}

	/**
	 * Get method for the Adjacency List of the graph
	 * @return the Adjacency List
	 */
	public HashMap<Vertex, HashSet<Edge>> getAdjList() {
		return adjList;
	}

	/**
	 * Set method for the Adjacency List of the graph
	 * 
	 * @param adjList
	 * the Adjacency List of the graph
	 */
	public void setAdjList(HashMap<Vertex, HashSet<Edge>> adjList) {
		this.adjList = adjList;
	}
}

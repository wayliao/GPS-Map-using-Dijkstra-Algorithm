import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Dijkstra algorithm class that takes a Graph and two vertices that determines the shortest path between them
 */
public class Dijkstra {
	private static int totalCost;

	/**
	 * @param graph
	 * Graph that we are investigating
	 * @param startingVertex
	 * start of the path
	 * @param endingVertex
	 * end of the path
	 * @return a Path that has the minimum cost from the starting Vertex to the destination
	 */
	public static Path shortestPath(Graph graph, Vertex startingVertex, Vertex endingVertex) {
		PriorityQueue<Path> priorityQueue = new PriorityQueue<Path>();
		priorityQueue.add(new Path(startingVertex.getSymbol(), 0, startingVertex.getSymbol()));
		ArrayList<String> visited = new ArrayList<String>();
		Path nextEntry = null;
		while (!priorityQueue.isEmpty()) {
			nextEntry = priorityQueue.remove(); // removes lowest cost
			totalCost = nextEntry.cost;
			if (!visited.contains(nextEntry.vertex)) {
				visited.add(nextEntry.vertex);
			}
			if (nextEntry.vertex.equals(endingVertex.getSymbol())) {
				return nextEntry;
			} else {
				String currentVertex = nextEntry.vertex;
				int currentCost = nextEntry.cost;
				String currentPath = nextEntry.pathStr;
				Vertex iterator = null;
				for (Vertex v : graph.getAdjList().keySet()) {
					if (v.getSymbol().equals(currentVertex)) {
						iterator = v;
						break;
					}
				}
				for (Edge edge : graph.getAdjList().get(iterator)) {
					Vertex v = edge.getTo();
					if (!visited.contains(v.getSymbol())) {
						int nextCost = currentCost + edge.getCost();
						String nextPath = currentPath + v.getSymbol();
						Path nextState = new Path(v.getSymbol(), nextCost, nextPath);
						priorityQueue.add(nextState);
					}
				}
			}
		}
		return null;
	}

	public static int getTotalCost() {
		return totalCost;
	}

	public static void setTotalCost(int totalCost) {
		Dijkstra.totalCost = totalCost;
	}

}


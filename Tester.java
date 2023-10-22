import java.io.File;
import java.io.FileNotFoundException;

/**
 * Tester class which used to test some special cases.
 */
public class Tester {

	public static void main(String[] args) throws FileNotFoundException {

		// Graph.useDistCost = true;
		// Graph.returnAddress = true;
		Graph g = new Graph(new File("MapInformation.txt"));

		//System.out.println(g.toString());
		System.out.println("Short Path: " +
				Dijkstra.shortestPath(g, g.getVertex("K"), g.getVertex("L")).getPathStr()
				+ " Total cost: " + Dijkstra.getTotalCost());
//System.out.println("K->L:KHL " + "totalcost = " + " 6" + ", distance" + "17" );

		if (Dijkstra.shortestPath(g, g.getVertex("Q"), g.getVertex("E")) != null) {
			System.out.println("Short Path: " + Dijkstra.shortestPath(g, g.getVertex("Q"),
					g.getVertex("E")).getPathStr() + " Total cost: " + Dijkstra.getTotalCost());
		} else {
			System.out.println("No path found from 'Q' to 'E'");
		}

		//System.out.println(j.shortestPath(g,g.getVertex("Q"),g.getVertex("E")).getPathStr());
//System.out.println("Q->E:Error,no route" );
		System.out.println("Short Path: "
				+ Dijkstra.shortestPath(g, g.getVertex("A"), g.getVertex("A")).getPathStr()
				+ " Total cost: " + Dijkstra.getTotalCost());
//System.out.println("A->A " + "totalcost =" + "0");
	}
}
package graph;
import graph.WeightedGraph;
import maze.Juncture;
import maze.Maze;

/** 
 * <P>The MazeGraph is an extension of WeightedGraph.  
 * The constructor converts a Maze into a graph.</P>
 */
public class MazeGraph extends WeightedGraph<Juncture> {
	
	/** 
	 * <P>Construct the MazeGraph using the "maze" contained
	 * in the parameter to specify the vertices (Junctures)
	 * and weighted edges.</P>
	 * 
	 * <P>The Maze is a rectangular grid of "junctures", each
	 * defined by its X and Y coordinates, using the usual
	 * convention of (0, 0) being the upper left corner.</P>
	 * 
	 * <P>Each juncture in the maze should be added as a
	 * vertex to this graph.</P>
	 * 
	 * <P>For every pair of adjacent junctures (A and B) which
	 * are not blocked by a wall, two edges should be added:  
	 * One from A to B, and another from B to A.  The weight
	 * to be used for these edges is provided by the Maze. 
	 * (The Maze methods getMazeWidth and getMazeHeight can
	 * be used to determine the number of Junctures in the
	 * maze. The Maze methods called "isWallAbove", "isWallToRight",
	 * etc. can be used to detect whether or not there
	 * is a wall between any two adjacent junctures.  The 
	 * Maze methods called "getWeightAbove", "getWeightToRight",
	 * etc. should be used to obtain the weights.)</P>
	 * 
	 * @param maze to be used as the source of information for
	 * adding vertices and edges to this MazeGraph.
	 */
	public MazeGraph(Maze maze) {
		super(); // Calls the constructor in the WeightedGraph to initialize the graph
		
		// Add each juncture in the maze as a vertex to this graph
		for(int xCoordinate = 0; xCoordinate < maze.getMazeWidth(); xCoordinate++) {
			for(int yCoordinate = 0; yCoordinate < maze.getMazeHeight(); yCoordinate++) {
				addVertex(new Juncture(xCoordinate, yCoordinate));
			}
		}
		
		// For every pair of adjacent junctures (A and B) which are not blocked by a wall, two edges are added: One from A to B, and another from B to A
		for(int xCoordinate = 0; xCoordinate < maze.getMazeWidth(); xCoordinate++) { 
			for(int yCoordinate = 0; yCoordinate < maze.getMazeHeight(); yCoordinate++) {
				Juncture juncture = new Juncture(xCoordinate, yCoordinate); // Create a reference jjuncture with the current xCoor and yCoor
				
				// Check conditions and add respective edges by using .getWeight to get the weight
				if(!maze.isWallAbove(juncture)) {
					addEdge(juncture, new Juncture(xCoordinate, yCoordinate - 1), maze.getWeightAbove(juncture));
				}
				if(!maze.isWallBelow(juncture)) {
					addEdge(juncture, new Juncture(xCoordinate, yCoordinate + 1), maze.getWeightBelow(juncture));
				}
				if(!maze.isWallToLeft(juncture)) {
					addEdge(juncture, new Juncture(xCoordinate - 1, yCoordinate), maze.getWeightToLeft(juncture));
				}
				if(!maze.isWallToRight(juncture)) {
					addEdge(juncture, new Juncture(xCoordinate + 1, yCoordinate), maze.getWeightToRight(juncture));
				}
			}
		}
		
	}
}

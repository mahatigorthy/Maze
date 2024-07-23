This code implements a random maze generator and converts the maze into a graph representation. Here's a brief description of the two main parts:

### `Maze` Class:
- **Purpose:** Generates a random maze.
- **Constructor:** Initializes the maze dimensions, sets up walls, and assigns weights (costs) to travel between junctures.
- **Key Methods:**
  - **`drawFrom`:** Recursively draws walls in the maze to ensure every cell is reachable while maintaining randomness.
  - **`possibleToExtend`:** Checks if a juncture can extend its current wall.
  - **`isWallAbove`, `isWallBelow`, `isWallToLeft`, `isWallToRight`:** Checks if there are walls in the respective directions of a juncture.
  - **`getWeightAbove`, `getWeightBelow`, `getWeightToLeft`, `getWeightToRight`:** Returns the weight (cost) of traveling in the respective directions from a juncture.

### `MazeGraph` Class:
- **Purpose:** Converts the maze into a weighted graph where each juncture is a vertex, and edges represent the paths between adjacent junctures with corresponding weights.
- **Constructor:**
  - **Adds Vertices:** Iterates through the maze dimensions and adds each juncture as a vertex in the graph.
  - **Adds Edges:** For each juncture, checks if there's no wall blocking the adjacent junctures and adds edges between them with the appropriate weights.

In summary, the `Maze` class creates a random maze with walls and weights, and the `MazeGraph` class represents this maze as a weighted graph where junctures are vertices connected by edges if there's no wall between them, and the edges have weights corresponding to the travel costs.

package maze;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.*;

/**
 * The <code>MazeCell</code> class stores information about each individual cell
 * in the maze. The boolean values <code>north</code>, <code>east</code>,
 * <code>west</code>, and <code>south</code> store which walls are up; e.g., if
 * <code>north</code> is <code>true</code>, then the north wall is up.
 * 
 * Each cell also has pointer to its four <code>MazeCell</code> neighbors,
 * <code>neighborN</code>, <code>neighborE</code>, <code>neighborS</code>, and
 * <code>neighborW</code>. If any of these values are null, it means this cell
 * is on the border of the maze.
 *
 *
 */
public class MazeCell {

	private boolean north, east, south, west;
	private boolean visited, examined;
	private MazeCell neighborN, neighborE, neighborS, neighborW;
	private Random generator;
	// private MazeCell currentCell;
	public int rank;
	// private MazeCell cell;
	public MazeCell parent;

	/**
	 * Sets all the walls to <code>true</code> and initializes the random number
	 * generator.
	 */
	public MazeCell() {
		north = true;
		east = true;
		south = true;
		west = true;
		generator = new Random();
		visited = false;
		examined = false;
		// currentCell = new MazeCell();
	}

	/**
	 * Sets the visited flag to <code>true</code>.
	 */
	public void visit() {
		visited = true;
	}

	/**
	 * Returns whether or not this cell has been visited.
	 * 
	 * @return <code>true</code> if the cell has been visited.
	 */
	public boolean visited() {
		return visited;
	}

	/**
	 * Sets the examined flag to <code>true</code>.
	 */
	public void examine() {
		examined = true;
	}

	/**
	 * Returns whether or not this cell has been examined.
	 * 
	 * @return <code>true</code> if the cell has been examined.
	 */
	public boolean examined() {
		return examined;
	}

	/**
	 * Sets the pointers to the neighbors of this cell. If a pointer is null,
	 * that means this cell is along the border of the maze.
	 * 
	 * @param n
	 *            The north neighbor of this cell.
	 * @param e
	 *            The east neighbor of this cell.
	 * @param s
	 *            The south neighbor of this cell.
	 * @param w
	 *            The west neighbor of this cell.
	 */
	public void setNeighbors(MazeCell n, MazeCell e, MazeCell s, MazeCell w) {
		neighborN = n;
		neighborE = e;
		neighborS = s;
		neighborW = w;
		// neighbors.add(neighborN);
		// neighbors.add(neighborS);
		// neighbors.add(neighborE);
		// neighbors.add(neighborW);

	}

	/**
	 * Sets whether or not there are walls up to the north, east, south, and
	 * west of this cell.
	 * 
	 * @param north
	 *            <code>true</code> if there's a wall on the north side of the
	 *            cell.
	 * @param east
	 *            <code>true</code> if there's a wall on the east side of the
	 *            cell.
	 * @param south
	 *            <code>true</code> if there's a wall on the south side of the
	 *            cell.
	 * @param west
	 *            <code>true</code> if there's a wall on the west side of the
	 *            cell.
	 */
	public void setWalls(boolean north, boolean east, boolean south, boolean west) {
		this.north = north;
		this.east = east;
		this.south = south;
		this.west = west;
	}

	/**
	 * Returns whether or not this cell has all its walls up.
	 * 
	 * @return <code>true</code> if all walls are up.
	 */
	public boolean hasAllWalls() {
		if(!north) {
			return false;
		}
		if(!south) {
			return false;
		}
		if(!east) {
			return false;
		}
		if(!west) {
			return false;
		}
//		if (this.north == true && this.south == true && this.east == true && this.west == true) {
//			return true;
//		} else {
//			return false;
//		}
		return true;

	}

	/**
	 * Returns whether or not this cell has its north wall up.
	 * 
	 * @return <code>true</code> if the cell's north wall is up.
	 */
	public boolean north() {
		if (north == true) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Returns whether or not this cell has its south wall up.
	 * 
	 * @return <code>true</code> if the cell's south wall is up.
	 */
	public boolean south() {
		if (south == true) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Returns whether or not this cell has its east wall up.
	 * 
	 * @return <code>true</code> if the cell's east wall is up.
	 */
	public boolean east() {
		if (east == true) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Returns whether or not this cell has its west wall up.
	 * 
	 * @return <code>true</code> if the cell's west wall is up.
	 */
	public boolean west() {
		if (west == true) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Gets the accessible neighbors of this cell. Returns an array of those
	 * neighbors. The length of the array is the number of neighbors this cell
	 * has.
	 * 
	 * @return An array with the neighbors contained within it.
	 */
	public MazeCell[] getNeighbors() {
		ArrayList<MazeCell> theseNeighbors = new ArrayList<MazeCell>();
		// if(!north) {
		// neighbors.add(neighborN);
		// }
		//
		// if(!south) {
		// neighbors.add(neighborS);
		// }
		// if(!east) {
		// neighbors.add(neighborE);
		// }
		// if(!west) {
		// neighbors.add(neighborW);
		// }

		if (neighborN != null && north ) {
			theseNeighbors.add(this.neighborN);
		}

		if (neighborS != null && south) {
			theseNeighbors.add(this.neighborS);
		}
		if (neighborE != null && east) {
			theseNeighbors.add(this.neighborE);
		}

		if (neighborW != null && west) {
			theseNeighbors.add(this.neighborW);
		}

		int countNeighbors = theseNeighbors.size();
//		System.out.println("Current size " + theseNeighbors.size());

		MazeCell[] arrNeighbors = new MazeCell[countNeighbors];

		for (int i = 0; i < theseNeighbors.size(); i++) {
			arrNeighbors[i] = theseNeighbors.get(i);

		}

		return arrNeighbors;
	}
	
	/**
	 * Gets the accessible neighbors of this cell. Returns an array of those
	 * neighbors. The length of the array is the number of neighbors this cell
	 * has.
	 * 
	 * @return An array with the neighbors contained within it.
	 */
	public MazeCell[] getNeighborsHelper() {
		ArrayList<MazeCell> theseNeighbors = new ArrayList<MazeCell>();
		// if(!north) {
		// neighbors.add(neighborN);
		// }
		//
		// if(!south) {
		// neighbors.add(neighborS);
		// }
		// if(!east) {
		// neighbors.add(neighborE);
		// }
		// if(!west) {
		// neighbors.add(neighborW);
		// }

		if (neighborN != null && !north ) {
			theseNeighbors.add(this.neighborN);
		}

		if (neighborS != null && !south) {
			theseNeighbors.add(this.neighborS);
		}
		if (neighborE != null && !east) {
			theseNeighbors.add(this.neighborE);
		}

		if (neighborW != null && !west) {
			theseNeighbors.add(this.neighborW);
		}

		int countNeighbors = theseNeighbors.size();
//		System.out.println("Current size " + theseNeighbors.size());

		MazeCell[] arrNeighbors = new MazeCell[countNeighbors];

		for (int i = 0; i < theseNeighbors.size(); i++) {
			arrNeighbors[i] = theseNeighbors.get(i);

		}

		return arrNeighbors;
	}

	/**
	 * Knocks down the wall between this cell and the neighbor cell. The
	 * neighbor cell must actually be a neighbor of this cell. This method is
	 * used in conjunction with <code>neighborWithWalls</code>.
	 * 
	 * @param neighbor
	 *            The neighboring cell; must be one of the neighbors set in
	 *            <code>setNeighbors</code>.
	 */
	public void knockDownWall(MazeCell neighbor) {
		// neighbor.visit();
		if (this.neighborN == neighbor) {
			this.north = false;
			neighbor.south = false;
		}
		else if (this.neighborS == neighbor) {
			this.south = false;
			neighbor.north = false;
		}
		else if (this.neighborE == neighbor) {
			this.east = false;
			neighbor.west = false;
		}
		else if (this.neighborW == neighbor) {
			this.west = false;
			neighbor.east = false;
		}
		// will require you to change values for both this and neighbor.
	}

	/**
	 * Use this function whenever you want to randomly pick one of the
	 * neighbours
	 * 
	 * @return - random choice of one of the neighbours.
	 */
	public MazeCell getRandomNeighbor() {

		int randomNumber;
		MazeCell[] neighborsHelper = getNeighbors();

		int neighborCount = neighborsHelper.length;
		
		if (neighborCount == 0) {
			return null;
		}

		randomNumber = generator.nextInt(neighborCount);

		MazeCell randomNeighbor;

		randomNeighbor = neighborsHelper[randomNumber];

		return randomNeighbor;
	}

	/**
	 * Returns a neighbor that has all its walls intact.
	 * 
	 * @return Neighbor with all its walls intact.
	 */
	public MazeCell neighborWithWalls() {
		MazeCell myCell = null;
		MazeCell neighborWithAllWalls[] = getNeighbors();
		for (int i = 0; i < neighborWithAllWalls.length; i++) {
			if (neighborWithAllWalls[i].hasAllWalls()) {
				myCell = neighborWithAllWalls[i];
			}
		}
		return myCell;

	}

}

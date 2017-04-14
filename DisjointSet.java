package maze;

import java.util.ArrayList;

public class DisjointSet {

// TODO - write all the methods of this class
//	public DisjointSet(MazeCell cell) {
//		this.cell = cell;
//		parent = null;
//		rank = 0;
//	}

	/**
	 * make a set out of the cells in the maze
	 * 
	 * @param maze
	 */
	public void makeSet(MazeCell[][] maze) {
		MazeCell mazeCell;
		int helper = 0;
		int length = maze.length;
		int length2 = maze[helper].length;
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length2; j++) {
				maze[i][j].parent = maze[i][j];
				maze[i][j].rank = 0;
			}
		}

	}

	/**
	 * Create the union of the sets that contain cell1 and cell2. If the two
	 * cells are in the same set, nothing changes, else create the new set as a
	 * union. Please see the union-find algorithm.
	 * 
	 * @param cell1
	 * @param cell2
	 */
	public void union(MazeCell cell1, MazeCell cell2) {
		MazeCell findCell1 = find(cell1);
		MazeCell findCell2 = find(cell2);
		
		if(findCell1 != findCell2) {
			if(findCell1.rank >= findCell2.rank) {
				if(findCell1.rank > findCell2.rank) {
					findCell2.parent = findCell1;
				} else {
					findCell2.rank ++;
					findCell1.parent = findCell2;
				}
			} else {
				findCell1.parent = findCell2;
			}
		} 
	
	}

	/**
	 * Find the set that the cell is a part of. While finding the set, do the
	 * path compression as well.
	 * 
	 * @param cell
	 * @return
	 */
	public MazeCell find(MazeCell cell) {
		//TODO add path compression
		ArrayList<MazeCell> path = new ArrayList<MazeCell>();
		
		while (cell.parent != cell) {
			path.add(cell);
			cell = cell.parent;
		}
		for (MazeCell mazeCell : path) {
			mazeCell.parent = cell;
		}
		return cell;
	}
}

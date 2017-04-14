package maze;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MazeCellTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMazeCell() {
		fail("Not yet implemented");
	}

	@Test
	public void testVisit() {
		fail("Not yet implemented");
	}

	@Test
	public void testVisited() {
		fail("Not yet implemented");
	}

	@Test
	public void testExamine() {
		fail("Not yet implemented");
	}

	@Test
	public void testExamined() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetNeighbors() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetWalls() {
		fail("Not yet implemented");
	}

	@Test
	public void testHasAllWalls() {
		fail("Not yet implemented");
	}

	@Test
	public void testNorth() {
		fail("Not yet implemented");
	}

	@Test
	public void testSouth() {
		fail("Not yet implemented");
	}

	@Test
	public void testEast() {
		fail("Not yet implemented");
	}

	@Test
	public void testWest() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetNeighbors() {
		MazeCell mycell = new MazeCell();
		mycell.setWalls(true, true, false, false);
		assertEquals(mycell.getNeighbors().length, 2);
		
	}

	@Test
	public void testKnockDownWall() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetRandomNeighbor() {
		fail("Not yet implemented");
	}

	@Test
	public void testNeighborWithWalls() {
		fail("Not yet implemented");
	}

}

/**
 * Conway's Game of Life runner.
 */
public final class Runner {

  public static int[][] getNewWorld(int[][] world) {
    int[][] newWorld = new int[world.length][world[0].length];
    for (int rowIndex = 1; rowIndex < world.length - 1; rowIndex++) {
      for (int columnIndex = 1; columnIndex < world[0].length - 1; columnIndex++) {
        int currentState = world[rowIndex][columnIndex];
        int neighboursCount = getNeighboursCount(world, rowIndex, columnIndex);
        newWorld[rowIndex][columnIndex] = getNewState(currentState, neighboursCount);
      }
    }
    return newWorld;
  }

  public static int getNeighboursCount(int[][] world, int rowIndex, int columnIndex) {

      final int[][] OFFSETS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {-1, 1}, {1, -1}, {-1, -1}};

      int count = 0;
      for (int[] offset : OFFSETS) {
        int newRowIndex = rowIndex + offset[0];
        int newColumnIndex = columnIndex + offset[1];
        count += world[newRowIndex][newColumnIndex];
      }
    return count;
  }

  public static int getNewState(int currentState, int numNeighbors) {
    if (currentState == 1) {
      return numNeighbors == 2 || numNeighbors == 3 ? 1 : 0;
    } else {
      return numNeighbors == 3 ? 1 : 0;
    }
  }
}

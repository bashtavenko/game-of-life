/**
 * Conway's Game of Life runner.
 */
public final class Runner {

  public static int[][] getNewWorld(int[][] world) {
    int[][] newWorld = new int[world.length][world[0].length];
    for (int rowIndex = 0; rowIndex < world.length; rowIndex++) {
      for (int columnIndex = 0; columnIndex < world[0].length; columnIndex++) {
        int currentState = world[rowIndex][columnIndex];
        int neighboursCount = getNeighborsCount(world, rowIndex, columnIndex);
        newWorld[rowIndex][columnIndex] = getNewState(currentState, neighboursCount);
      }
    }
    return newWorld;
  }

  public static int getNeighborsCount(int[][] world, int rowIndex, int columnIndex) {

      final int[][] OFFSETS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {-1, 1}, {1, -1}, {-1, -1}};

      int count = 0;
      for (int[] offset : OFFSETS) {
        int newRowIndex = rowIndex + offset[0];
        int newColumnIndex = columnIndex + offset[1];
        if (newRowIndex >= 0
                && newRowIndex < world.length && newColumnIndex >= 0
                && newColumnIndex < world[0].length) {
          count += world[newRowIndex][newColumnIndex];
        }
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

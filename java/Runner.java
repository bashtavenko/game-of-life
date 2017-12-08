/**
 * Conway's Game of Life runner.
 */
public final class Runner {

  public static int[][] getNewWorld(int[][] world) {
    int[][] newWorld = new int[world.length][world[0].length];
    for (int rowIndex = 1; rowIndex < world.length - 1; rowIndex++) {
      for (int columnIndex = 1; columnIndex < world[0].length - 1; columnIndex++) {
        int neighboursCount = getNeighboursCount(world, rowIndex, columnIndex);
        int currentState = world[rowIndex][columnIndex];
        int newState = getNewState(currentState, neighboursCount);
        newWorld[rowIndex][columnIndex] = newState;
      }
    }
    return newWorld;
  }

  public static int getNeighboursCount(int[][] world, int rowIndex, int columnIndex) {

      int[][] offsets = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {-1, 1}, {1, -1}, {-1, -1}};

      int count = 0;
      for (int[] offset : offsets) {
        int newRowIndex = rowIndex + offset[0];
        int newColumnIndex = columnIndex + offset[1];
        if (world[newRowIndex][newColumnIndex] == 1) {
          count++;
        }
      }
    return count;
  }

  public static int getNewState(int isLive, int numNeighbors) {
    if (isLive == 1) {
      return numNeighbors == 2 || numNeighbors == 3 ? 1 : 0;
    } else {
      return numNeighbors == 3 ? 1 : 0;
    }
  }
}

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import static com.google.common.truth.Truth.assertThat;

@RunWith(JUnit4.class)
public class RunnerTest {
  @Test
  public void testGetNeighborsCount() {
    final int[][] world = {
            {0, 0, 0, 0, 0},
            {0, 1, 1, 0, 0},
            {0, 0, 1, 0, 0},
            {0, 0, 1, 1, 0},
            {0, 0, 0, 0, 1}};
    assertThat(Runner.getNeighborsCount(world, 2, 2)).isEqualTo(4);
    assertThat(Runner.getNeighborsCount(world, 1, 1)).isEqualTo(2);
    assertThat(Runner.getNeighborsCount(world, 2, 1)).isEqualTo(4);
    assertThat(Runner.getNeighborsCount(world, 3, 3)).isEqualTo(3);
    assertThat(Runner.getNeighborsCount(world, 3, 2)).isEqualTo(2);
  }

  @Test
  public void testGetNewState() {
    assertThat(Runner.getNewState(1, 1)).isEqualTo(0);
    assertThat(Runner.getNewState(1, 0)).isEqualTo(0);
    assertThat(Runner.getNewState(0, 0)).isEqualTo(0);
    assertThat(Runner.getNewState(0, 1)).isEqualTo(0);
    assertThat(Runner.getNewState(1, 2)).isEqualTo(1);
    assertThat(Runner.getNewState(0, 3)).isEqualTo(1);
    assertThat(Runner.getNewState(0, 2)).isEqualTo(0);
  }

  @Test
  public void testGetNewWorld() {
    final int[][] worldStart = {
            {0, 0, 1, 0, 0},
            {0, 0, 1, 0, 0},
            {0, 0, 1, 0, 0},
            {0, 0, 1, 0, 0},
            {0, 0, 1, 0, 0}};
    final int[][] worldEnd = {
            {0, 0, 0, 0, 0},
            {0, 1, 1, 1, 0},
            {0, 1, 1, 1, 0},
            {0, 1, 1, 1, 0},
            {0, 0, 0, 0, 0}};

    assertThat(Runner.getNewWorld(worldStart)).isEqualTo(worldEnd);
  }

  @Test
  public void testGetNewWorld3() {
    final int[][] world1Start = {
            {0, 0, 1},
            {1, 1, 0},
            {0, 1, 0}};
    final int[][] world1End = {
            {0, 1, 0},
            {1, 1, 1},
            {1, 1, 0}};
    final int[][] world2Start = {
            {0, 1, 0},
            {0, 1, 0},
            {0, 1, 0}};
    final int[][] world2End = {
            {0, 0, 0},
            {1, 1, 1},
            {0, 0, 0}};

    assertThat(Runner.getNewWorld(world1Start)).isEqualTo(world1End);
    assertThat(Runner.getNewWorld(world2Start)).isEqualTo(world2End);
  }
}
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import static com.google.common.truth.Truth.assertThat;

@RunWith(JUnit4.class)
public class RunnerTest {
  private static final int[][] world = {{0, 0, 0, 0, 0},
                                        {0, 1, 1, 0, 0},
                                        {0, 0, 1, 0, 0},
                                        {0, 0, 1, 1, 0},
                                        {0, 0, 0, 0, 1}};
  private static final int[][] worldStart = {{0, 0, 1, 0, 0},
                                             {0, 0, 1, 0, 0},
                                             {0, 0, 1, 0, 0},
                                             {0, 0, 1, 0, 0},
                                             {0, 0, 1, 0, 0}};
  private static final int[][] worldEnd = {{0, 0, 0, 0, 0},
                                           {0, 1, 1, 1, 0},
                                           {0, 1, 1, 1, 0},
                                           {0, 1, 1, 1, 0},
                                           {0, 0, 0, 0, 0}};
  private static final int[][] world3Start = {{0, 0, 1},
                                              {1, 1, 0},
                                              {0, 1, 0}};
  private static final int[][] world3End = {{0, 1, 0},
                                            {1, 1, 1},
                                            {1, 1, 0}};

  @Test
  public void testGetNeighboursCount() {
    assertThat(Runner.getNeighboursCount(world, 2, 2)).isEqualTo(4);
    assertThat(Runner.getNeighboursCount(world, 1, 1)).isEqualTo(2);
    assertThat(Runner.getNeighboursCount(world, 2, 1)).isEqualTo(4);
    assertThat(Runner.getNeighboursCount(world, 3, 3)).isEqualTo(3);
    assertThat(Runner.getNeighboursCount(world, 3, 2)).isEqualTo(2);
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
    int[][] result = Runner.getNewWorld(worldStart);
    assertThat(result).isEqualTo(worldEnd);
  }

  @Test
  public void testGetNewWorld3() {
    int[][] result = Runner.getNewWorld(world3Start);
    assertThat(result).isEqualTo(world3End);
  }
}

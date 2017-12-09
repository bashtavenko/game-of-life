"""Game of life.
"""

DEAD, LIVE = range(2)


def compute_new_world(world):
  """Returns new world based on the given one."""

  def init_new_world():
    """Initializes empty new world based on the given world size."""
    return [[0 for _ in range(len(world))] for _ in range(len(world[0]))]

  new_world = init_new_world()
  for row_index, row in enumerate(world):
    for column_index, cell_state in enumerate(row):
      num_neighbours = get_neighbours_count(world, row_index, column_index)
      new_state = get_new_state(cell_state, num_neighbours)
      new_world[row_index][column_index] = new_state

  return new_world


def get_neighbours_count(world, row, column):
  """Returns count of neighbours for the given cell."""
  count = 0
  for offset in ((1, 0), (-1, 0), (0, 1), (0, -1), (1, 1), (-1, 1), (1, -1),
                 (-1, -1)):
    new_row, new_column = row + offset[0], column + offset[1]
    if (0 <= new_row < len(world) and 0 <= new_column < len(world[0]) and
        world[new_row][new_column] == 1):
      count += 1
  return count


def get_new_state(is_live, num_neighbours):
  """Returns state for the given cell and number of neighbours."""
  if is_live:
    return LIVE if num_neighbours == 2 or num_neighbours == 3 else DEAD
  else:
    return LIVE if num_neighbours == 3 else DEAD

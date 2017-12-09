"""Tests for gol."""
import unittest

import gol

DEAD, LIVE = (0, 1)

class GolTest(unittest.TestCase):

  def setUp(self):
    super(GolTest, self).setUp()
    self.world_1_start = [[0, 0, 0, 0, 0],
                          [0, 0, 0, 1, 0],
                          [0, 1, 1, 0, 0],
                          [0, 0, 1, 0, 0],
                          [0, 0, 0, 0, 0]]
    self.world_1_end = [[0, 0, 0, 0, 0],
                        [0, 0, 0, 0, 0],
                        [0, 1, 1, 0, 0],
                        [0, 0, 1, 0, 0],
                        [0, 0, 0, 0, 0]]
    self.world_2_start = [[0, 0, 0],
                          [0, 1, 0],
                          [0, 1, 0]]
    self.world_2_end = [[0, 0, 0],
                        [0, 0, 0],
                        [0, 0, 0]]
    self.world_3_start = [[0, 0, 1],
                          [1, 1, 0],
                          [0, 1, 0]]
    self.world_3_end = [[0, 1, 0],
                        [1, 1, 1],
                        [1, 1, 0]]
    self.world_4_start = [[0, 1, 0],
                          [0, 1, 0],
                          [0, 1, 0]]
    self.world_4_end = [[0, 0, 0],
                        [1, 1, 1],
                        [0, 0, 0]]

  def testWillBeLive(self):
    self.assertEqual(DEAD, gol.get_new_state(LIVE, num_neighbours=1))
    self.assertEqual(DEAD, gol.get_new_state(LIVE, num_neighbours=0))
    self.assertEqual(LIVE, gol.get_new_state(LIVE, num_neighbours=3))
    self.assertEqual(DEAD, gol.get_new_state(LIVE, num_neighbours=4))

  def testGetNeighboursCount(self):
    self.assertEqual(3, gol.get_neighbours_count(self.world_1_start, 1, 2))
    self.assertEqual(1, gol.get_neighbours_count(self.world_1_start, 1, 3))
    self.assertEqual(0, gol.get_neighbours_count(self.world_1_start, 4, 0))
    self.assertEqual(0, gol.get_neighbours_count(self.world_1_start, 5, 0))
    self.assertEqual(1, gol.get_neighbours_count(self.world_1_start, 4, 1))

  def testCompute(self):
    result = gol.compute_new_world(self.world_2_start)
    self.assertListEqual(self.world_2_end, result)

    result = gol.compute_new_world(self.world_3_start)
    self.assertListEqual(self.world_3_end, result)

    result = gol.compute_new_world(self.world_4_start)
    self.assertListEqual(self.world_4_end, result)


if __name__ == '__main__':
  unittest.main()

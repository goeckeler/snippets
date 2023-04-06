package game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameOfLiveTest {

  @Test
  void shouldHaveTwoNeighbours() {
     boolean[][] game = GameOfLife.presetGeneration(GameOfLife.LINE);
     // center piece
     assertEquals(2, GameOfLife.countLivingNeighbors(game, 1, 1));
     // corners
     assertEquals(2, GameOfLife.countLivingNeighbors(game, 0, 0));
     assertEquals(2, GameOfLife.countLivingNeighbors(game, 2, 2));
     assertEquals(2, GameOfLife.countLivingNeighbors(game, 0, 2));
     assertEquals(2, GameOfLife.countLivingNeighbors(game, 2, 0));
  }

  @Test
  void shouldHaveThreeNeighbours() {
    boolean[][] game = GameOfLife.presetGeneration(GameOfLife.LINE);
    assertEquals(3, GameOfLife.countLivingNeighbors(game, 1, 0));
    assertEquals(3, GameOfLife.countLivingNeighbors(game, 1, 2));
  }

  @Test
  void shouldHaveOneNeighbour() {
    boolean[][] game = GameOfLife.presetGeneration(GameOfLife.LINE);
    assertEquals(1, GameOfLife.countLivingNeighbors(game, 0, 1));
    assertEquals(1, GameOfLife.countLivingNeighbors(game, 2, 1));
  }

}

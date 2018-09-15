package pacman;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ScenarioState;

public class PacManStage extends Stage<PacManStage>
{
  @ScenarioState
  private Grid grid;

  @ScenarioState
  private PacMan pacMan;

  private int initialDots = 20;

  public PacManStage a_new_grid() {
    grid = new Grid(initialDots);
    return this;
  }

  public PacManStage a_pacman() {
    pacMan = new PacMan();
    return this;
  }

  public void pacman_starts() {
    grid.startWithPacMan(pacMan);

  }

  public PacManStage grid_is_filled_with_dots() {
    assertThat(grid.currentDots(), equalTo(initialDots));
    return this;
  }


  public PacManStage pacman_heads_west() {
    assertThat(pacMan.currentDirection(), equalTo(Direction.WEST));
    return this;
  }
}

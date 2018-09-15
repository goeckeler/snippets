package pacman;

import org.junit.Test;

import com.tngtech.jgiven.junit.SimpleScenarioTest;

public class PacManTest extends SimpleScenarioTest<PacManStage>
{
  @Test
  public void shouldBeOnAGrid() {
    given().a_new_grid().and().a_pacman();
    when().pacman_starts();
    then().grid_is_filled_with_dots();
  }

  @Test
  @PacManTag
  public void shouldHaveDirection() {
    given().a_new_grid().and().a_pacman();
    when().pacman_starts();
    then().pacman_heads_west();
  }
}

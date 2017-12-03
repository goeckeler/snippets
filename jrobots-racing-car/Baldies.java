import jrobots.landscape.TerrainType;
import jrobots.simulation.simulationObjects.JRobot2016A;
import jrobots.utils.Angle;

/**
 * He is the baldest of all race pilots.
 */
public class Baldies
  extends JRobot2016A
{
  private static final long serialVersionUID = 1L;

  Angle driveDir = Angle.EAST;
  TerrainType terrain = null;
  boolean star = false;
  boolean port = false;
  int attempts = 4;

  @Override
  protected void init() {
    super.init();
    this.setAutopilot(driveDir, 1);
  }

  @Override
  protected void actions() {
    terrain = this.getCurrentTerrain();

    if (terrain != TerrainType.ROAD) {
      if (!star) {
        driveDir = driveDir.add(new Angle(12.25, "d"));
        if (attempts-- == 0) {
          star = true;
          attempts = 4;
          // drive straight again
          driveDir = driveDir.add(new Angle(-45.0, "d"));
        }
      } else if (!port) {
        driveDir = driveDir.add(new Angle(-12.25, "d"));
        if (attempts-- == 0) {
          port = true;
          attempts = 4;
        }
      } else {
        star = false;
        port = false;
      }

      this.setAutopilot(driveDir, 1);
    }
  }
}

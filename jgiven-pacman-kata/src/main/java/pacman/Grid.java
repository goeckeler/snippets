package pacman;

public class Grid
{
  private int dots;
  private PacMan pacMan;

  public Grid(int dots) {
    this.dots = dots;
  }

  public void startWithPacMan(PacMan pacMan) {
    this.pacMan = pacMan;
  }

  public int currentDots() {
    return dots;
  }
}

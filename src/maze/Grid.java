package maze;

public interface Grid {
	public int getSize();
	public boolean isValidMove(Tile tile, int direction);
}
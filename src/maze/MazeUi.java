package maze;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class MazeUi extends JPanel {
    private Maze m;
    private Image player;
    private int playerX;
    private int playerY;
    private int size;
    private GameInterface gameController;
    private ArrayList<ArrayList<Box>> boxes;
    
	public MazeUi(int size, Maze m, GameInterface gameController) {
        this.m = m;
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		this.boxes = new ArrayList<ArrayList<Box>>();
        this.size = size;
        c.ipadx = 0;
        c.ipady = 0;
        c.weightx = 0;
        c.weighty = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridy = 0;
        this.playerX = 0;
        this.playerY = 0;
        this.gameController = gameController;
        
        //creating new player
        m.getGrid().getTiles().get(0).get(0).setPlayer(true);
        player = m.getPlayer();
        
        for(int i = 0; i < size; i++) {
            boxes.add(i, new ArrayList<Box>());
        }
        for(int i = size-1; i > -1; i--) {
        	
        	for(int j = 0; j < size; j++) {
                c.gridx = j;
                
                Tile t = m.getGrid().getTiles().get(j).get(i);
                //adding finish tile 
                boolean isFinal = false;
                if((j == size-1) && (i==size-1)){
                	isFinal = true;
                }
                /*Image player = null;
                if(t.hasPlayer()){
                	//System.out.println("x coord = " + i + " y coord = " + j);
                	player = m.getPlayer();
                }
                */
        		Box b = new Box(t.hasWall(t.WEST), t.hasWall(t.EAST), t.hasWall(t.NORTH), t.hasWall(t.SOUTH), player, isFinal);
        		this.add(b,c);
                boxes.get(i).add(b);
        	}
            c.gridy++;
        }
        boxes.get(playerY).get(playerX).activate();
        this.validate();
        this.repaint();
	}
	
    public void move(int direction) {
        boxes.get(playerY).get(playerX).deactivate();
        if(direction == Tile.NORTH) {
            playerY++;
        }
        else if(direction == Tile.SOUTH) {
            playerY--;
        }
        else if(direction == Tile.EAST) {
            playerX++;
        }
        else if(direction == Tile.WEST) {
            playerX--;
        }
        if(playerX == size -1 && playerY == size -1) {
            JOptionPane.showMessageDialog(null, "You Win!");
            gameController.restart();
        }
        boxes.get(playerY).get(playerX).activate();
    }
}

package maze;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Images {
	
	//the image of player 
		private Image player; 
		//the image of the grass
		private Image mazeBackground;
		//the image of the walls 
		private Image wallImage;
		//the image of the collectables
		private Image collectables; 
		
	public Images(int theme){
      if(theme == 1){
		   ImageIcon img = new ImageIcon("theme1char.png");
		    this.player = img.getImage();

		    img = new ImageIcon("theme1tile.png");
		    this.mazeBackground = img.getImage();

		    img = new ImageIcon("theme1wall.jpg");
		    this.wallImage = img.getImage();

		    img = new ImageIcon("theme1pickup.png");
		    this.collectables = img.getImage();  
      } else if(theme == 2){
		    ImageIcon img = new ImageIcon("Superman.png");
		    this.player = img.getImage();

		    img = new ImageIcon("greengrass.JPG");
		    this.mazeBackground = img.getImage();

		    img = new ImageIcon("brickwall.JPG");
		    this.wallImage = img.getImage();

		    img = new ImageIcon("moneybags.JPG");
		    this.collectables = img.getImage();    
      }
      else if(theme == 3){
		   ImageIcon img = new ImageIcon("Superman.png");
		    this.player = img.getImage();

		    img = new ImageIcon("greengrass.JPG");
		    this.mazeBackground = img.getImage();

		    img = new ImageIcon("brickwall.JPG");
		    this.wallImage = img.getImage();

		    img = new ImageIcon("moneybags.JPG");
		    this.collectables = img.getImage();  
      }

	}
	
	public Image getPlayer(){
		return this.player;
	}
	public Image getWallImage(){
		return this.wallImage;
	}
	
	public Image getBackground(){
		return this.mazeBackground;
	}
	
	public Image getCollectables(){
		return this.collectables;
	}
}

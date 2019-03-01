package com.rahul.dev.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Game extends JPanel{
	
	private Image image;
	private int x = 0;
	private int y = 0;
    boolean move;
	static boolean up,down,right,left,r,l;
    
	ImageIcon icon;
	
	public Game() {
		
		loadImage();
		 this.setFocusable(true);
         addKeyListener(new Commands());
		
	}
	
	
	
	public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.black);
        g.drawImage(image, x, y, this); 
        if(right) {
        	if(x>436) {
        		x = 436;
            	
        	}else {
        		x++;
        	}
        	loadImage();
        }
        else if(left) {
        	if(x<0) {
        		x=0;;
        		
        	}else {
        		x--;
        	}
        	loadImage();
        }
        else if(down) {
        	if(y>436) {
        		y = 410;
        		
        	}else {
        		y++;
        	}
        	loadImage();
        }
        else if(up) {
        	if(y<0) {
        		y = 0;
        		
        	}else {
        		y--;
        	}
        	loadImage();
        }
        else if(r) {
        	
        	BufferedImage im = toBufferedImage(image);
        	AffineTransform at = AffineTransform.getTranslateInstance(x,y);
            at.rotate(Math.toRadians(90),im.getWidth()/2,im.getHeight()/2);
            Graphics2D gs = (Graphics2D)g;
            gs.drawImage(im, at, null);
        	
        }
    
        repaint();
        
	}
	
   public void loadImage() {
    	URL url = Game.class.getResource("pp.jpg");
    	icon = new ImageIcon(url);
        image = icon.getImage();
    }
   
   public class Commands implements KeyListener {

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			
			if (e.getKeyCode() == e.VK_DOWN) {
				Game.down = true;
			}
	        if (e.getKeyCode() == e.VK_UP) {
	        	Game.up = true;
	        }
	        if (e.getKeyCode() == e.VK_RIGHT) {
	        	Game.right = true;
	        }
	        if (e.getKeyCode() == e.VK_LEFT) {
	        	Game.left = true;
	        }
	        if (e.getKeyCode() == e.VK_R) {
	        	Game.r = true;
	        }
	       
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
			if (e.getKeyCode() == e.VK_DOWN) {
				Game.down = false;
			}
	        if (e.getKeyCode() == e.VK_UP) {
	        	Game.up = false;
	        }
	        if (e.getKeyCode() == e.VK_RIGHT) {
	        	Game.right = false;
	        }
	        if (e.getKeyCode() == e.VK_LEFT) {
	        	Game.left = false;
	        }
	        
	        	
		}

   }
   
   public static BufferedImage toBufferedImage(Image img)
   {
       
       BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
       Graphics2D b = bimage.createGraphics();
       b.drawImage(img, 0, 0, null);
       b.dispose();
       return bimage;
   }
}

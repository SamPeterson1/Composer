

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;


public class CCanvas extends Canvas{
	private static final long serialVersionUID = -7730932406995835971L;
	MusicStaff staff;
	public CCanvas() {
		this.setBackground(Color.GRAY);
	}
	public void draw() {
		BufferedImage image;
		Graphics g;
		Image print = new ImageIcon(getClass().getResource("/assets/iu.png")).getImage();
		image = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_ARGB);
		g = image.getGraphics();	
		for(int i = 0; i < 20; i ++) {
			for(int j = 0; j < 13; j ++) {
				if(staff.getNote(i, j) == 1) {
					g.setColor(Color.BLACK);
					g.fillRect(i * 100 + 50 , j * 30 + 50, 100, 30);
				} else {
					g.setColor(getBackground());
					g.fillRect(i * 100 + 50, j * 30 + 50, 100, 30);
					g.setColor(Color.BLACK);
					g.drawRect(i * 100 + 50, j * 30 + 50, 100, 30);
				}
			}
		}
		g.drawImage(print, 1000, 500, 200, 200, null);
		g.setColor(Color.BLUE);
		g.drawLine(50, 230, 2050, 230);
		g.drawLine(50, 260, 2050, 260);
		g.dispose();
		g = this.getGraphics();
		g.drawImage(image, 0, 0, null); 
	}
	public void setStaff(MusicStaff staff) {
		this.staff = staff;
	}
	public void addEventQueue(CEventQueue queue)  {

		this.addKeyListener(queue);
		this.addMouseListener(queue);
		this.addMouseMotionListener(queue);

		return;
	}
}


public class CMain {
	public static void main(String[] args) {
		CFrame frame = new CFrame();
		CCanvas canvas = new CCanvas();
		CEventQueue queue = new CEventQueue();
		CEvent event;
		MusicStaff staff = new MusicStaff();
		canvas.addEventQueue(queue);
		frame.addCanvas(canvas);
		canvas.setStaff(staff);
		while(true) {
			if(queue.isEventToProcess()) {
				event = queue.getEvent();
				if(event.getType() == CEvent.EVENT_MOUSE_BUTTON_PRESS & event.isMouseLeftButton()) {
					int x = event.getMouseX() - 50;
					int y = event.getMouseY() - 50;
					if(x >= 1000 & x < 1200 & y >= 500 & y <= 700 ){
						int[] i = staff.print();
						for(int i1 = 0; i1 < 20; i1 ++) {
							System.out.print(i[i1] + ", ");
						}
					} else if(x / 100 <= 19 & x / 100 >= 0 & y / 30 >= 0 & y / 30 <= 12){
						staff.toggleNote(x / 100, y / 30);
					} else {
						System.out.println(y / 30);
					}
				}
			}
			canvas.draw();
		}
	}
}

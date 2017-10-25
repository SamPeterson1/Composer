
public class MusicStaff {
	int[][] data = new int[12][20];
	public void toggleNote(int x, int y) {
		if(this.data[y][x] == 1) {
			this.data[y][x] = 0;
		} else {
			this.data[y][x] = 1;
		}
	}
	public int getNote(int x, int y) {
		return this.data[y][x];
	}
	public int[] print() {
		int[] retval = new int[20];
		for(int i = 0; i < 20; i ++) {
			for(int j = 0; j < 12; j ++) {
				if(this.data[j][i] == 1) {
					retval[i] = 6 - j;
					if(retval[i] <= 0) {
						retval[i] --;
					}
				}
			}
		}
		return retval;
	}
}

package field;

import java.util.ArrayList;

import cell.Cell;

public class Field {
	
	
	private int width;
	private int height;
	private Cell[][] field;
	
	public Field(int width, int height) {
		this.width = width;
		this.height = height;
		field = new Cell[height][width];
	}
	
	public int getWidth() { return width; }
	public int getHeight() { return height; }
	
	public Cell place(int row, int col, Cell o) {
		Cell ret = field[row][col];
		field[row][col] = o;
		return ret;
	}
	
	public Cell get(int row, int col) {
		return field[row][col];
	}
	
	public Location[] getFreeNeighbour(int row, int col) {
		ArrayList<Location> list = new ArrayList<Location>();
		for ( int i=-1; i<2; i++ ) {
			for ( int j=-1; j<2; j++ ) {
				int r = row+i;
				int c = col+j;
				if ( r >-1 && r<height && c>-1 && c<width && !(r== row && c == col) && field[r][c] == null ) {
					list.add(new Location(r, c));
				}
			}
		}
		return list.toArray(new Location[list.size()]);
	}
	
	public void placeRandomAdj(int row, int col, Cell baby) 
	{
		Location[] freeLocs = getFreeNeighbour(row, col);
		if( freeLocs.length > 0 ) {
			int index = (int)(Math.random()*freeLocs.length);
			field[freeLocs[index].x][freeLocs[index].y] = baby;
		}
	}
	
	public Cell[] getNeighbour(int row, int col) {
		ArrayList<Cell> list = new ArrayList<Cell>();
		for ( int i=-1; i<2; i++ ) {
			for ( int j=-1; j<2; j++ ) {
				int r = row+i;
				int c = col+j;
				if ( r >-1 && r<height && c>-1 && c<width && !(r== row && c == col) ) {
					list.add(field[r][c]);
				}
			}
		}
		return list.toArray(new Cell[list.size()]);
	}
	
	public void move(int row, int col, Location loc) 
	{
		field[loc.x][loc.y] = field[row][col];
		field[row][col] = null;
	}
	
	//兔子的位置信息已经丢失，重新遍历周围的位置，如果某个位置管理的对象相同，就是fed，把该位置清空
	public void remove(int row, int col, Cell cell) 
	{
		for ( int i=-1; i<2; i++ ) {
			for ( int j=-1; j<2; j++ ) {
				int r = row+i;
				int c = col+j;
				if ( r >-1 && r<height && c>-1 && c<width && !(r== row && c == col) && field[r][c] == cell) 
				{field[r][c] =null;break;}
			}
		}
	}
	
	public void remove(int row, int col) 
	{
		field[row][col] = null;
	}
	
	public void clear() {
		for ( int i=0; i<height; i++ ) {
			for ( int j=0; j<width; j++ ) {
				field[i][j] = null;
			}
		}
	}
}

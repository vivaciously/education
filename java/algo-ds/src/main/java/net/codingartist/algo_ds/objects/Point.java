package net.codingartist.algo_ds.objects;

import java.io.Serializable;

public class Point implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int x;
	public int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public double eucledianDistance(Point another) {
		int sqX = (x - another.x) * (x - another.x);
		int sqY = (y - another.y) * (y - another.y);
		return Math.sqrt(sqX + sqY);
	}
	
	@Override
	public boolean equals(Object o) {
		if(o == this) {
			return true;
		}
		if(o == null || !(o instanceof Point) ) {
			return false;
		}
		Point other =(Point)o;
		return Integer.compare(this.x, other.x) == 0 && Integer.compare(this.y, other.y) == 0;
	}
	
	@Override
	public int hashCode() {
		int result = 17;
		result = 31 * result + this.x;
		result = 31 * result + this.y;
		return result;
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("[x: ");
		sb.append(x);
		sb.append(" y: ");
		sb.append(y);
		sb.append("]");
		return sb.toString();
	}
}

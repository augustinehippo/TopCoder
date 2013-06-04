import java.awt.List;
import java.util.ArrayList;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int m = 3;
		int bD = 3;
		int bX = 0;
		int bY = 0;
		bX +=   ((bD&1)- (2*(bD>>1))) *(m) * (bD&1);
		bY +=  (m) * ((bD&1)^1) * (((bD%2)^1) - (bD) );
		System.out.println(bX+" "+bY);

	}

}

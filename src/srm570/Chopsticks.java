package srm570;
import java.util.*;
public class Chopsticks {
    public int getmax(int[] l) {
        
    	int[] cnts = new int[100+1];
    	for (int i : l) {
			++cnts[i];
		}
    	
    	for (int i = 0; i < cnts.length; i++) {
			cnts[i] /= 2;
		}
    	
    	int C = 0;
    	for (int i = 0; i < cnts.length; i++) {
    		C += cnts[i];
		}
        return C;
    }

}

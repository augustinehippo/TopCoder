package srm581;
import java.util.*;
public class BlackAndWhiteSolitaire {
    public int minimumTurns(String a) {
        
    	int cW = 0;
    	int cB = 0;
    	for (int i = 0; i < a.length(); i++) {
			if(i%2==0){
				if(a.charAt(i)=='B')
					cW++;
			}
			else {
				if(a.charAt(i)=='W')
					cW++;
			}
					
			if(i%2==0){
				if(a.charAt(i)=='W')
					cB++;
			}
			else{
				if(a.charAt(i)=='B')
					cB++;
			}
		}
        return Math.min(cW, cB);
    }

}

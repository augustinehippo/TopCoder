package srm555;
import java.util.*;
public class CuttingBitString {
	TreeSet<String> set;
	HashMap<String,Long> hp;
    public int getmin(String S) {
        
    	System.out.println("------------------------------------------------");
    	System.out.println(S);
    	set = new TreeSet<String>();
    	hp = new HashMap<String, Long>();
    	long p5 = 1L;
    	for (p5 = 1; p5 < 1L<<53; p5*= 5) {
			String crt = Long.toBinaryString(p5);
    		set.add(crt);
		}
    	for (String l1 : set) {
			System.out.println(l1);
		}
    	long ans = go(S);
    	if(ans<500) return (int) ans;
    	
        return -1;
    }
	private long go(String s) {
		if(s.equals("101")) {
			System.out.println("hello");
		}
		if(s.length()==0) return 0;
		long min = 100000;
		if(hp.containsKey(s)) {
			return hp.get(s);
		}
		
		if(s.startsWith("0")){
			return 1000;
		}
		if(s.length()==1 && s.equals("1") ){
			return 1;
		} else if(s.equals("0")){return 1000;}
		
		for (int i = 1; i <= s.length(); i++) {
			String crt = s.substring(0,i);
			if(set.contains(crt)) {
				min = Math.min(min, 1+go(s.substring(i,s.length())));
			}
		}
		return min;
	}

}

package srm411;
import java.util.*;
public class SentenceDecomposition {
	HashSet<String> words;
	HashSet<String> srtwords;
	HashMap<String,String> map;
	int[] r;
	static final int INF = 1000000; 
    public int decompose(String sentence, String[] validWords) {
    	r = new int[sentence.length()+1];
    	Arrays.fill(r, -1);
        words = new HashSet<String>();
        srtwords = new HashSet<String>();
        map = new HashMap<String, String>();
        
        for (String iwrd : validWords) {
			words.add(iwrd);
			String srt = sorts(iwrd);
			map.put(srt, iwrd);
			
		}
        
        int n = go(sentence);
        if(n>=INF) return -1;
        return n;
    }
	private int go(String sentence) {
		
		int len = sentence.length();
		if(len==0) return 0;
		if(r[len]>-1) return r[len];
		int min = INF;
		for (int i = 0; i < sentence.length(); i++) {
			String sbs = sentence.substring(0,i+1);
			if(sbs.equals("wree")) {
				System.out.println("prob");
			}
			String sortedsbs = sorts(sbs);
			if(map.containsKey(sortedsbs)) {
				int diff = getdiff(sbs);
				min = Math.min(min, diff+go(sentence.substring(i+1,len)));
			}
		}
		r[len] = min;
		
		return min; 
	}
	private int getdiff(String sbs) {
		
		int min = INF;
		for (String iword : words) {
			if(sorts(iword).equals(sorts(sbs))) {
				int c = 0;
				for (int i = 0; i < sbs.length(); i++) {
					if(sbs.charAt(i)!=iword.charAt(i)) c++;
				}
				min = Math.min(min, c);
			}
		}
		
		return min;
	}
	private String sorts(String iwrd) {
		char[] arr= iwrd.toCharArray();
		Arrays.sort(arr);
		return new String(arr);
	}

}

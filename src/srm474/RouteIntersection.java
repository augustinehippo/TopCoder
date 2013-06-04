package srm474;
import java.util.*;
public class RouteIntersection {
    @SuppressWarnings("unchecked")
	public String isValid(int N, int[] or, String moves) {
        
    	HashSet<TreeMap<Integer, Integer>> visited = new HashSet<TreeMap<Integer, Integer>>();
    	TreeMap<Integer, Integer> current = new TreeMap<Integer, Integer>();
    	
    	for (int i = 0; i < or.length; i++) {
			current.put(or[i], 0);
		}
    	
    	visited.add( (TreeMap<Integer, Integer>) current.clone() );
    	
    	for (int i = 0; i < moves.length(); i++) {
			if(moves.charAt(i)=='+') {
				current.put(or[i], current.get(or[i])+1);
			}
			else {
				current.put(or[i], current.get(or[i])-1);
			}
			
			if(visited.contains(( TreeMap<Integer, Integer>) current.clone()) ) {
				return "NOT VALID";
			} 
			else{
				visited.add( (TreeMap<Integer, Integer>) current.clone());
			}
			
		}
    	
    	return "VALID";
        
    }

}


// Powered by FileEdit
// Powered by CodeProcessor

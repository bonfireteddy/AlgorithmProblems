package baekjoon;

import java.util.*;
import java.io.*;

public class Main2503 {
	
	static class Hint {
		String num;
		int strike;
		int ball;
		
		Hint(String num, int strike, int ball) {
			this.num = num;
			this.strike = strike;
			this.ball = ball;
		}
	}
	
    public static void main(String args[]) throws Exception {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int N = Integer.parseInt(br.readLine());
    	List<Hint> hints = new ArrayList<>();
    	
    	
    	for(int a = 0; a < N; a++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		String num = st.nextToken();
    		int s = Integer.parseInt(st.nextToken());
    		int b = Integer.parseInt(st.nextToken());
    				
    		hints.add(new Hint(num, s, b));		
    	}
    	
    	int count = 0;
    	
    	for(int i = 123; i < 987; i++) {
    		String candidate = String.valueOf(i);
    		
    		if(hasZeroOrDuplicate(candidate)) continue;
    		
    		boolean isValid = true;
    		
    		for(Hint hint : hints) {
    			int s = 0; int b = 0;
    			
    			for(int j = 0; j < 3; j++) {
    				if(candidate.charAt(j) == hint.num.charAt(j)) {
    					s++;
    				}else if(hint.num.contains(String.valueOf(candidate.charAt(j)))) {
    					b++;
    				}
    			}
    			
    			if(s != hint.strike || b != hint.ball) {
    				isValid = false;
    				break;
    			}
    		}
    		
    		if(isValid) count++;
    	}
    	
    	System.out.println(count);
    }
    
    static boolean hasZeroOrDuplicate(String candidate) {
    	return candidate.contains("0") || candidate.charAt(0) == candidate.charAt(1)
    			|| candidate.charAt(1) == candidate.charAt(2) ||
    			candidate.charAt(0) == candidate.charAt(2);
    }
}


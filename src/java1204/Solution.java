package java1204;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/*
사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
*/

//map을 이용하는게 가장 편할 것 같다. 당장에 그냥 배열로 해결하는 건 어려울 것 같다 왜냐하면 숫자를 키로 해야하는데 배열 길이가 들쭉날쭉 해지기 때문
//그래서 생각난 아이디어는 map자료형을 만들고 들어오는 숫자에 해당하는 키가 없을 경우 키로 추가하고 있을 경우 value 부분에 1씩 추가하는 방식으로 한다.
//그 다음 각 value를 비교해서 가장 큰 값들을 뽑아내고(최빈수) 그 값들중에서 key값이 가장 큰 걸 출력한다.
//Array, List, Set, Map이 코테 기초 4대장 자료형이라고 하니 선언하고 사용하는 방법 잘 알아두자
class Solution {
	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {

			int N = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			// Map 생성
			Map<Integer, Integer> map = new HashMap<>();
			
			while(st.hasMoreTokens()) {
				int key = Integer.parseInt(st.nextToken());
				int value = key;
				
				if(map.containsKey(key)) {
					map.put(key, map.getOrDefault(key, 0) + 1);
					// 해당 키의 값이 있으면 가져오고 없으면 기본값 0
				}else {
					map.put(key, 1);
				}
			}
			
			//value중에서 가장 큰 값을 찾고 
			int maxValue = Collections.max(map.values());
			
			int maxKey = 0;
			// 그 maxValue를 가진 key들을 찾기
	        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
	            if (entry.getValue() == maxValue) {
	            	maxKey = Math.max(maxKey, entry.getKey());
	            }
	        }
	        
	        System.out.printf("#%d %d\n", test_case, maxKey);
		}
	}
}

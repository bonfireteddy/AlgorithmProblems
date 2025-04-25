package java1204;

import java.util.*;
import java.io.*;

/*
사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
*/

//map을 이용하는게 가장 편할 것 같다. 당장에 그냥 배열로 해결하는 건 어려울 것 같다 왜냐하면 숫자를 키로 해야하는데 배열 길이가 들쭉날쭉 해지기 때문
//그래서 생각난 아이디어는 map자료형을 만들고 들어오는 숫자에 해당하는 키가 없을 경우 키로 추가하고 있을 경우 value 부분에 1씩 추가하는 방식으로 한다.
//그 다음 각 value를 비교해서 가장 큰 값들을 뽑아내고 그 값들중에서 key값이 가장 큰 걸 출력한다.
//Array, List, Set, Map이 코테 기초 4대장 자료형이라고 하니 선언하고 사용하는 방법 잘 알아두자
class Solution {
	public static void main(String args[]) throws Exception {
		
		int T = 10;
		
	// Map 생성
      Map<String, Integer> map = new HashMap<>();

      // 값 추가 (put)
      map.put("apple", 3);
      map.put("banana", 5);
      map.put("orange", 2);

      // 값 가져오기 (get)
      System.out.println(map.get("apple")); // 출력: 3

      // 키 존재 여부 확인 (containsKey)
      System.out.println(map.containsKey("banana")); // true

      // 값 존재 여부 확인 (containsValue)
      System.out.println(map.containsValue(2)); // true

      // 크기 확인 (size)
      System.out.println(map.size()); // 3

      // 값 제거 (remove)
      map.remove("orange");

      // 전체 출력 (entrySet 이용)
      for (Map.Entry<String, Integer> entry : map.entrySet()) {
          System.out.println(entry.getKey() + " -> " + entry.getValue());
      }
		
		for (int test_case = 1; test_case <= T; test_case++) {

			/*
			 * 이 부분에 여러분의 알고리즘 구현이 들어갑니다.
			 */

		}
	}
}

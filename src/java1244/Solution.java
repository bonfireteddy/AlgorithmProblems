package java1244;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	
	// 동일한 위치의 교환이 중복되면 안된다.
	// 하지만 94처럼 숫자가 2개일 경우 2회 교환하면 원래의 94로된다. 
	// 숫자가 2개일 경우 교환 중복 허용
	// 주어진 숫자의 자리수 변경을 통해 최대값을 만드는 문제
	// 맨 앞에는 숫자중에서 가장 큰 값이 와야하고 뒤로 보낼 수 있는 숫자중에서도
	// 가장 큰 자리수로 옮기는 것에 유의해야 한다.
	// 교환은 하는데 앞에 더 큰 수가 올 수 있도록 해야함.
	
	// 숫자중에서 최소값인 수가 최대한 뒤에 와야한다.
	// 최대값인 수가 최대한 앞에 와야한다.
	// 여기서 최대한이라고 한 이유는 교환횟수가 한정돼있기 때문이다.
	// 반드시 횟수만큼 교환이 이루어지고 동일한 위치 교환 중복가능
	// 이건가... 숫자중에서 낮은 순서대로 뒤에서의 자리가 주어지고
	// 높은 순서대로 앞에서의 자리가 주어진다.
	
	// 1. 최대값 찾기 + 인덱스까지 같이 저장
	// 2. 최소값 찾기 + 인덱스까지 같이 저장 
	// 3. 교환 횟수를 무조건 소모하기 때문에 최대값과 최소값의 개수는 쌍을 이룬다.
	// 4. 그러면 교환횟수의 개수만큼 각각 최대값과 최소값을 찾으면 된다. 
	// 5. 그리고 최대값과 최소값을 교환한다.
	// 6. 단, 최대값이 여러개인 경우 인덱스가 가장 높은 최대값가 최소값을 교환한다.  
	
	// 그냥 오름차순하고 내림차순하고 정렬시키고 교환횟수만큼 가져와도 될지도...
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		
		
		for(int a = 1; a <= testCase; a++) {
			int maxValue = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			String value = st.nextToken();
			int change = Integer.parseInt(st.nextToken());
			
			int[] arr = new int[value.length()];
			
			for(int i = 0; i < value.length(); i++) {
				arr[i] = value.charAt(i) - '0';
			}
			
			List<Integer> MaxList = new ArrayList<>();
			List<Integer> MinList = new ArrayList<>();
			
			for(int num : arr) {
				MaxList.add(num);
			}
			
			for(int num : arr) {
				MinList.add(num);
			}
			
			Collections.sort(MaxList);
			Collections.sort(MinList, Collections.reverseOrder());
			
			for(int n = 0; n < change; n++) {
				// 배열에서 가장 뒤쪽의 최대값 찾기
				int max = MaxList.get(0);
				int maxIndex = 0;
				
				for(int m = 0; m < arr.length; m++) {
					if(arr[m] >= max) {
						max = arr[m];
						maxIndex = m;
					};
				}
				
				// 배열에서 가장 앞쪽의 최소값 찾기
				int min = MinList.get(0); 
				int minIndex = 0;
				
				for(int m = 0; m < arr.length; m++) {
					if(arr[m] <= min) {
						min = arr[m];
						minIndex = m;
					};
				}
				
				// 두수의 교환 배열 인덱스로
				int temp = arr[maxIndex];
				arr[maxIndex] = arr[minIndex];
				arr[minIndex] = temp; 
				
			}
			
			for(int m = 0; m < arr.length; m++) {
				maxValue += arr[m];
			}
			
			
			System.out.printf("#%d %s\n", a, maxValue);
		}
		
	}

}

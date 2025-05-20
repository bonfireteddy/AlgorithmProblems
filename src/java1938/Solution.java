package java1938;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Student implements Comparable<Student> {
	int num;
	Double ts; // 계산된 총합 점수
	String tp; // 상대평가로 계산된 학점
	
	Student(int num, Double mp, Double ep, Double sp){
		this.num = num;
		tsCalculate(mp, ep, sp);
	}
	
	void tsCalculate(Double mp, Double ep, Double sp) {
		mp = mp * 0.35;
		ep = ep * 0.45;
		sp = sp * 0.20;
		
		this.ts = mp+ep+sp;
	}
	
	@Override
	public int compareTo(Student other) {
		// 내림차순
		return other.ts.compareTo(this.ts);
	}
}

public class Solution {
	
	// 일단 String배열에다가 평점들저장해두기
	// 스튜던트 클래스를 만들까? - 속성 중간, 기말, 과제 점수, 계산된 평점, 번호
	// 총점 비율 반영하는게 이게 본인이 맞은 점수에다가 35프로 곱해서 더하면되나?
	// 그렇게 해서 계산된 평점으로 오름차순으로 정렬한다음, N/10명 기준으로 상대평가 평점부여
	
	static String[] grade = {"A+","A0","A-","B+","B0","B-","C+","C0","C-","D0"};
	
	public static void main(String[] args) throws IOException {
		
		System.setIn(new FileInputStream("res/input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			String result = "";
			
			Student[] students = new Student[N];
			
			for(int a = 1; a <= N; a++) {
				st = new StringTokenizer(br.readLine());
				
				int num = a; 
				Double mp = Double.parseDouble(st.nextToken()); 
				Double ep = Double.parseDouble(st.nextToken()); 
				Double sp = Double.parseDouble(st.nextToken());
				
				Student student = new Student(num, mp, ep, sp);
				students[a-1] = student; 
			}
			
			Arrays.sort(students);
			//Arrays.sort(students, 1, N + 1); // ts 기준 오름차순 정렬
			//Arrays.sort(students, 1, N + 1, (a, b) -> a.ts.compareTo(b.ts));
			// 내림차순 -> (a, b) -> b.ts.compareTo(a.ts)
			
			// N/10명 기준으로 상대평가 평점부여
			int pn = N/10;
			int gradeIndex = 0;
			for(int a = 0; a < N; a+=pn) {
				for(int b = a; b < a+pn; b++) {
					students[b].tp = grade[gradeIndex];
				}
				gradeIndex++;
			}
			
			for(int a = 0; a < N; a++) {
				if(students[a].num == K) {
					result = students[a].tp;
				}
			}
			
			System.out.printf("#%d %s\n", t, result);
		}
		
	}

}

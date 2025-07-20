package baekjoon;

import java.util.*;

public class Main1713 {
   
	static class Student {
		int num = 0; // 학생 번호
		int time = 0; // 사진틀에 등록된 시점
		int rec = 0; // 추천받은 횟수
		
		Student(int num, int time, int rec){
			this.num = 0;
			this.time = 0;
			this.rec = 0;
		}
	}
	
    public static void main(String[] args) {
        
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	int M = sc.nextInt();
    	
    	List<Student> frame = new ArrayList<>();
    	
    	for(int t = 0; t < M; t++) {
    		int num = sc.nextInt();
    		
    		boolean isExist = false;
    		for(Student s : frame) { 
    			if(s.num == num) { // 기존의 숫자가 존재하는 경우 추천수만 증가 
    				s.rec++;
    				isExist = true;
    				break;
    			}
    		}
    		
    		if(!isExist) {
    			if(frame.size() < N) {
    				frame.add(new Student(num, 1, t)); // 비어 있으면 바로 추가
    			}else {
    				// 추천 수가 같을 경우 시간순으로 정렬 추천 수 적고, 오래된 학생 제거
    				frame.sort((a, b) -> {
    					if(a.rec == b.rec) return a.time - b.time;
    					return a.rec - b.rec;
    				});
    				frame.remove(0);
    				frame.add(new Student(num, 1, t));
    			}
			}
    	}
    	
    	// 학생 번호 오름차순 출력
    	frame.sort(Comparator.comparingInt(a -> a.num));
    	
    	for(Student s : frame) {
    		System.out.println(s.num + " ");
    	}
    }
}

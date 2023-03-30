package week5;

import java.util.Scanner;

public class AS1 {
	public static void main (String[] args) {
		
		Scanner sc = new Scanner (System.in);
		
        int ans = (int) (Math.random() * 100);
        
        while(true) {
            System.out.println("숫자를 맞혀 보세요(1~100) >> ");
            int num = sc.nextInt();
            
            String hint = num > 100 || num < 0 ? "1~100 사이의 값을 입력하세요" :
            				   num > ans ? "숫자가 너무 큽니다." : 
            					num < ans ? "숫자가 너무 작습니다." : "정답입니다. 랜덤 숫자는 " + ans + "입니다.";
            				   
            System.out.println(hint); 
                 if (num == ans) break;
        }
	}
}

package week5;

import java.util.Scanner;

public class AS1 {
	public static void main (String[] args) {
		
		Scanner sc = new Scanner (System.in);
		
        int ans = (int) (Math.random() * 100);
        
        while(true) {
            System.out.println("���ڸ� ���� ������(1~100) >> ");
            int num = sc.nextInt();
            
            String hint = num > 100 || num < 0 ? "1~100 ������ ���� �Է��ϼ���" :
            				   num > ans ? "���ڰ� �ʹ� Ů�ϴ�." : 
            					num < ans ? "���ڰ� �ʹ� �۽��ϴ�." : "�����Դϴ�. ���� ���ڴ� " + ans + "�Դϴ�.";
            				   
            System.out.println(hint); 
                 if (num == ans) break;
        }
	}
}

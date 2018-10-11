import java.util.Scanner;

public class Calendar {

	public static void main(String[] args) {
		int [][] cal = new int[6][7];
		Scanner sc = new Scanner(System.in);
		System.out.print("년도 입력:");
		int year = sc.nextInt();
		System.out.print("월 입력:");
		int month = sc.nextInt();
		
		//각 월의 날 수 배열
		int [] months = {0,31,28,31,30,31,30,31,31,30,31,30,31};
		//윤년이면 2월은 29일 까지
		if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
			months[2] = 29;
		}
		
		//year 이전까지 지나온 날 수 더하기
		int days = 0;
		int idx = 1;
		while(idx < year) {
			if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0)
				days = days +  366;
			else
				days = days +  365;
			idx = idx + 1;
		}
		//month 이전까지 지나온 날 수 구하기
		idx = 1;
		while(idx < month) {
			days = days + months[idx];
			idx = idx + 1;
		}
		
		idx = days % 7;
		//System.out.println(idx);
		
		int i=1;
		while(i <= months[month]) {
			cal[idx/7][idx%7] = i;
			idx = idx + 1;
			i = i + 1;
		}
		
		i = 0;
		System.out.println("  일  월  화  수  목  금  토");
		while(i < 42) {
			int imsi = cal[i/7][i%7];
			if(imsi == 0) {
				System.out.printf("%4s", " ");
			}else {
				System.out.printf("%4d", imsi);
			}
			i = i + 1;
			if(i%7 == 0) {
				System.out.println();
			}
		}
		sc.close();
	}
}










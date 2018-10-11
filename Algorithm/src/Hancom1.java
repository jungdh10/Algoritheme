import java.util.Scanner;

public class Hancom1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("¶óÀÎ ¼ö:");
		int line = sc.nextInt();
		int idx = 0;
		for(int i=0; i<line; i=i+1) {
			for(int j=0; j<line-i-1; j=j+1) {
				System.out.print(" ");
			}
			System.out.print(idx%10);
			idx = idx + 1;
			if(i>=1 && i<line-1) {
				for(int j=0; j<2*i-1; j=j+1) {
					System.out.print(" ");
				}
				System.out.print(idx%10);
				idx = idx + 1;
			}
			else if(i==line-1) {
				for(int j=0; j<2*i; j=j+1) {
					System.out.print(idx%10);
					idx = idx + 1;
				}
			}
			
			
			System.out.println("");
		}
		
		sc.close();

	}

}

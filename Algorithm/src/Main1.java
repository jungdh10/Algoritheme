
public class Main1 {

	public static void main(String[] args) {
		int [][] ar = {{1,2,3}, {4,5,6}};
		for(int i=0; i<6; i=i+1) {
			System.out.println(ar[i/3][i%3]);
		}

	}

}

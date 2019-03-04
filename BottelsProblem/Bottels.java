
public class Bottels {
	public static int index (int a,int b,int n) {
		return (n+1)*a+b;
	}
	public static int[][] BottelsEmplemnt(int n,int m){
		int length=(n+1)*(m+1);
		int[][] mat=new int[length][length];
		for (int a = 0; a <= m; a++) {
			for (int b = 0; b <= n; b++) {
				int ind = index(a,b,n); //מס' שורה במטריצה 
				int j1=index(0,b,n); //ארבעת התאים לאלגוריתם 
				mat[ind][j1]=1;
				int j2=index(m,b,n);
				mat[ind][j2]=1;
				int j3=index(a,0,n);
				mat[ind][j3]=1;
				int j4=index(a,n,n);
				mat[ind][j4]=1;
				int  j5= index(Math.max(0,a+b-m), Math.min(a+b,n),n);
				mat[ind][j5]=1;
				int j6= index(Math.min(a+b,m),Math.max(0,a+b-m),n);
				mat[ind][j6]=1;
			}
		}

		return mat;
	}
	public static void main(String[] args) {
		int[][] a=BottelsEmplemnt(1,2);
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
	}

}

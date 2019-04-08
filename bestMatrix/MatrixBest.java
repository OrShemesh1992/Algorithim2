
public class MatrixBest {

	public static int[][] matrixHelp(int[][] mat){

		int[][] help=new int[mat.length][mat[0].length];
		help[0][0]=mat[0][0];
		for (int i = 1; i < help.length; i++) {
			help[i][0]=help[i-1][0]+mat[i][0];
		}
		for (int i = 1; i < help[0].length; i++) {

			help[0][i]=help[0][i-1]+mat[0][i];
		}
		for (int i = 1; i < mat.length; i++) {
			for (int j = 1; j < mat.length; j++) {
				help[i][j]=help[i][j-1]+help[i-1][j]+mat[i][j]-help[i-1][j-1];
			}
		}

		return help;
	}

	public static int sum_ij_pq(int[][] mat,int i,int j,int p,int q) {

		if(i==0 && j==0) {
			return mat[p][q];
		}else if(i==0 && j>0) {
			return mat[p][q]-mat[p][j-1]; 
		}else if(i>0&&j==0) {
			return mat[p][q]-mat[i-1][q];
		}else {
			return mat[p][q]-mat[i-1][q]-mat[p][j-1]+mat[i-1][j-1];
		}
	}

	public static int bestMatrix(int[][] mat) {

		int[][] h=matrixHelp(mat);
		int max=h[0][0],sum=0;

		for (int i = 0; i < h.length; i++) {
			for (int p = i; p < h[0].length; p++) {
				int j=0;
				for (int q = 0; q < h.length; q++) {
					sum=sum_ij_pq(h,i,j,p,q);
					if(sum<0) {
						j=q+1;
					}else if(sum>max) {
						max=sum;
					}
				}
			}
		}
		return max;
	}
	public static void main(String[] args) {
		int[][] a= {{0,-2,-7,0},{9,2,-6,2},{-4,1,-4,1},{-1,8,0,-2}};
		int[][] b=matrixHelp(a);
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b.length; j++) {
				System.out.print(b[i][j]+ " ");
			}
			System.out.println();
		}
		System.out.println(bestMatrix(a));
	}

}

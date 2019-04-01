
public class BestCircle {
	static int maxCircularSum (int a[]) 
	{ 
		int n = a.length;  
		int max_best = best(a);  
		int max_bestcircle  =  0; 
		for (int i = 0; i < n; i++) 
		{ 
			max_bestcircle += a[i]; 
			a[i] = -a[i]; 
		} 
		max_bestcircle = max_bestcircle + best(a); 
		return (max_bestcircle > max_best)? max_bestcircle: max_best; 
	} 
	static int best (int a[]) 
	{ 
		int n = a.length; 
		int max_so_far = 0, max_ending_here = 0; 
		for (int i = 0; i < n; i++) 
		{ 
			max_ending_here = max_ending_here + a[i]; 
			if (max_ending_here < 0) 
				max_ending_here = 0; 
			if (max_so_far < max_ending_here) 
				max_so_far = max_ending_here; 
		} 
		return max_so_far; 
	} 

	static boolean haveRoad(int[] node,int[] gaz) {
		int sumnode=0,sumgaz=0;
		for (int i = 0; i < node.length; i++) {
			sumnode+=node[i];
		}
		for (int i = 0; i < gaz.length; i++) {
			sumgaz+=gaz[i];
		}
		return  (sumnode > sumgaz) ? true : false;  
	}
	static int TheBestWay(int[] node,int[] gaz) {
		int[] dif=new int [node.length];

		if(!haveRoad(node,gaz))
			return -1;
		else {

			for (int i = 0; i < dif.length; i++) {
				dif[i]=node[i]-gaz[i];
			} 
		}
		return maxCircularSum(dif);
	}
	public static void main (String[] args) 
	{ 
		int a[] =  {1,5,-7,-8,8}; 
		System.out.println("Maximum circular sum is " + 
				maxCircularSum(a)); 
		int node[] = {3,6,2,8};
		int gaz[] = {5,4,3,4};
		System.out.println("Best road for gaz: "+ TheBestWay(node,gaz));
	}
}
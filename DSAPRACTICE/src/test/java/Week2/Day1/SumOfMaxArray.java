package Week2.Day1;

public class SumOfMaxArray {

	public static void main(String[] args) {
		
		int[] arr= {100, 200, 300, 400};
		int k=2;
		int sum=0, max=Integer.MAX_VALUE;
		for(int i=0;i<arr.length-1;i++) {
			for(int j=i;i<k-1;j++) {
				sum=arr[j]+arr[j+1];
				if(sum>max) {
				max=sum;
				System.out.println(max);
				}
			}
		}
		System.out.println(max);

	}

}

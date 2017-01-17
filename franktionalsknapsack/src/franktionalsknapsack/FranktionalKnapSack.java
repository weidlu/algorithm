package franktionalsknapsack;

import java.util.Arrays;
import java.util.Scanner;

public class FranktionalKnapSack {
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		System.out.println("有多少物品:");
		int n = in.nextInt();
		int[] w = new int[n];
		int[] v = new int[n];
		System.out.println("物品重量:");
		for(int i=0;i<n;i++){
			w[i] = in.nextInt();
		}
		System.out.println("物品价值:");
		for(int i=0;i<n;i++){
			v[i] = in.nextInt();
		}
		System.out.println("背包总重量:");
		int c = in.nextInt();
		in.close();
		//按照单位价值重新排序数组
		double startTime = System.currentTimeMillis();
		double[] r = new double[n];
		int[] index = new int[n];
		for(int i=0;i<n;i++){
			r[i] = (double)v[i]/(double)w[i];
			index[i] = i;
		}
		double temp = 0;
		//交换排序 降序排列
		for(int i=0;i<n;i++){
			for(int j=i+1;j<n;j++){
				if(r[i]<r[j]){
					temp = r[i];
					r[i] = r[j];
					r[j] = temp;
					int x = index[i];
					index[i] = index[j];
					index[j] = x;
				}
			}
		}
		//存储新的数组
		int[] w1 = new int[n];
		int[] v1 = new int[n];
		for(int i=0;i<n;i++){
			w1[i]=w[index[i]];
			v1[i]=v[index[i]];
		}
		System.out.println("按照重量排序："+Arrays.toString(w1));
		System.out.println("按照价值排序："+Arrays.toString(v1));
		//初始化向量
		int[] x = new int[n];
		for(int i=0;i<n;i++){
			x[i]=0;
		}
		
		for(int i=0;i<n;i++){
			if(w1[i]<c){
				x[i]=1;
				c=c-w1[i];
			}
		}
		System.out.println("解为：:"+Arrays.toString(x)+"ps(1表示选择，0表示不选，小数表示选取的百分比)");
		int maxValue = 0;
		for(int i=0;i<n;i++){
			if(x[i]==1){
				maxValue+=v1[i];				
			}		
		}
		double endTime = System.currentTimeMillis();
		System.out.println("最高价值："+maxValue);
		System.out.println("运行时间："+(endTime-startTime)+"ms");
	}
	//已经有了maxValue/x[i]/
	
}

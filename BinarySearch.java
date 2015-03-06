import java.util.Scanner;

import javax.naming.directory.SearchControls;


public class BinarySearch 
{
	int []matrix=new int[100];
	//保存输入的数组
	int matrix_length;   //数组的长度
	int Index1; 	//前面一个指针
	int IndexMiddle;//	当前的中位数
	int Index2;		//后面一个的指针
	
	public void Input()
	{
		System.out.println("请输入数组的值：");
		Scanner Scanner1 = new Scanner(System.in); 
		String 	matrixString = Scanner1.nextLine();
		String []matrixSplit=matrixString.split(" ");
		
		matrix_length=matrixSplit.length;
		
		for(int i=0;i<matrix_length;i++)
		{
			matrix[i]=Integer.parseInt(matrixSplit[i]); //进行类型转换，为数组进行赋值
			System.out.println("i: "+i);
			System.out.println("matrix[i]: "+matrix[i]);
		}
	}
	
	/*
		不要试图进行同时与两边的比较，注意！！
		每次只比一边
		6 7 1 2 3 4 5 此时，中位数为2，
		如果属于前面一半的话，中位数应该比index1大
		但是中位数比index1小，说明此时中位数已经属于后面一个数组(且比后面的index2要小)
		此时目标为第二个数组的开头，目标处于  index1与 中位数之间  ，即  index2=中位数
		
		4 5 6 7 1 2 3 此时，中位数为7
		如果属于前面一半的话，中位数应该比index1大，
		符合条件，说明此时中位数仍然属于前面一个数组
		此时目标为第二个数组的开头，目标处于中位数和index2之间，即index1=中位数
		
		注意：extra_case
		如果 1 2 3 4 5 6 7 ,即完全没有旋转发生时，
		index1的值是小于index2的，非常不合理的，
		此时目标就是index1.
		所以代码中默认indexMiddle=index1;
		
		关于为啥在index2-index1=1时，输出的目标结果是index2
		可以举例子实现，具体也可以分析 6 7 1 2 3 4 5 
		最后一步是 7 1 2 是与第一个数字比较的，所以是 7 1 作为目标
		明显1是我们所求的，故index2是目标
	*/
	
	public int BinSearch()
	{
		Index1=0;
		Index2=matrix_length-1;
		IndexMiddle=Index1;
		
		//为了防止0旋转情况
		//一直这样循环，直到满足， 差1
		while(matrix[Index1]>matrix[Index2]||matrix[Index1]==matrix[Index2])
		{
			if(Index2-1==Index1)
			{
				IndexMiddle=Index2;
				//不应该在这里输出的！大哥
				
				break; //注意是跳出该循环体
			}
			
			IndexMiddle=Index1+(Index2-Index1)/2;
			if(matrix[Index1]>matrix[IndexMiddle]||matrix[Index1]==matrix[IndexMiddle])
			{
				Index1=IndexMiddle;
			}
			else
			{
				if(matrix[IndexMiddle]<matrix[Index2]||matrix[IndexMiddle]==matrix[Index2])
				{
					Index2=IndexMiddle;
				}
			}
		}
		
		return IndexMiddle;
	}
	
	public void Output(int ans)
	{
		System.out.println("已经找到最小元素");
		System.out.println("目标位置： "+ ans);
		System.out.println("目标的值为： "+matrix[ans]);
	}
	
	public static void main(String args[])
	{
		try 
		{
			BinarySearch binary1=new BinarySearch();
			binary1.Input();
			int ans=binary1.BinSearch();
			binary1.Output(ans);
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			// TODO: handle exception
		}
	}
	
	
}

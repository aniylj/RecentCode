import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;



//

public class ArrayExtra 
{
	int dimension; //数组的维度
	int []matrix=new int[100];
	int search_number;
	
	public void InputValue() throws IOException
	{
		
		System.out.println("请输入数组维度： ");
		InputStream mym= System.in;
		BufferedReader rd = new BufferedReader(new InputStreamReader(mym));
		try 
		{
			dimension=Integer.parseInt(rd.readLine());
		}
		catch(IOException e) 
		{
			System.out.println(e.getMessage());
		}
		
		System.out.println("请输入数组的值：");
		Scanner Scanner1 = new Scanner(System.in); 
		String 	matrixString = Scanner1.nextLine();
		String []matrixSplit=matrixString.split(" ");
		if(matrixSplit.length!=dimension*dimension)
		{
			System.out.println("输入的数据值的数量不符合规定");
			return;
		}
		for(int i=0;i<matrixSplit.length;i++)
		{
			matrix[i]=Integer.parseInt(matrixSplit[i]);
			System.out.println("matrix[i]的输出"+matrix[i]);
		}
		
		System.out.println("请输入待查找的值");
		Scanner Scanner2 = new Scanner(System.in); 
		String searchString=Scanner2.next();
		search_number=Integer.parseInt(searchString);
		System.out.println("待查找的值是："+search_number);
	}
	
	public void Search()
	{
		int column=dimension-1;  //列在最右边
		int row=0;	//行在最上边
		
		//行列，不要超过限制
		while(row<dimension&&column>-1)
		{
			if(matrix[row*dimension+column]==search_number)
			{
				System.out.println("已经找到"+search_number);
				System.out.println("row=: "+row);
				System.out.println("column=: "+column);
				return;
			}
			else
			{
				//大于删除列
				if(matrix[row*dimension+column]>search_number)
				{
					column--;
				}
				//小于删除行
				else
				{
					row++;
				}
			}
		}
	}
	
	public static void main(String []args)
	{
		try 
		{
			ArrayExtra arrayExtra=new ArrayExtra();
			arrayExtra.InputValue();
			arrayExtra.Search();
		} 
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
	
		
	}
}

import java.util.Scanner;

import org.omg.CORBA.PUBLIC_MEMBER;

public class PrintToMax 
{
	int n;
	char []number=new char[100];
	public void Input()
	{
		System.out.println("请输入数的位数n");
		Scanner sc1=new Scanner(System.in); 
		String input_str=sc1.next();
		n=Integer.parseInt(input_str);  //得到n
	}
	
	public void PrintToMax1()
	{
		if(n<0||n==0)
		{
			System.out.println("n的输入应该大于0");
			return;
		}
		for(int i=0;i<10;i++)
		{
			number[0]=(char) ('0'+i);   //这个函数中，只设置最高位，其中 0==最高位
			PrintToMaxRecusively(0);
		}
		
	}
		
	public void PrintToMaxRecusively(int index)  //因为这里，number与n这两个变量都是全局变量
	{
		if(index == n-1)//即已经设置到了个位数
		{
			PrintNumber();
			return;  //同时递归在这一轮结束了
		}
		
		for(int i=0;i<10;i++)
		{
			number[index+1]=(char)('0'+i);
			PrintToMaxRecusively(index+1);
		}
	}
	
	public void PrintNumber()  //控制输出也是一个关键
	{
		
		boolean isNon=false;
		for(int i=0;i<n;i++)
		{
			//从1开始输出，不用考虑全为0时，不输出的情况
			//即如果不为0，直接输出首位，输出首位后，isNon马上置为true，辣么 ==即使number[i]==0也会进入这个判断中
			if(number[i]!='0'||isNon==true)  
			{
				System.out.print(number[i]); //输出这一位，并且后来的位数即使为0，也可以输出了
				isNon=true; //设置为true，后面的位数为0，我是不管的。
			}
		}
		System.out.println();
	}
	public static void main(String []args)
	{
		 PrintToMax printmax=new PrintToMax();
		 printmax.Input();  //输入参数
		 printmax.PrintToMax1();  //自动调用递归函数，递归函数自动调用输出函数进行打印
		 
		/* 
		 //是对的啊，绝对不会自动不换行的
		 System.out.print('a');
		 System.out.print('b');
		 System.out.print('c');
		 */
		 
	}
	
}

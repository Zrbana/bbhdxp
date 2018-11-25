//1.分别用递归和非递归求斐波那契数列第n项
#define _CRT_SECURE_NO_WARNINGS 1
#include <stdio.h>
//非递归
int Fib(int n)
{
	if (n == 1)
	{
		return 0;
	}
	if (n == 2)
	{
		return 1;
	}
	int f1 = 0;
	int f2 = 1;
	int c = 0;
	for (int i = 3; i <= n; i++)
	{
		c = f1 + f2;
		f1 = f2;
		f2 = c;
	}

	return c;
}
int main()
{
	int n;
	scanf("%d", &n);
	int ret = Fib(n);
	printf("%d", ret);
	system("pause");
	return 0;
}

//递归
int Fib(int first, int second, int n)
{
	if (n <= 2)
	{
		return n - 1;
	}
	else if (n == 3)
	{
		return first + second;
	}
	else
	{
		return Fib(second, first + second, n - 1);
	}

}
int main()
{
	int n;
	scanf("%d", &n);
	int ret = Fib(0, 1, n);
	printf("%d", ret);
	system("pause");
	return 0;

}








//2.写一个递归函数DigitSum(n)，输入一个非负整数，返回组成它的数字之和.
//例如，调用DigitSum(1729)，则应该返回1+7+2+9，它的和是19
#include <stdio.h>
int DigitSum(int n)
{
	int sum = 0;
	int m = 0;
	if (n != 0)
	{
		m = n % 10;
		n = n / 10;
		sum = m + DigitSum(n);
	}
	return sum;
}
int main()
{
	int a;
	printf("请输入一个整数： ");
	scanf("%d", &a);
	printf("各位数之和为：%d\n", DigitSum(a));
	system("pause");
	return 0;
}

//3.编写一个函数 reverse_string(char * string)（递归实现）
//实现：将参数字符串中的字符反向排列。
//要求：不能使用C函数库中的字符串操作函数。

#include <stdio.h>
#include <stdlib.h>
#include <assert.h>

char* reverse_string(char *str)
{
	assert(str != NULL);
	if (*str != '\0')
	{
		str++;
		reverse_string(str);
		printf("%c", *(str - 1));
	}
	return str;
}

int main()
{
	char arr[] = "abcdef";
	char* ret = reverse_string(arr);
	system("pause");
	return 0;
}

//4.
//编写一个函数实现n^k，使用递归实现
#include <stdio.h>
int fun(int n, int k)     //求n的k次方
{
	int sum;
	if (k == 0)
	{
		sum = 1;
	}
	else
	{
		sum = n*fun(n, k - 1);
	}
	return sum;
}
int main()
{
	printf("%d\n", fun(2, 3));
	return 0;
}

//5.
//递归和非递归分别实现strlen
//计数、递归和非递归三种方法分别实现strlen
//首先明白strlen的功能
//这是一个求字符串长度的函数
//只能用char*做参数(字符型指针)，且必须是以'\0'结尾的

#include<stdio.h>
int my_strlen0(const char *arr)//计数方式
{
	int count = 0;
	while (*arr)
	{
		arr++;
		count++;
	}
	return count;
}
int my_strlen1(char *arr)//指针方式
{
	char *p = arr;//将数组首元素地址给指针p
	while (*p != '\0')
	{
		p++;           //指针最后指向arr中最后一个元素
	}
	return p - arr;//返回数组元素个数
}
int my_strlen2(char *arr)//递归方式
{
	if ('\0' == *arr)
	{
		return 0;
	}
	else
	{
		return 1 + my_strlen2(arr + 1);//调用自己 传arr+1
	}
}
int main()
{
	char arr[] = "abcdefg";
	my_strlen0(arr);
	my_strlen1(arr);
	my_strlen2(arr);
	printf("%d\n", my_strlen0(arr));
	printf("%d\n", my_strlen1(arr));
	printf("%d\n", my_strlen2(arr));
	return 0;
}


//6.递归和非递归分别实现n的阶乘
#define _CRT_SECURE_NO_WARNINGS  1
#include<stdio.h>
#include<stdlib.h>
//非递归实现n的阶乘
int Factor(int n)
{
	int ret = 1;//处理0的阶乘和1的阶乘
	for (int i = 1; i <= n; i++)
	{
		ret = ret*i;
	}
	return ret;
}

//递归实现n的阶乘
int Factor(int n)
{
	if (n == 0 || n == 1)
	{
		return 1;
	}
	return n*Factor(n - 1);
}

int main()
{
	int num = 0;
	scanf("%d", &num);
	int ret = Factor(num);
	printf("%d", ret);
	system("pause");
	return 0;
}

//7.递归方式实现打印一个整数的每一位数字
#include<stdio.h>
#include<stdlib.h>

//递归方式实现打印一个整数的每一位 

void Print(int n)
{
	if (n > 9)
	{
		Print(n / 10);
	}
	printf("%d\n", n % 10);
}
int main()
{
	Print(1234);
	system("pause");
	return 0;
}



















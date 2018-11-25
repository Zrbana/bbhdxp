//1.�ֱ��õݹ�ͷǵݹ���쳲��������е�n��
#define _CRT_SECURE_NO_WARNINGS 1
#include <stdio.h>
//�ǵݹ�
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

//�ݹ�
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








//2.дһ���ݹ麯��DigitSum(n)������һ���Ǹ����������������������֮��.
//���磬����DigitSum(1729)����Ӧ�÷���1+7+2+9�����ĺ���19
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
	printf("������һ�������� ");
	scanf("%d", &a);
	printf("��λ��֮��Ϊ��%d\n", DigitSum(a));
	system("pause");
	return 0;
}

//3.��дһ������ reverse_string(char * string)���ݹ�ʵ�֣�
//ʵ�֣��������ַ����е��ַ��������С�
//Ҫ�󣺲���ʹ��C�������е��ַ�������������

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
//��дһ������ʵ��n^k��ʹ�õݹ�ʵ��
#include <stdio.h>
int fun(int n, int k)     //��n��k�η�
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
//�ݹ�ͷǵݹ�ֱ�ʵ��strlen
//�������ݹ�ͷǵݹ����ַ����ֱ�ʵ��strlen
//��������strlen�Ĺ���
//����һ�����ַ������ȵĺ���
//ֻ����char*������(�ַ���ָ��)���ұ�������'\0'��β��

#include<stdio.h>
int my_strlen0(const char *arr)//������ʽ
{
	int count = 0;
	while (*arr)
	{
		arr++;
		count++;
	}
	return count;
}
int my_strlen1(char *arr)//ָ�뷽ʽ
{
	char *p = arr;//��������Ԫ�ص�ַ��ָ��p
	while (*p != '\0')
	{
		p++;           //ָ�����ָ��arr�����һ��Ԫ��
	}
	return p - arr;//��������Ԫ�ظ���
}
int my_strlen2(char *arr)//�ݹ鷽ʽ
{
	if ('\0' == *arr)
	{
		return 0;
	}
	else
	{
		return 1 + my_strlen2(arr + 1);//�����Լ� ��arr+1
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


//6.�ݹ�ͷǵݹ�ֱ�ʵ��n�Ľ׳�
#define _CRT_SECURE_NO_WARNINGS  1
#include<stdio.h>
#include<stdlib.h>
//�ǵݹ�ʵ��n�Ľ׳�
int Factor(int n)
{
	int ret = 1;//����0�Ľ׳˺�1�Ľ׳�
	for (int i = 1; i <= n; i++)
	{
		ret = ret*i;
	}
	return ret;
}

//�ݹ�ʵ��n�Ľ׳�
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

//7.�ݹ鷽ʽʵ�ִ�ӡһ��������ÿһλ����
#include<stdio.h>
#include<stdlib.h>

//�ݹ鷽ʽʵ�ִ�ӡһ��������ÿһλ 

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



















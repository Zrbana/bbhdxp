#define _CRT_SECURE_NO_WARNINGS 1
//第一个C语言程序
//#include<stdio.h>
//int main()
//{
//	printf("Hello world!\n");
//	printf("哈哈\n");
//	system("pause");
//	return 0;
//}



//数据类型
//int   char   short  long   longlong   float   double
//计算每种数据类型的大小
//#include <stdio.h>
//int main()
//{
//	printf("%d", sizeof(char));//1
//	printf("%d", sizeof(short));//2
//	printf("%d", sizeof(double ));//8
//	printf("%d", sizeof(int));//4
//	printf("%d", sizeof(long));//4
//	printf("%d", sizeof(long long));//8
//	printf("%d", sizeof(long double));//8
//	system("pause");
//	return 0;
//}


//局部变量和全局变量
//#include<stdio.h>
//int global = 2018;
//int main()
//{
//	int local = 2017;
//	int global = 2020;
//	printf("%d %d", global, local);//2020   2017
//	return 0;//当局部变量和全局变量同名时，局部变量优先
//}


//C语言中的常量分为
//字面常量
//const修饰的常变量
//#define定义的标识符常量
//枚举常量
//# include<stdio.h>
//enum sex
//{
//	MALE,//枚举常量
//	FEMALE,
//	SECRET
//
//};
//
//int main()
//{
//	int a = 3.14;//字面常量
//	int b = 15200;//字面常量
//	const float pai = 3.14f;//const修饰的常量
//    #define MAX 100;//define定义的标识符常量
//	return 0;
//}


//字符串+转义字符+注释
//字符串：结束标志是一个\0的转义字符，计算字符串长度时\0是结束标志，不算字符串内容

//转义字符：打印一个目录：c:\code\test.c
//#include<stdio.h>
//int main()
//{
//	printf("c:\code\test.c\n"); //打印结果是c:code  est.c
//	printf("c:\\code\\test.c\n");//打印结果是c:\code\test.c
//	return 0;
//}


//选择语句
//#include<stdio.h>
//int main()
//{
//	int coding = 0;
//	printf("你会敲代码吗？选择1或0\n");
//	scanf("%d", &coding);
//	if (coding == 1)
//	{
//		printf("坚持就会有好结果\n");
//
//	}
//	if (coding == 0)
//	{
//		printf("回家挖地球\n");
//
//	}
//	system("pause");
//	return 0;
//}

//
//循环语句
//#include<stdio.h>
//int main()
//{
//	printf("欢迎你\n");
//	int i = 0;
//	while (i <= 20)
//	{
//		i++;
//		printf("你好士兵\n");
//
//	}
//	return 0;
//}




//函数
//#include<stdio.h>
//int main()
//{
//	int num1 = 0;
//	int num2 = 0;
//	int sum = 0;
//	printf("请输入两个操作数：");
//	scanf("num1=%d,num2=%d", &num1, &num2);
//	sum = num1 + num2;
//	printf("sum=%d", sum);
//	system("pause");
//	return 0;
//}
//
////上述代码，写成函数如下：
//#include <stdio.h>
//int ADD(ingt x, int y)
//{
//	int z = x + y;
//	return z;
//}
//
//int main()
//{
//	int num1 = 0;
//	int num2 = 0;
//	int sum = 0;
//	printf("请输入两个操作数\n");
//	scanf("%d %d", &num1, &num2);
//	sum = ADD(x, y);
//	printf("sum=%d\n", sum);
//	return 0;
//}


//数组
//#include<stdio.h>
//int main()
//{
//	int i = 0;
//	int arr[10] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
//	for (i = 0; i <= 9; i++)
//	{
//		printf("%d", arr[i]);
//	}
//	printf("\n");
//	return 0;
//}


//关键字static:修饰变量和函数
//1.修饰局部变量
//2.修饰全局变量
//3.修饰函数

//#include<stdio.h>//修饰局部变量
//void test()
//{
//	int i = 0;
//	i++;
//	printf("%d", i);
//}
//int main()
//{
//	for (i = 0; i < 10; i++)
//	{
//		test();
//	}
//	return 0;
//}
//
//#include<stdio.h>
//void test()
//{
//	static int i = 0;
//	i++;
//	printf("%d",i);
//
//}
//
//
//int main()
//{
//	for (i = 0; i < 10; i++)
//	{
//		test();
//	}
//	return 0;
//}//结论：static修饰局部变量改变了变量的生命周期，让静态局部变量
//出了作用域依然存在，到程序结束，生命周期才结束

//
//int g_val = 2018;//代码1 运行正常
//int main()
//{
//	printf("%d\n", g_val);
//	return 0;
//}
//
//static g_val = 2018;//代码2 编译时会出现连接性错误
//int main()
//{
//	printf("%d\n", g_val);
//	return 0;
//}
//结论：一个全局变量被static修饰，使得这个全局变量只能在本源文件中使用，不能
//在其他原文件内使用


//修饰函数
//int ADD(int x, int y)//代码1  运行正常
//{
//	return x + y;
//}
//
//
//int main()
//{
//	printf("%d\n", ADD(2, 3));
//	return 0;
//
//}
//
//
//static int ADD(int x, int y)//代码2 编译时出现连接性错误
//{
//	return x + y;
//}
//
//int main()
//{
//
//	printf("%d\n", ADD(2, 3));
//	return 0;
//}
//结论：一个函数被static修饰，使得这个函数只能在本源文件中使用，不能再其他源文件内使用


//#define定义宏和常量

//#define MAX 100//define 定义标识符常量
//#define ADD(x,y)//define定义宏
//
//#include <stdio.h>
//int main()
//{
//	int sum = ADD(2, 3);
//	printf("sum=%d\n", sum);
//	sum = 10 * ADD(2, 3);
//	printf("sum=%d", sum);
//	return 0;
//}


//指针
//int main()
//{
//	int num = 10;
//	printf("%p", &num);//打印地址，%p
//	return 0;
//}
//
////地址存储：定义指针变量：
//int num = 10;
//int *p;
//p = &num;
//
//
//#include <stdio.h>
//int main()
//{
//	int num = 0;
//	int *p = &num;//整型指针
//	*p = 20;
//	return 0;
//}
//
//#include<stdio.h>
//int main()
//{
//	char ch = 'c';
//	char *pd = &ch;
//	*pd = 'm';
//	printf("%c\n", ch);//%c打印字符
//	return 0;
//
//}

//指针变量的大小
//#include <stdio.h>
//int main()
//{
//	printf("%d\n", sizeof(char *));//4
//	printf("%d\n", sizeof(int *));//4
//	printf("%d\n", sizeof(double *));//4
//	printf("%d\n", sizeof(short *));//4
//	return 0;
//}

//指针大小在32位平台是4个字节，64位平台是8个字节


//结构体 比如描述一个人的年龄性别
//struct Stu
//{
//	char name[20];
//	short age;
//	char id[15];
//};
//
//
////结构体的初始化；
////打印结构体信息：struct Stu s = {"张三"，20，20190502}；
////间接访问操作符.
//printf("name = %s age=%d id=%s", s.name, s, age, s, id);
//









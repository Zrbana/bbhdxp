#define _CRT_SECURE_NO_WARNINGS 1
//��һ��C���Գ���
//#include<stdio.h>
//int main()
//{
//	printf("Hello world!\n");
//	printf("����\n");
//	system("pause");
//	return 0;
//}



//��������
//int   char   short  long   longlong   float   double
//����ÿ���������͵Ĵ�С
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


//�ֲ�������ȫ�ֱ���
//#include<stdio.h>
//int global = 2018;
//int main()
//{
//	int local = 2017;
//	int global = 2020;
//	printf("%d %d", global, local);//2020   2017
//	return 0;//���ֲ�������ȫ�ֱ���ͬ��ʱ���ֲ���������
//}


//C�����еĳ�����Ϊ
//���泣��
//const���εĳ�����
//#define����ı�ʶ������
//ö�ٳ���
//# include<stdio.h>
//enum sex
//{
//	MALE,//ö�ٳ���
//	FEMALE,
//	SECRET
//
//};
//
//int main()
//{
//	int a = 3.14;//���泣��
//	int b = 15200;//���泣��
//	const float pai = 3.14f;//const���εĳ���
//    #define MAX 100;//define����ı�ʶ������
//	return 0;
//}


//�ַ���+ת���ַ�+ע��
//�ַ�����������־��һ��\0��ת���ַ��������ַ�������ʱ\0�ǽ�����־�������ַ�������

//ת���ַ�����ӡһ��Ŀ¼��c:\code\test.c
//#include<stdio.h>
//int main()
//{
//	printf("c:\code\test.c\n"); //��ӡ�����c:code  est.c
//	printf("c:\\code\\test.c\n");//��ӡ�����c:\code\test.c
//	return 0;
//}


//ѡ�����
//#include<stdio.h>
//int main()
//{
//	int coding = 0;
//	printf("����ô�����ѡ��1��0\n");
//	scanf("%d", &coding);
//	if (coding == 1)
//	{
//		printf("��־ͻ��кý��\n");
//
//	}
//	if (coding == 0)
//	{
//		printf("�ؼ��ڵ���\n");
//
//	}
//	system("pause");
//	return 0;
//}

//
//ѭ�����
//#include<stdio.h>
//int main()
//{
//	printf("��ӭ��\n");
//	int i = 0;
//	while (i <= 20)
//	{
//		i++;
//		printf("���ʿ��\n");
//
//	}
//	return 0;
//}




//����
//#include<stdio.h>
//int main()
//{
//	int num1 = 0;
//	int num2 = 0;
//	int sum = 0;
//	printf("������������������");
//	scanf("num1=%d,num2=%d", &num1, &num2);
//	sum = num1 + num2;
//	printf("sum=%d", sum);
//	system("pause");
//	return 0;
//}
//
////�������룬д�ɺ������£�
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
//	printf("����������������\n");
//	scanf("%d %d", &num1, &num2);
//	sum = ADD(x, y);
//	printf("sum=%d\n", sum);
//	return 0;
//}


//����
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


//�ؼ���static:���α����ͺ���
//1.���ξֲ�����
//2.����ȫ�ֱ���
//3.���κ���

//#include<stdio.h>//���ξֲ�����
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
//}//���ۣ�static���ξֲ������ı��˱������������ڣ��þ�̬�ֲ�����
//������������Ȼ���ڣ�������������������ڲŽ���

//
//int g_val = 2018;//����1 ��������
//int main()
//{
//	printf("%d\n", g_val);
//	return 0;
//}
//
//static g_val = 2018;//����2 ����ʱ����������Դ���
//int main()
//{
//	printf("%d\n", g_val);
//	return 0;
//}
//���ۣ�һ��ȫ�ֱ�����static���Σ�ʹ�����ȫ�ֱ���ֻ���ڱ�Դ�ļ���ʹ�ã�����
//������ԭ�ļ���ʹ��


//���κ���
//int ADD(int x, int y)//����1  ��������
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
//static int ADD(int x, int y)//����2 ����ʱ���������Դ���
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
//���ۣ�һ��������static���Σ�ʹ���������ֻ���ڱ�Դ�ļ���ʹ�ã�����������Դ�ļ���ʹ��


//#define�����ͳ���

//#define MAX 100//define �����ʶ������
//#define ADD(x,y)//define�����
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


//ָ��
//int main()
//{
//	int num = 10;
//	printf("%p", &num);//��ӡ��ַ��%p
//	return 0;
//}
//
////��ַ�洢������ָ�������
//int num = 10;
//int *p;
//p = &num;
//
//
//#include <stdio.h>
//int main()
//{
//	int num = 0;
//	int *p = &num;//����ָ��
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
//	printf("%c\n", ch);//%c��ӡ�ַ�
//	return 0;
//
//}

//ָ������Ĵ�С
//#include <stdio.h>
//int main()
//{
//	printf("%d\n", sizeof(char *));//4
//	printf("%d\n", sizeof(int *));//4
//	printf("%d\n", sizeof(double *));//4
//	printf("%d\n", sizeof(short *));//4
//	return 0;
//}

//ָ���С��32λƽ̨��4���ֽڣ�64λƽ̨��8���ֽ�


//�ṹ�� ��������һ���˵������Ա�
//struct Stu
//{
//	char name[20];
//	short age;
//	char id[15];
//};
//
//
////�ṹ��ĳ�ʼ����
////��ӡ�ṹ����Ϣ��struct Stu s = {"����"��20��20190502}��
////��ӷ��ʲ�����.
//printf("name = %s age=%d id=%s", s.name, s, age, s, id);
//









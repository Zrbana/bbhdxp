#define _CRT_SECURE_NO_WARNINGS 1
#include <stdio.h>
#include"game.h"
void menum()
{
	printf("************************\n");
	printf("*****1. ����Ϸ**********\n");
	printf("*****0 .�˳���Ϸ  ******\n");
	printf("************************\n");
}
void game()
{
	char board[ROW][COL] = { 0 };
	Init_board(board, ROW, COL);//��ʼ������
	DisplayBoard(board, ROW, COL);//��ӡ
	while (1)
	{
		PlayerMove(board, ROW, COL);//�����
		DisplayBoard(board, ROW, COL);//��ӡ
		if (Iswin(board, ROW, COL) == 'X')
		{
			printf("���Ӯ\n");
			break;
		}
		if (IFull(board, ROW, COL) == 1)
		{
			printf("ƽ��\n");
			break;
		}
		ComputerMove(board, ROW, COL);//������
		DisplayBoard(board, ROW, COL);//��ӡ
		if (Iswin(board, ROW, COL) == 'Y')
		{
			printf("����Ӯ\n");
			break;
		}
		if (IFull(board, ROW, COL) == 1)
		{
			printf("ƽ��\n");
			break;
		}
	}

}
void test()
{
	int i = 1;
	do
	{
		srand((unsigned)time(NULL));
		menum();
		printf("���������ѡ�� >");
		scanf("%d", &i);
		switch (i)
		{
		case 1:
			game();
			break;
		case 0:
			printf("�˳���Ϸ\n");
			break;
		default:
			printf("������������������\n");
			break;
		}
	} while (i);
}
int main()
{
	test();
	system("pause");
	return 0;
}












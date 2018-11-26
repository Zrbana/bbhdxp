#define _CRT_SECURE_NO_WARNINGS 1
#include "game.h"
#include <stdio.h>
#include <string.h>


#define _CRT_SECURE_NO_WARNINGS 1
#include"game.h"
void Init_board(char arr[ROW][COL], int  row, int  col)//��ʼ������
{
	int i = 0, j = 0;
	for (i = 0; i < row; i++)
	{
		for (j = 0; j < col; j++)
		{
			arr[i][j] = ' ';
		}
	}
}
void DisplayBoard(char arr[ROW][COL], int  row, int  col)//��ӡ
{
	int i = 0;
	int j = 0;
	for (i = 0; i < row; i++)
	{
		for (j = 0; j < col - 1; j++)
		{
			printf(" %c |", arr[i][j]);
		}
		printf(" %c \n", arr[i][j]);
		if (i < row - 1)
		{
			for (j = 0; j < col - 1; j++)
			{
				printf("---|");
			}
			printf("---");
		}
		printf("\n");
	}
}
void PlayerMove(char arr[ROW][COL], int  row, int  col)//�����
{
	int x = 0, y = 0;
	printf("����ߣ�");
	while (1)
	{
		scanf("%d %d", &x, &y);
		if ((x >= 1 && x <= row) && (y >= 1 && y <= col))
		{
			if (arr[x - 1][y - 1] == ' ')
			{
				arr[x - 1][y - 1] = 'X';
				break;
			}
		}
		printf("����������\n");
	}
}
void ComputerMove(char arr[ROW][COL], int  row, int  col)//������
{
	printf("�����ߣ�\n");
	while (1)
	{
		int x = rand() % ROW;
		int y = rand() % COL;
		if (arr[x][y] == ' ')
		{
			arr[x][y] = 'Y';
			break;
		}
	}
}
char Iswin(char arr[ROW][COL], int  row, int  col)//�ж���Ӯ
{
	int i = 0; int j = 0;
	for (i = 0; i < row; i++)//���ж�
	{
		int count = 0;
		for (j = 0; j <= col - num + 1; j++)
		{
			if (arr[i][j] == arr[i][j + 1] && arr[i][j] != ' ')
			{
				count++;
				if (count == num - 1)
				{
					return arr[i][j];
				}
			}

		}

	}
	for (j = 0; j < col; j++)
	{
		int count = 0;
		for (i = 0; i <= row - num + 1; i++)//�ж���
		{
			if (arr[i][j] == arr[i + 1][j] && arr[i][j] != ' ')
			{
				count++;
				if (count == num - 1)
				{
					return arr[i][j];
				}
			}
		}
	}
	for (i = 0; i <= row - num; i++)
	{
		int count = 0;
		int n = i;

		for (j = 0; j <= col - num + 1; j++)//�ж�б
		{
			for (int t = j; t <= col - num + 1; t++)
			{
				if (arr[n][t] == arr[n + 1][t + 1] && arr[n][t] != ' ')
				{
					n++;
					count++;
					if (count == num - 1)
					{
						return arr[n - 1][t];
					}
				}
			}
		}
	}
	for (i = 0; i <= row - num; i++)//�ж�б/
	{
		int count = 0;
		int n = i;
		for (j = num - 1; j >= col - num + 1; j--)
		{
			for (int t = j; t >= col - num + 1; t--)
			{
				if (arr[n][t] == arr[n + 1][t - 1] && arr[n][t] != ' ')
				{
					count++; n++;
					if (count == num - 1)
					{
						return arr[n - 1][t];
					}
				}
			}
		}
	}
}


int IFull(char arr[ROW][COL], int  row, int  col)////�ж�����
{
	int i = 0;
	int j = 0;
	for (i = 0; i < row; i++)
	{
		for (j = 0; j < col; j++)
		{
			if (arr[i][j] == ' ')
				return 0;
		}
	}
	return 1;
}


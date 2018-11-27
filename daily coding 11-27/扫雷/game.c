#define _CRT_SECURE_NO_WARNINGS 1
#include"game.h"




void set_time()//��ʱ
{
	printf("��ʱ:%u ��\n", clock() / CLOCKS_PER_SEC);
}
void init_board(char board[ROWS][COLS], int row, int col, char c)//��ʼ������
{
	memset(board, c, row*col*sizeof(board[0][0]));
}

void disp_board(char board[ROWS][COLS], int row, int col)//��ӡ����
{
	int i = 0;
	int j = 0;
	for (i = 0; i <= row; i++)//���к�
	{
		printf("%2d ", i);
	}
	printf("\n");
	for (i = 1; i <= row; i++)//���к�
	{
		printf("%2d ", i);
		for (j = 1; j <= col; j++)
		{
			printf("%2c ", board[i][j]);
		}
		printf("\n");
	}
	printf("\n");
}

void set_mine(char board[ROWS][COLS], int row, int col, int count)//����
{
	int x = 0;
	int y = 0;
	while (count)
	{
		x = rand() % row + 1;//���λ�÷�Χ1~row
		y = rand() % col + 1;//���λ�÷�Χ1~col
		if (board[x][y] == '0')//�ж��Ƿ�������
		{
			board[x][y] = '1';
			count--;
		}
	}
}

void safe_mine(char mine[ROWS][COLS], char print[ROWS][COLS], int x, int y, int row, int col)//��һ�����ײ�ը��
{
	char ch = 0;
	int ret = 1;
	int number = 0;
	if (mine[x][y] == '1')//��һ�βȵ��׺󲹾�
	{
		mine[x][y] = '0';
		char ch = count_mine(mine, x, y);
		print[x][y] = ch + '0';//���ֶ�Ӧ��ASCIIֵ�������ַ���Ӧ��ASCIIֵ���48����'0'��ASCIIֵ
		extend_board(mine, print, x, y);
		while (ret)//�������пյĵط�����һ����
		{
			int x = rand() % row + 1;//����1��row����������������±�Ϊ1��10�ķ�Χ�ڲ���
			int y = rand() % col + 1;//����1��col����������������±�Ϊ1��10�ķ�Χ�ڲ���
			if (mine[x][y] == '0')//�Ҳ����׵ĵط�����
			{
				mine[x][y] = '1';
				disp_board(print, row, col);
				//disp_board(mine, row, col);
				ret--;
				break;
			}
		}
	}
}


int count_mine(char mine[ROWS][COLS], int x, int y)//����
{
	return mine[x - 1][y] + mine[x - 1][y + 1] + mine[x][y + 1] + mine[x + 1][y + 1] + mine[x + 1][y] +
		mine[x + 1][y - 1] + mine[x][y - 1] + mine[x - 1][y - 1] - 8 * '0';//����ΧһȦ�˸�λ�õ�����
}

int count_print(char print[ROWS][COLS], int row, int col)//��δɨλ��
{
	int count = 0;
	int i = 0;
	for (i = 1; i <= row; i++)
	{
		int j = 0;
		for (j = 1; j <= col; j++)
		{
			if (print[i][j] == '@' || print[i][j] == '*')
			{
				count++;
			}
		}
	}
	return count;
}


void  extend_board(char mine[ROWS][COLS], char print[ROWS][COLS], int x, int y)//���õݹ���չ��Χ
{
	int n = 0;
	n = count_mine(mine, x, y);
	if (n == 0)//����λ����Χ����Ϊ0ʱ��չ
	{
		print[x][y] = ' ';//��չ��λ�ñ�Ϊ���ո񡱴�ӡ����
		if (mine[x - 1][y] == '0' && print[x - 1][y] == '@')
		{
			extend_board(mine, print, x - 1, y);//�ݹ�
		}
		if (mine[x + 1][y] == '0' && print[x + 1][y] == '@')
		{
			extend_board(mine, print, x + 1, y);
		}
		if (mine[x][y + 1] == '0' && print[x][y + 1] == '@')
		{
			extend_board(mine, print, x, y + 1);
		}
		if (mine[x - 1][y + 1] == '0' && print[x - 1][y + 1] == '@')
		{
			extend_board(mine, print, x - 1, y + 1);
		}
		if (mine[x + 1][y + 1] == '0' && print[x + 1][y + 1] == '@')
		{
			extend_board(mine, print, x + 1, y + 1);
		}
		if (mine[x][y - 1] == '0' && print[x][y - 1] == '@')
		{
			extend_board(mine, print, x, y - 1);
		}
		if (mine[x + 1][y - 1] == '0' && print[x + 1][y - 1] == '@')
		{
			extend_board(mine, print, x + 1, y - 1);
		}
		if (mine[x - 1][y - 1] == '0' && print[x - 1][y - 1] == '@')
		{
			extend_board(mine, print, x - 1, y - 1);
		}
	}
	else
		print[x][y] = n + '0';
}

int find_mine(char mine[ROWS][COLS], char print[ROWS][COLS], int row, int col, int count)//����
{
	int x = 0;
	int y = 0;
	int number = 0;
	int ret = 0;
	while (1)
	{
		printf("��������ɨ��\n");
		scanf("%d%d", &x, &y);//�������ɨ�׵�����λ��
		if ((x >= 1 && x <= row) && (y >= 1 && y <= col))//�ж����������Ƿ��������������������
		{
			if (mine[x][y] == '0')//û�ȵ���
			{
				number++;//��¼ɨ�׵Ĵ���
				char ch = count_mine(mine, x, y);//������
				print[x][y] = ch + '0';//���ֶ�Ӧ��ASCIIֵ�������ַ���Ӧ��ASCIIֵ���48����'0'��ASCIIֵ
				extend_board(mine, print, x, y);
				//      disp_board(mine, row, col);
				disp_board(print, row, col);
				if (count_print(print, row, col) == count)//ʣ��δɨλ��=���� ʱʤ��
				{
					return 0;
				}
				to_sign(print);//�ж��Ƿ���
				disp_board(print, row, col);
			}
			else if (mine[x][y] == '1')//�ȵ���
			{
				if (ret == 0 && number == 0)
				{
					ret++;
					safe_mine(mine, print, x, y, row, col);
				}
				else
					return 1;
			}
		}
		else
		{
			printf("�������!����������\n");
		}
	}
}


void sign(char board[ROWS][COLS], int x, int y)//�á�*�������
{
	if (board[x][y] == '@')
	{
		board[x][y] = '*';
	}
}

void unsign(char board[ROWS][COLS], int x, int y)//ȡ�����
{
	if (board[x][y] == '*')
	{
		board[x][y] = '@';
	}
}
void to_sign(char board[ROWS][COLS])//�ж��Ƿ���
{
	int chose_b = 0;
	int x = 0;
	int y = 0;
	printf("�Ƿ���Ҫ���/ȡ�����:>\n(1.���  ��2.ȡ�����  ��3.�����ò���) :>");
	scanf("%d", &chose_b);
	do{
		switch (chose_b)
		{
		case 1:
		{
				  printf("��������Ҫ��ǵ�λ������:>\n");
				  scanf("%d%d", &x, &y);
				  sign(board, x, y);
				  break;
		}
		case 2:
		{
				  printf("������ȡ����ǵ�λ������:>\n");
				  scanf("%d%d", &x, &y);
				  unsign(board, x, y);
				  break;
		}
		case 3:
		{
				  printf("�����˲��衣\n");
				  chose_b = 0;
				  break;
		}
		default:
		{         printf("�������\n");
		chose_b = 0;
		break;
		}
		}
		chose_b = 0;
	} while (chose_b);
}

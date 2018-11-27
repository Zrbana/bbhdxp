#define _CRT_SECURE_NO_WARNINGS 1
#include"game.h"




void set_time()//计时
{
	printf("用时:%u 秒\n", clock() / CLOCKS_PER_SEC);
}
void init_board(char board[ROWS][COLS], int row, int col, char c)//初始化雷盘
{
	memset(board, c, row*col*sizeof(board[0][0]));
}

void disp_board(char board[ROWS][COLS], int row, int col)//打印雷盘
{
	int i = 0;
	int j = 0;
	for (i = 0; i <= row; i++)//加行号
	{
		printf("%2d ", i);
	}
	printf("\n");
	for (i = 1; i <= row; i++)//加列号
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

void set_mine(char board[ROWS][COLS], int row, int col, int count)//置雷
{
	int x = 0;
	int y = 0;
	while (count)
	{
		x = rand() % row + 1;//随机位置范围1~row
		y = rand() % col + 1;//随机位置范围1~col
		if (board[x][y] == '0')//判断是否已有雷
		{
			board[x][y] = '1';
			count--;
		}
	}
}

void safe_mine(char mine[ROWS][COLS], char print[ROWS][COLS], int x, int y, int row, int col)//第一次排雷不炸死
{
	char ch = 0;
	int ret = 1;
	int number = 0;
	if (mine[x][y] == '1')//第一次踩到雷后补救
	{
		mine[x][y] = '0';
		char ch = count_mine(mine, x, y);
		print[x][y] = ch + '0';//数字对应的ASCII值和数字字符对应的ASCII值相差48，即'0'的ASCII值
		extend_board(mine, print, x, y);
		while (ret)//在其余有空的地方设置一个雷
		{
			int x = rand() % row + 1;//产生1到row的随机数，在数组下标为1到10的范围内布雷
			int y = rand() % col + 1;//产生1到col的随机数，在数组下标为1到10的范围内布雷
			if (mine[x][y] == '0')//找不是雷的地方布雷
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


int count_mine(char mine[ROWS][COLS], int x, int y)//数雷
{
	return mine[x - 1][y] + mine[x - 1][y + 1] + mine[x][y + 1] + mine[x + 1][y + 1] + mine[x + 1][y] +
		mine[x + 1][y - 1] + mine[x][y - 1] + mine[x - 1][y - 1] - 8 * '0';//数周围一圈八个位置的雷数
}

int count_print(char print[ROWS][COLS], int row, int col)//数未扫位置
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


void  extend_board(char mine[ROWS][COLS], char print[ROWS][COLS], int x, int y)//运用递归扩展周围
{
	int n = 0;
	n = count_mine(mine, x, y);
	if (n == 0)//当该位置周围雷数为0时扩展
	{
		print[x][y] = ' ';//扩展的位置变为“空格”打印出来
		if (mine[x - 1][y] == '0' && print[x - 1][y] == '@')
		{
			extend_board(mine, print, x - 1, y);//递归
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

int find_mine(char mine[ROWS][COLS], char print[ROWS][COLS], int row, int col, int count)//排雷
{
	int x = 0;
	int y = 0;
	int number = 0;
	int ret = 0;
	while (1)
	{
		printf("输入坐标扫雷\n");
		scanf("%d%d", &x, &y);//玩家输入扫雷的坐标位置
		if ((x >= 1 && x <= row) && (y >= 1 && y <= col))//判断输入坐标是否有误，输入错误重新输入
		{
			if (mine[x][y] == '0')//没踩到雷
			{
				number++;//记录扫雷的次数
				char ch = count_mine(mine, x, y);//数雷数
				print[x][y] = ch + '0';//数字对应的ASCII值和数字字符对应的ASCII值相差48，即'0'的ASCII值
				extend_board(mine, print, x, y);
				//      disp_board(mine, row, col);
				disp_board(print, row, col);
				if (count_print(print, row, col) == count)//剩余未扫位置=雷数 时胜利
				{
					return 0;
				}
				to_sign(print);//判断是否标记
				disp_board(print, row, col);
			}
			else if (mine[x][y] == '1')//踩到雷
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
			printf("输入错误!请重新输入\n");
		}
	}
}


void sign(char board[ROWS][COLS], int x, int y)//用‘*’标记雷
{
	if (board[x][y] == '@')
	{
		board[x][y] = '*';
	}
}

void unsign(char board[ROWS][COLS], int x, int y)//取消标记
{
	if (board[x][y] == '*')
	{
		board[x][y] = '@';
	}
}
void to_sign(char board[ROWS][COLS])//判断是否标记
{
	int chose_b = 0;
	int x = 0;
	int y = 0;
	printf("是否需要标记/取消标记:>\n(1.标记  ；2.取消标记  ；3.跳过该步骤) :>");
	scanf("%d", &chose_b);
	do{
		switch (chose_b)
		{
		case 1:
		{
				  printf("请输入需要标记的位置坐标:>\n");
				  scanf("%d%d", &x, &y);
				  sign(board, x, y);
				  break;
		}
		case 2:
		{
				  printf("请输入取消标记的位置坐标:>\n");
				  scanf("%d%d", &x, &y);
				  unsign(board, x, y);
				  break;
		}
		case 3:
		{
				  printf("跳过此步骤。\n");
				  chose_b = 0;
				  break;
		}
		default:
		{         printf("输入错误！\n");
		chose_b = 0;
		break;
		}
		}
		chose_b = 0;
	} while (chose_b);
}

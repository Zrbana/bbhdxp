#define _CRT_SECURE_NO_WARNINGS 1
#include "game.h"


void menu()
{
	printf("+---------------------------------+\n");
	printf("+      欢迎来到扫雷游戏 ！        +\n");
	printf("+           1、play               +\n");
	printf("+           0、exit               +\n");
	printf("+---------------------------------+\n");
}

void game()
{
	char mine[ROWS][COLS] = { 0 };
	char print[ROWS][COLS] = { 0 };
	int chose_m = 0;
	int ret = 0;
	printf("请选择模式（1、简单 2、困难）:>");//选择游戏难易程度，产生不同大小的棋盘和雷数
	scanf("%d", &chose_m);
	switch (chose_m)
	{
	case 1:
	{
			  init_board(mine, ROWS, COLS, '0');//初始化雷盘
			  init_board(print, ROWS, COLS, '@');
			  set_mine(mine, _ROW, _COL, EASY_COUNT);//布雷
			  disp_board(print, _ROW, _COL);//打印雷盘
			  int ret = find_mine(mine, print, _ROW, _COL, EASY_COUNT);//扫雷,踩到雷返回1，没有踩到雷返回0
			  while (1)//循环扫雷
			  {
				  if (ret == 0)//若返回0则胜利
				  {
					  disp_board(print, _ROW, _COL);
					  printf("恭喜你排雷成功！\n");
					  break;
				  }
				  if (ret)//若返回1则失败
				  {
					  disp_board(mine, _ROW, _COL);//打印雷盘
					  printf("你被炸死咯!\n");
					  break;
				  }
				  disp_board(print, _ROW, _COL);//打印玩家棋盘
			  }
			  break;
	}
	case 2:
	{
			  init_board(mine, ROWS, COLS, '0');//初始化雷盘
			  init_board(print, ROWS, COLS, '@');
			  set_mine(mine, ROW, COL, HARD_COUNT);//布雷
			  //        disp_board(mine, ROW, COL);//打印雷盘
			  disp_board(print, ROW, COL);
			  while (1)//循环扫雷
			  {
				  int ret = find_mine(mine, print, ROW, COL, HARD_COUNT);//扫雷,踩到雷返回1，没有踩到雷返回0
				  if (ret == 0)//若返回0胜利
				  {
					  disp_board(print, ROW, COL);
					  printf("排雷成功！\n");
					  break;
				  }
				  if (ret)//若返回1失败
				  {
					  disp_board(mine, ROW, COL);//打印雷盘
					  printf("你被炸死了\n");
					  break;
				  }
				  disp_board(print, ROW, COL);//打印玩家棋盘
			  }
			  break;
	}
	default:
	{
			   printf("输入错误！\n");
			   break;
	}
	}
}
void test()
{
	srand((unsigned int)time(NULL));//产生随机值发生器
	int chose = 0;//选择是否开始游戏
	do
	{
		menu();//菜单
		printf("请选择:>");
		scanf("%d", &chose);
		switch (chose)
		{
		case 1:
			game();//开始游戏
			break;
		case 0:
			printf("退出游戏\n");
			break;
		default:
			printf("输入错误，没有该选项\n");
			break;
		}
	} while (chose);
}
int main()
{
	test();
	system("pause");
	return 0;
}


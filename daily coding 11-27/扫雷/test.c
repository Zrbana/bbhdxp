#define _CRT_SECURE_NO_WARNINGS 1
#include "game.h"


void menu()
{
	printf("+---------------------------------+\n");
	printf("+      ��ӭ����ɨ����Ϸ ��        +\n");
	printf("+           1��play               +\n");
	printf("+           0��exit               +\n");
	printf("+---------------------------------+\n");
}

void game()
{
	char mine[ROWS][COLS] = { 0 };
	char print[ROWS][COLS] = { 0 };
	int chose_m = 0;
	int ret = 0;
	printf("��ѡ��ģʽ��1���� 2�����ѣ�:>");//ѡ����Ϸ���׳̶ȣ�������ͬ��С�����̺�����
	scanf("%d", &chose_m);
	switch (chose_m)
	{
	case 1:
	{
			  init_board(mine, ROWS, COLS, '0');//��ʼ������
			  init_board(print, ROWS, COLS, '@');
			  set_mine(mine, _ROW, _COL, EASY_COUNT);//����
			  disp_board(print, _ROW, _COL);//��ӡ����
			  int ret = find_mine(mine, print, _ROW, _COL, EASY_COUNT);//ɨ��,�ȵ��׷���1��û�вȵ��׷���0
			  while (1)//ѭ��ɨ��
			  {
				  if (ret == 0)//������0��ʤ��
				  {
					  disp_board(print, _ROW, _COL);
					  printf("��ϲ�����׳ɹ���\n");
					  break;
				  }
				  if (ret)//������1��ʧ��
				  {
					  disp_board(mine, _ROW, _COL);//��ӡ����
					  printf("�㱻ը����!\n");
					  break;
				  }
				  disp_board(print, _ROW, _COL);//��ӡ�������
			  }
			  break;
	}
	case 2:
	{
			  init_board(mine, ROWS, COLS, '0');//��ʼ������
			  init_board(print, ROWS, COLS, '@');
			  set_mine(mine, ROW, COL, HARD_COUNT);//����
			  //        disp_board(mine, ROW, COL);//��ӡ����
			  disp_board(print, ROW, COL);
			  while (1)//ѭ��ɨ��
			  {
				  int ret = find_mine(mine, print, ROW, COL, HARD_COUNT);//ɨ��,�ȵ��׷���1��û�вȵ��׷���0
				  if (ret == 0)//������0ʤ��
				  {
					  disp_board(print, ROW, COL);
					  printf("���׳ɹ���\n");
					  break;
				  }
				  if (ret)//������1ʧ��
				  {
					  disp_board(mine, ROW, COL);//��ӡ����
					  printf("�㱻ը����\n");
					  break;
				  }
				  disp_board(print, ROW, COL);//��ӡ�������
			  }
			  break;
	}
	default:
	{
			   printf("�������\n");
			   break;
	}
	}
}
void test()
{
	srand((unsigned int)time(NULL));//�������ֵ������
	int chose = 0;//ѡ���Ƿ�ʼ��Ϸ
	do
	{
		menu();//�˵�
		printf("��ѡ��:>");
		scanf("%d", &chose);
		switch (chose)
		{
		case 1:
			game();//��ʼ��Ϸ
			break;
		case 0:
			printf("�˳���Ϸ\n");
			break;
		default:
			printf("�������û�и�ѡ��\n");
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


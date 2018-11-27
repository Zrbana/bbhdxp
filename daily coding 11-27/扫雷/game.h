

#ifndef   _GAME_H_
#define   _GAME_H_
//�õ���ͷ�ļ�
#include<stdio.h>
#include<stdlib.h>
#include<time.h>
#include<string.h>
#include<windows.h>
//�����ӡ�������С���
#define _ROW 9
#define _COL 9
#define ROW  16
#define COL  16
//����������С���
#define _ROWS _ROW+2
#define _COLS _COL+2
#define ROWS ROW+2
#define COLS COL+2
//�����ѡ��׳̶�����
#define EASY_COUNT 10
#define HARD_COUNT 40
//������Ϸ�еĺ���
void init_board(char board[ROWS][COLS], int row, int col, char c);//��ʼ��
void disp_board(char board[ROWS][COLS], int row, int col);//��ӡ
void set_mine(char board[ROWS][COLS], int row, int col, int count);//����
void safe_mine(char mine[ROWS][COLS], char print[ROWS][COLS], int x, int y, int row, int col);//��һ�����ײ�ը��
int find_mine(char mine[ROWS][COLS], char print[ROWS][COLS], int row, int col, int count);//����
int count_mine(char mine[ROWS][COLS], int x, int y);//����
void extend_board(char mine[ROWS][COLS], char print[ROWS][COLS], int x, int y);//��չ
void to_sign(char board[ROWS][COLS]);//�ж��Ƿ���
void sign(char board[ROWS][COLS], int x, int y);//���
void unsign(char board[ROWS][COLS], int x, int y);//ȡ�����
int count_print(char print[ROWS][COLS], int row, int col);//��δɨλ��
void menu();
#endif//_GAME_H_


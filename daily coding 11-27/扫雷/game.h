

#ifndef   _GAME_H_
#define   _GAME_H_
//用到的头文件
#include<stdio.h>
#include<stdlib.h>
#include<time.h>
#include<string.h>
#include<windows.h>
//定义打印的雷盘行、列
#define _ROW 9
#define _COL 9
#define ROW  16
#define COL  16
//定义数组的行、列
#define _ROWS _ROW+2
#define _COLS _COL+2
#define ROWS ROW+2
#define COLS COL+2
//定义难、易程度雷数
#define EASY_COUNT 10
#define HARD_COUNT 40
//定义游戏中的函数
void init_board(char board[ROWS][COLS], int row, int col, char c);//初始化
void disp_board(char board[ROWS][COLS], int row, int col);//打印
void set_mine(char board[ROWS][COLS], int row, int col, int count);//置雷
void safe_mine(char mine[ROWS][COLS], char print[ROWS][COLS], int x, int y, int row, int col);//第一次排雷不炸死
int find_mine(char mine[ROWS][COLS], char print[ROWS][COLS], int row, int col, int count);//排雷
int count_mine(char mine[ROWS][COLS], int x, int y);//数雷
void extend_board(char mine[ROWS][COLS], char print[ROWS][COLS], int x, int y);//扩展
void to_sign(char board[ROWS][COLS]);//判断是否标记
void sign(char board[ROWS][COLS], int x, int y);//标记
void unsign(char board[ROWS][COLS], int x, int y);//取消标记
int count_print(char print[ROWS][COLS], int row, int col);//数未扫位置
void menu();
#endif//_GAME_H_




#define _CRT_SECURE_NO_WARNINGS 1
#ifndef _GAME_H_
#define _GAME_H_

#define ROW 3//���̴�С
#define COL 3//���̴�С
#define num 3//�жϼ�����
#include<stdio.h>
#include<time.h>
#include<stdlib.h>
#include<string.h>

void Init_board(char arr[ROW][COL], int  row, int  col);//��ʼ������
void DisplayBoard(char arr[ROW][COL], int  row, int  col);//��ӡ
void PlayerMove(char arr[ROW][COL], int  row, int  col);//�����
void ComputerMove(char arr[ROW][COL], int  row, int  col);//������
char Iswin(char arr[ROW][COL], int  row, int  col);//�ж���Ӯ
int IFull(char arr[ROW][COL], int  row, int  col);//�ж���
#endif
//이석원은 조규현과 백승환에게 상대편 마린(류재명)의 위치를 계산하라는 명령을 내렸다.
//조규현과 백승환은 각각 자신의 터렛 위치에서 현재 적까지의 거리를 계산했다.
//
//조규현의 좌표(x1, y1)와 백승환의 좌표(x2, y2)가 주어지고,
//조규현이 계산한 류재명과의 거리 r1과 백승환이 계산한 류재명과의 거리 r2가 주어졌을 때,
//류재명이 있을 수 있는 좌표의 수를 출력하는 프로그램을 작성하시오.

#include <stdio.h>
#include <math.h>

int main() {

	int x_1, y_1, r_1, x_2, y_2, r_2;

	scanf("%d %d %d %d %d %d", &x_1, &y_1, &r_1, &x_2, &y_2, &r_2);
	double dist = sqrt(pow(x_2 - x_1, 2.0) + pow(y_2 - y_1, 2.0));
	if (x_1 == x_2 && y_1 == y_2) {
		if (r_1 == r_2)
			printf("-1\n");
		else
			printf("0\n");
	}
	else {
		if (r_1 + r_2 > dist && abs(r_2 - r_1) < dist)
			printf("2\n");
		else if (r_1 + r_2 == dist || abs(r_2 - r_1) == dist)
			printf("1\n");
		else
			printf("0\n");
	}
	return 0;
}
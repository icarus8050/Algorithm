#include <stdio.h>

void swap(int * x, int * y);
void sort(int list[]);
int main() {
	int list[10] = { 5, 19, 529, 1, 21, 5, 12, 0, 10, 2 };

	sort(list);

	for (int i = 0; i < 10; i++) {
		printf("%d ", list[i]);
	}
	printf("\n");
	getchar();
}

void swap(int * x, int * y) {
	
	int temp = *x;
	*x = *y;
	*y = temp;
}

void sort(int list[]) {
	int min;

	for (int i = 0; i < 9; i++) {
		min = i;

		for (int j = i + 1; j < 10; j++) {
			if (list[j] < list[min])
				min = j;
		}
		swap(&list[i], &list[min]);
	}
}
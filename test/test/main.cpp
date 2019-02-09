#include <stdio.h>
int zero_count = 0;
int one_count = 0;
void fibonacci(int n) {
	if (n == 0) {
		zero_count++;
	}
	else if (n == 1) {
		one_count++;
	}
	else {
		fibonacci(n - 1); fibonacci(n - 2);
	}
}
int main() {
	int test, input[100], i;
	scanf("%d", &test);
	for(i = 0; i < test; i++) {
		scanf("%d", &input[i]);
	}
	for (i = 0; i < test; i++) {
		fibonacci(input[i]);
		printf("%d %d\n", zero_count, one_count);
		zero_count = 0; one_count = 0;
	}

	return 0;
}
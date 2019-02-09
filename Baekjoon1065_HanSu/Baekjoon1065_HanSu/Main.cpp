#include <iostream>
#include <vector>

using namespace std;

int main() {
	int n, d, testCase;
	vector<int> unit;
	int result = 0;

	cin >> n;

	for (int i = 1; i <= n; i++) {
		if (i < 100) result++;
		else {
			bool flag = true;
			testCase = i;
			while (testCase > 0) {
				unit.push_back(testCase % 10);
				testCase /= 10;
			}
			d = unit[0] - unit[1];
			for (int j = 0; j < unit.size() - 1; j++) {
				if (unit[j + 1] != unit[j] - d) {
					flag = false;
					break;
				}
			}
			if (flag) result++;
			unit.clear();
		}
	}

	cout << result << endl;
}
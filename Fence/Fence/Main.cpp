#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int searchMaxArea(int left, int right);
vector<int> fenceHeight;
int main() {
	int testCase;

	cin >> testCase;
	if (testCase > 50) exit(0);
	 
	for (int i = 0; i < testCase; i++) {
		int N;	//판자 개수
		cin >> N;
		fenceHeight = vector<int>(N);	//판자 높이를 저장하는 변수
		for (int j = 0; j < N; j++) {
			cin >> fenceHeight[j];
		}
		cout << searchMaxArea(0, fenceHeight.size() - 1) << endl;
	}
}

int searchMaxArea(int left, int right) {
	if (left == right) return fenceHeight[left];

	int mid = (left + right) / 2;
	int largest = max(searchMaxArea(left, mid), searchMaxArea(mid + 1, right));
	int lo = mid, hi = mid;
	int height = fenceHeight[mid];

	while (left < lo || right > hi) {
		if (left < lo && (right == hi || fenceHeight[lo - 1] > fenceHeight[hi + 1])) {
			lo--;
			height = min(height, fenceHeight[lo]);
		}
		else {
			hi++;
			height = min(height, fenceHeight[hi]);
		}
		largest = max(largest, height * (hi - lo + 1));
	}
	return largest;
}
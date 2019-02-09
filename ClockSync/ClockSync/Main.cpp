#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

#define INF 9999
#define SWITCHES 10
#define CLOCKS 16

const int linked[SWITCHES][CLOCKS] = {
	{1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
	{0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0},
	{0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1},
	{1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
	{0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 0, 0},
	{1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
	{0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
	{0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1},
	{0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
	{0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0}
};

void push(vector<int> & clocks, int swtch);
bool areAligned(vector<int> & clocks);
int solve(vector<int> & clocks, int swtch);

int main() {
	int testCase;
	vector<int> clocks(CLOCKS);
	cin >> testCase;
	if (testCase > 30)
		exit(-1);

	for (int i = 0; i < testCase; i++) {
		for (int j = 0; j < CLOCKS; j++) {
			cin >> clocks[j];
		}

		int result = solve(clocks, 0);
		if (result == INF)
			cout << -1 << endl;
		else
			cout << result << endl;
	}
}

int solve(vector<int> & clocks, int swtch) {
	if (swtch == SWITCHES) return areAligned(clocks) ? 0 : INF;

	int result = INF;

	for (int count = 0; count < 4; count++) {
		result = min(result, count + solve(clocks, swtch + 1));
		push(clocks, swtch);
	}
	return result;
}

void push(vector<int> & clocks, int swtch) {
	for (int i = 0; i < CLOCKS; i++) {
		if (linked[swtch][i] == 1) {
			clocks[i] += 3;
			if (clocks[i] == 15)
				clocks[i] = 3;
		}
	}
}

bool areAligned(vector<int> & clocks) {
	for (int i = 0; i < CLOCKS; i++) {
		if (clocks[i] != 12) return false;
	}
	return true;
}
#include <iostream>

using namespace std;

int N, M;					//N은 학생 수, M은 친구 쌍의 수
bool areFriends[10][10];	//둘 사이의 친구 관계를 표현하기 위한 2차원 배열
bool havePair[10];			//아직 짝이 없는 친구를 표시할 배열 변수
int countCase(bool [10]);

int main() {
	int testCaseCount;
	cin >> testCaseCount;

	for (int t = 0; t < testCaseCount; t++) {
		for (int i = 0; i < 10; i++) {
			havePair[i] = false;
			for (int j = 0; j < 10; j++) {
				areFriends[i][j] = false;
			}
		}

		cin >> N >> M;

		for (int i = 0; i < M; i++) {
			int a, b;
			cin >> a >> b;
			areFriends[a][b] = areFriends[b][a] = true;
		}

		cout << "경우의 수 : " << countCase(havePair) << endl;
	}
}

int countCase(bool havePair[10]) {
	//아직 짝이 없는 사람중에 번호가 가장 빠른 사람
	int first = -1;
	for (int i = 0; i < N; i++)
	{
		if (!havePair[i])
		{
			first = i;
			break;
		}
	}

	if (first == -1) return 1;
	int result = 0;

	for (int i = first + 1; i < N; i++)
	{
		if (!havePair[i] && areFriends[first][i])
		{
			havePair[first] = havePair[i] = true;
			result += countCase(havePair);
			havePair[first] = havePair[i] = false;
		}
	}
	return result;
}
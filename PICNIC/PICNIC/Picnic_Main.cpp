#include <iostream>

using namespace std;

int N, M;					//N�� �л� ��, M�� ģ�� ���� ��
bool areFriends[10][10];	//�� ������ ģ�� ���踦 ǥ���ϱ� ���� 2���� �迭
bool havePair[10];			//���� ¦�� ���� ģ���� ǥ���� �迭 ����
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

		cout << "����� �� : " << countCase(havePair) << endl;
	}
}

int countCase(bool havePair[10]) {
	//���� ¦�� ���� ����߿� ��ȣ�� ���� ���� ���
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
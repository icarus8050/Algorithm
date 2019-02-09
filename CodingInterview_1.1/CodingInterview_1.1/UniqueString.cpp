#include <iostream>
#include <string>

using namespace std;
bool isUnique(string str);

int main() {
	string str;
	bool check;
	getline(cin, str);

	check = isUnique(str);

	if (check)
		cout << "Is unique!!" << endl;
	else
		cout << "Is not unique.." << endl;

	return 0;
}

bool isUnique(string str) {
	bool checksum[52] = { false };

	for (int i = 0; i < str.length(); i++) {
		int val = str[i] - 'A';
		
		if (val >= 32)
			val -= 6;

		if (checksum[val] != false)
			return false;
		else
			checksum[val] = true;
	}
	return true;
}
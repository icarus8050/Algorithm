#include <iostream>
#include <string>

using namespace std;

void changeStr(string * str);

int main() {
	string str;

	cout << "�Է� : ";
	getline(cin, str);
	changeStr(&str);
	cout << "��� : " << str << endl;

	return 0;
}

void changeStr(string * str) {
	int length = str->length();
	string result;

	for (int i = 0; i < length; i++) {
		if ((*str)[i] == ' ')
			result += "%20";
		else
			result += (*str)[i];
	}
	*str = result;
}
#include <iostream>
#include <string>
using namespace std;

string reverse_QuadTree(string::iterator & it);

int main() {
	
	int testCase;

	cin >> testCase;
	if (testCase < 0 || testCase > 50) exit(0);

	for (int i = 0; i < testCase; i++) {
		string quadTree;

		cin >> quadTree;
		string::iterator it = quadTree.begin();
		cout << reverse_QuadTree(it) << endl;
	}
}

string reverse_QuadTree(string::iterator & it) {
	char head = *it;
	it++;

	if (head == 'w' || head == 'b')
		return string(1, head);
	string secondQuadrant = reverse_QuadTree(it);	//2사분면
	string firstQuadrant = reverse_QuadTree(it);	//1사분면
	string thirdQuadrant = reverse_QuadTree(it);	//3사분면
	string fourthQuadrant = reverse_QuadTree(it);	//4사분면

	return string("x") + thirdQuadrant + fourthQuadrant + secondQuadrant + firstQuadrant;
}
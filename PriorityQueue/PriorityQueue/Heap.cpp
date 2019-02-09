#include <iostream>
#define HEAP_SIZE 100001

using namespace std;

class Heap{

private:
	int heapArr[HEAP_SIZE] = { 0 };
	int pos;

	int which_prior_child(int index) {
		int left_child = index * 2;
		int right_child = index * 2 + 1;

		if (left_child > pos)
			return 0;
		else if (left_child == pos)
			return left_child;
		else {
			if (heapArr[left_child] < heapArr[right_child])
				return right_child;
			else
				return left_child;
		}
	}

public:
	Heap():pos(0) {}

	int pop()
	{
		if (pos == 0)
			return 0;

		int current = 1;
		int child;
		int result = heapArr[current];

		while (child = which_prior_child(current)) {
			if (heapArr[pos] >= heapArr[child])
				break;
			heapArr[current] = heapArr[child];
			current = child;
		}

		heapArr[current] = heapArr[pos];
		pos--;
		return result;
	}

	void push(int data) {
		int index = pos + 1;
		
		while (index != 1) {
			int parent_index = index / 2;

			if (data > heapArr[parent_index]) {
				heapArr[index] = heapArr[parent_index];
				index = parent_index;
			}
			else
				break;
		}
		
		heapArr[index] = data;
		pos++;
	}
};

int main() {
	Heap heap;

	int n;

	cin >> n;
	while (n--) {
		int num;
		cin >> num;
		if (num) heap.push(num);
		else cout << heap.pop() << endl;
	}
}

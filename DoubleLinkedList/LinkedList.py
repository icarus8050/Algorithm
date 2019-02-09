class Node:
    def __init__(self, data):
        self.data = data
        self.next = None
        self.prev = None

class LinkedList:

    def __init__(self):
        dummy = Node(None)
        self.head = dummy
        self.tail = dummy

    def append(self, data):
        new_node = Node(data)
        self.tail.next = new_node
        new_node.prev = self.tail
        self.tail = new_node

    def delete(self):
        if self.head == self.tail:
            return -1
        pop_data = self.tail.data
        self.tail = self.tail.prev
        self.tail.next = None
        return pop_data

    def print_list(self):
        if self.head == self.tail:
            print("is empty")
        current = self.head.next
        while current is not None:
            print(current.data)
            current = current.next





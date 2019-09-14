#!/bin/python3
from collections import Counter


#
# Complete the 'pickingNumbers' function below.
#
# The function is expected to return an INTEGER.
# The function accepts INTEGER_ARRAY a as parameter.
#

def pickingNumbers(a):
    numSet = sorted(Counter(a).items())
    res = 0

    for i in range(0, len(numSet)):
        cnt = numSet[i][1]

        if i + 1 < len(numSet) and numSet[i + 1][0] - numSet[i][0] == 1:
            cnt += numSet[i + 1][1]

        res = max(res, cnt)

    return res


if __name__ == '__main__':

    n = int(input().strip())

    a = list(map(int, input().rstrip().split()))

    result = pickingNumbers(a)

    print(result)

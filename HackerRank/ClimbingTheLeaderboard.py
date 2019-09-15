#!/bin/python3

import math
import os
import random
import re
import sys


# Complete the climbingLeaderboard function below.
def climbingLeaderboard(scores, alice):
    res = []

    scoresSet = sorted(set(scores), reverse=True)

    for aliceScore in alice:
        if aliceScore >= scoresSet[0]:
            res.append(1)
        elif aliceScore < scoresSet[len(scoresSet) - 1]:
            res.append(len(scoresSet) + 1)
        else:
            res.append(binarySearch(scoresSet, aliceScore))

    return res


def binarySearch(arr, value):
    left = 0
    right = len(arr) - 1

    while right >= left:
        mid = (left + right) // 2

        if arr[mid] == value:
            return mid + 1
        elif arr[mid] > value and arr[mid + 1] < value:
            return mid + 2
        elif arr[mid] < value and arr[mid - 1] > value:
            return mid + 1
        elif arr[mid] > value:
            left = mid + 1
        else:
            right = mid - 1

    return -1


if __name__ == '__main__':
    scores_count = int(input())

    scores = list(map(int, input().rstrip().split()))

    alice_count = int(input())

    alice = list(map(int, input().rstrip().split()))

    result = climbingLeaderboard(scores, alice)

    print('\n'.join(map(str, result)))

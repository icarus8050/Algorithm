#!/bin/python3

import math
import os
import random
import re
import sys


# Complete the climbingLeaderboard function below.
def climbingLeaderboard(scores, alice):
    res = []

    scoresList = sorted(set(scores), reverse=True)

    for aliceScore in alice:
        rank = 1

        for score in scoresList:
            if aliceScore >= score:
                break

            rank += 1

        res.append(rank)

    return res


if __name__ == '__main__':
    scores_count = int(input())

    scores = list(map(int, input().rstrip().split()))

    alice_count = int(input())

    alice = list(map(int, input().rstrip().split()))

    result = climbingLeaderboard(scores, alice)

    print('\n'.join(map(str, result)))

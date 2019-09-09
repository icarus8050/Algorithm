if __name__ == '__main__':
    n = int(input())
    dp = [0] * (n + 1)

    dp[0] = dp[1] = 0

    for i in range(2, n + 1):
        if i % 3 is 0:
            dp[i] = min(dp[i // 3], dp[i - 1]) + 1
        elif i % 2 is 0:
            dp[i] = min(dp[i // 2], dp[i - 1]) + 1
        else:
            dp[i] = dp[i - 1] + 1

    print(dp[n])

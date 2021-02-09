# 단어 공부 (https://www.acmicpc.net/problem/1157)

s = input().upper()
wordsCountList = list(map(s.count, [chr(c) for c in range(65, 91)]))
print('?' if wordsCountList.count(max(wordsCountList)) > 1 else chr(wordsCountList.index(max(wordsCountList)) + 65))

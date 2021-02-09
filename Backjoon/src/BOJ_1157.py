# 단어 공부 (https://www.acmicpc.net/problem/1157)

s = input().upper()

wordsCountList = list(map(s.count, [chr(c) for c in range(65, 91)]))

if wordsCountList.count(max(wordsCountList)) > 1:
    print('?')
else:
    print(chr(wordsCountList.index(max(wordsCountList)) + 65))
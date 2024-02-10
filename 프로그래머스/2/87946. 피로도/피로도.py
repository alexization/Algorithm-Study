from itertools import permutations
def solution(k, dungeons):
    answer = -1
    
    permute = list(permutations(dungeons, len(dungeons)))
    
    for p in permute:
        health = k
        count = 0
        for i in p:
            if i[0] <= health and health >= i[1]:
                health -= i[1]
                count += 1
        answer = max(answer, count)
    
    return answer
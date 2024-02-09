import sys
sys.setrecursionlimit(10**6)

def solution(numbers, target):
    global answer
    answer = 0
    
    dfs(0, numbers[0], numbers, target)
    dfs(0, -numbers[0], numbers, target)
    
    return answer

def dfs(i, result, numbers, target):
    global answer
    
    if i == len(numbers) - 1:
        if result == target:
            answer += 1
        return 
    
    dfs(i+1, result + numbers[i+1], numbers, target)
    dfs(i+1, result - numbers[i+1], numbers, target)
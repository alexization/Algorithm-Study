def solution(begin, target, words):
    answer = 0
    used = set()
    
    global result_return
    result_return = []
    result = 0

    dfs(begin, target, words, used, result)
    if result_return:
        answer = min(result_return)
    else:
        answer = 0
    return answer

def dfs(begin, target, words, used, result):
    print(begin, used, result)
    if begin == target:
        result_return.append(result)
        return
    
    for word in words:
        count = 0
        for i in range(len(begin)):
            if begin[i] != word[i]:
                count += 1
                
        if count == 1:
            if word not in used:
                used.add(begin)
                begin = word
                result += 1
                dfs(begin, target, words, used, result)
                
    return
                
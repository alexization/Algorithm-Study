import copy

def solution(want, number, discount):
    answer = 0
    data = {}
    for i in range(len(want)):
        data[want[i]] = number[i]
    day = sum(number)

    for i in range(len(discount) - day + 1):
        temp = copy.deepcopy(data)
        for j in range(i, i+day):
            if discount[j] in temp:
                temp[discount[j]] -= 1
        
        status = True
        for t in temp.values():
            if t > 0:
                status = False
                break
        if status == True:
            answer += 1
            
    return answer
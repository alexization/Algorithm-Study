def solution(phone_book):
    answer = True
    data = dict()
    for i in range(len(phone_book)):
        data[phone_book[i]] = len(phone_book[i])
    
    l = set()
    for value in data.values():
        l.add(value)
    l_list = list(l)
    
    for l in l_list:
        for (val, val_len) in data.items():
            if val_len > l:
                if val[0:l] in data:
                    answer = False
                    return answer
                    
    return answer
def solution(s):
    lens = len(s)
    answer = lens
    
    array = []
    for i in range(1, lens//2+1):
        count = 1
        match = s[0:i]
        tempArray = []
        for start in range(i, lens+i, i):
            if s[start:start+i] == match:
                count += 1
            else: 
                if count == 1:
                    value = match
                else:
                    value = str(count) + match
                tempArray.append(value)
                match = s[start:start+i]
                count = 1
        array.append(''.join(tempArray))
        tempArray.clear()

    for a in array:
        if a == '':
            continue
        if answer > len(a):
            answer = len(a)
    return answer
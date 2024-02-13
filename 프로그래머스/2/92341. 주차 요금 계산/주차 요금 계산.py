import math
def solution(fees, records):
    answer = []
    data = dict()
    result = []
    
    for record in records:
        time, num, operate = record.split()
        time_list = time.split(':')
        time_min = int(time_list[0]) * 60 + int(time_list[1])
        
        if num not in data:
            data[num] = [0, 0, False, 0]
            
        if operate == 'IN':
            data[num][0] = time_min
            data[num][2] = True
        else:
            data[num][2] = False
            time = time_min - data[num][0]
            data[num][3] += time
    
    for num, dataList in data.items():
        if dataList[2] == True:
            time = 1439 - data[num][0] + data[num][3]
            print(time)
            money = fees[1]
        else:
            time = data[num][3]
            money = fees[1]
            
        if time <= fees[0]:
            data[num][1] += money
        else:
            time -= fees[0]
            extraMoney = (math.ceil(time / fees[2])) * fees[3]
            data[num][1] += money + extraMoney
        
        result.append([int(num), data[num][1]])
    result.sort(key=lambda x : x[0])
    
    for r in result:
        answer.append(r[1])
        
    return answer
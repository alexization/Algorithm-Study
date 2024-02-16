def solution(book_time):
    answer = 0
    
    for book in book_time:
        startTime = book[0].split(":")
        endTime = book[1].split(":")
        
        startMin = int(startTime[0]) * 60 + int(startTime[1])
        endMin = int(endTime[0]) * 60 + int(endTime[1])
        
        book[0], book[1] = startMin, endMin
    
    book_time.sort(key=lambda x: x[0])
    
    endList = []
    for book in book_time:
        if len(endList) == 0:
            endList.append(book[1])
            answer += 1
            continue
        
        status = False
        for end in endList:
            if book[0] >= end + 10:
                endList.remove(end)
                status = True
                break
                
        if status == False:
            answer += 1
        endList.append(book[1])

    return answer
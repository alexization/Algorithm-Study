def solution(genres, plays):
    answer = []
    
    genreDict = dict()
    for i in range(len(plays)):
        if genres[i] not in genreDict:
            genreDict[genres[i]] = [plays[i], []]
            genreDict[genres[i]][1].append([plays[i], i])
            
        else:
            genreDict[genres[i]][0] += plays[i]
            genreDict[genres[i]][1].append([plays[i], i])
    
    array = list(genreDict.values())
    array.sort(key=lambda x: (x[0]))
    while array:
        value = array.pop()[1]
        value.sort(key=lambda x: (-x[0], x[1]))
        
        if len(value) < 2:
            count = 1
        else:
            count = 2
            
        for i in range(count):
            answer.append(value[i][1])
        
    return answer
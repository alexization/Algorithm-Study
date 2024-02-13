def solution(routes):
    answer = 0
    routes.sort(key=lambda x: x[0])
    print(routes)
    end = routes[0][1]
    count = 1
    for i in range(1, len(routes)):
        if routes[i][0] > end:
            count += 1
            end = routes[i][1]
        elif routes[i][1] < end:
            end = routes[i][1]
    answer = count
    return answer
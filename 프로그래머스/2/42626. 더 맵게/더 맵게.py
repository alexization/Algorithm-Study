import heapq

def solution(scoville, K):
    answer = 0
    heapq.heapify(scoville)
    
    if scoville[0] >= K:
        return answer
    
    while scoville[0] < K:
        if len(scoville) < 2:
            answer = -1
            return answer
        first = heapq.heappop(scoville)
        second = heapq.heappop(scoville)
        heapq.heappush(scoville, first + second * 2)
        answer += 1
    
    return answer
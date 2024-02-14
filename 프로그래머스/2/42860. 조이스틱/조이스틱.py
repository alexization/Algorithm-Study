def solution(name):

	# 조이스틱 조작 횟수 
    answer = 0
    
    # 기본 최소 좌우이동 횟수는 길이 - 1
    min_move = len(name) - 1
    
    for i, char in enumerate(name):
    	# 해당 알파벳 변경 최솟값 추가
        answer += min(ord(char) - ord('A'), ord('Z') - ord(char) + 1)
        
        # 해당 알파벳 다음부터 연속된 A 문자열 찾기
        next = i + 1
        while next < len(name) and name[next] == 'A':
            next += 1
                    
        # 왼쪽으로 쭉 진행 
        # 왼쪽으로 진행하다가 오른쪽으로 턴
        # 오른쪽에서 진행하다 왼쪽으로 턴
        min_move = min(min_move, 2 *i + len(name) - next, i + 2 * (len(name) -next))
        
    # 알파벳 변경(상하이동) 횟수에 좌우이동 횟수 추가
    answer += min_move
    return answer
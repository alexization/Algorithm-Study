from collections import deque

def find(x, y, v):
    dq = deque()
    dq.append((x, y, v))
    
    while dq:
        x, y, v = dq.popleft()
        
        # 맨 오른쪽 아래인 도착지점에 도착했을 때 이동한 횟수를 반환해준다.
        if x == N-1 and y == M-1:
            return visit[x][y][v]
        
        # 4가지 방향으로 이동을 각각 시켜본다. 이때, 벽이 아니거나 처음 간 곳은 Queue에 넣어준다.
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            
            if nx < 0 or nx >= N or ny < 0 or ny >= M:
                continue
            
            # 벽이지만 아직 부실 수 있는 경우
            if road[nx][ny] == 1 and v == 0:
                visit[nx][ny][1] = visit[x][y][0] + 1
                dq.append((nx, ny, 1))
            
            # 벽이 아니고 처음 방문한 곳인 경우
            if road[nx][ny] == 0 and visit[nx][ny][v] == 0:
                visit[nx][ny][v] = visit[x][y][v] + 1
                dq.append((nx, ny, v))
        
    return -1
    

N, M = map(int, input().split())

road = [list(map(int, input())) for _ in range(N)]

# 이동을 위한 변수로써 각각 위, 아래, 왼쪽, 오른쪽을 나타낸다
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

# 방문한 지점의 정보를 담기 위해 visit 3차원 배열을 생성, 마지막 배열의 정보에서는 '0'은 벽을 부술 수 있는 상태, '1'은 벽을 이미 부숴 더 이상 못 부시는 상태를 나타냄
visit = [[[0, 0] for _ in range(M)] for _ in range(N)]
visit[0][0][0] = 1

print(find(0, 0, 0))
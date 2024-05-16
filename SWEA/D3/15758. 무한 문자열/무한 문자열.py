T = int(input())

for test_case in range(1, T+1):
    s, t = input().split()
    S, T = s * 2, t * 2
    lenS, lenT = len(S), len(T)
    
    status = True
    if lenS == lenT:
        if s != t:
            status = False

    elif lenS > lenT:
        length = (lenS // lenT) + 1
        temp = T * length
        for i in range(lenS):
            if temp[i] != S[i]:
                status = False
                break
    else:
        length = (lenT // lenS) + 1
        temp = S * length
        for i in range(lenT):
            if temp[i] != T[i]:
                status = False
                break

    if status:
        print(f"#{test_case} yes")
    else:
        print(f"#{test_case} no")
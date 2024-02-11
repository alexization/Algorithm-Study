def solution(record):
    answer = []
    member = dict()
    
    for r in record:
        operate = list(r.split())
        if operate[0] == 'Enter' or operate[0] == 'Change':
            member[operate[1]] = operate[2]
            
    for r in record:
        operate = list(r.split())
        if operate[0] == 'Enter':
            text = f"{member[operate[1]]}님이 들어왔습니다."

        elif operate[0] == 'Leave':
            text = f"{member[operate[1]]}님이 나갔습니다."
            
        else:
            continue
        answer.append(text)
    
    return answer
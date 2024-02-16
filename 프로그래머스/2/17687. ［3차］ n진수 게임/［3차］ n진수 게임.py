def solution(n, t, m, p):
    answer = []
    
    hexdict = {10 : 'A', 11 : 'B', 12 : 'C', 13 : 'D', 14 : 'E', 15 : 'F'}
    result = ['0', '0']
    
    for i in range((t*m)+1):
        revBase = ''
        while i:
            i, mod = divmod(i, n)
            if mod in hexdict:
                mod = hexdict[mod]
                
            revBase += str(mod)
        
        result.extend(list(revBase[::-1]))
    
    for i in range(p, (t*m) + 1, m):
        answer.append(result[i])
    return ''.join(answer)
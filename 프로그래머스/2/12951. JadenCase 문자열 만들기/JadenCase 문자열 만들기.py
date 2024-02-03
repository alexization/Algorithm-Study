def solution(s):
    array = s.split(" ")
    result = []
    for a in array:
        if a:
            a = a[0].upper() + a[1:].lower()
        result.append(a)

    return ' '.join(result)
import sys
input = sys.stdin.readline

vowels = {'a', 'e', 'i', 'o', 'u'}
def check(value):
    one_status = False
    two_status = True
    three_status = True

    vowelCount = 0
    conCount = 0

    prevValue = value[0]
    if prevValue in vowels:
        one_status = True
        vowelCount += 1
    else:
        conCount += 1

    for i in range(1, len(value)):
        if value[i] in vowels:
            one_status = True
            conCount = 0
            vowelCount += 1
        else:
            vowelCount = 0
            conCount += 1

        if conCount == 3 or vowelCount == 3:
            two_status = False

        if prevValue == value[i]:
            if prevValue != 'e' and prevValue != 'o':
                three_status = False
        prevValue = value[i]
    
    if one_status and two_status and three_status:
        return True
    else:
        return False


while True:
    value = input().strip()
    if value == 'end':
        break
    status = check(value)
    if status:
        print(f"<{value}> is acceptable.")
    else:
        print(f"<{value}> is not acceptable.")
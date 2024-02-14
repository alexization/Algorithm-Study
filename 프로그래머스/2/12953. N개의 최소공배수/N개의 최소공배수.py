from math import gcd

def solution(arr):
    sol_lcm = arr[0]
    
    for i in range(1, len(arr)):
        sol_lcm = (sol_lcm * arr[i]) // gcd(sol_lcm, arr[i])
    return sol_lcm
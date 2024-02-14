from collections import deque
def solution(bridge_length, weight, truck_weights):
    truck = deque(truck_weights)
    bridge = deque()

    time = 0
    bWeight = 0
    
    while truck or bridge:  
        for t in bridge:
            t[1] += 1
            
        if bridge and bridge[0][1] == bridge_length:
            value = bridge.popleft()
            bWeight -= value[0]
            
        if truck and bWeight + truck[0] <= weight:
            if len(bridge) <= bridge_length:
                truckWeight = truck.popleft()
                bridge.append([truckWeight, 0])
                bWeight += truckWeight
            
        time += 1        
    return time
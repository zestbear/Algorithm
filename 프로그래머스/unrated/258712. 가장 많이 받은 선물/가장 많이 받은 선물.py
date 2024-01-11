def solution(friends, gifts):
    record = []
    indices = []
    nextMon = []

    for i in range(len(friends)):
        indices.append(0)
        nextMon.append(0)
        temp = []
        for j in range(len(friends)):
            temp.append(0)
        record.append(temp)

    for gift in gifts:
        give, rec = gift.split()
        indices[friends.index(give)] += 1
        indices[friends.index(rec)] -= 1
        record[friends.index(give)][friends.index(rec)] += 1
    
    for A in friends:
        for B in friends:
            giftA = record[friends.index(A)][friends.index(B)]
            giftB = record[friends.index(B)][friends.index(A)]
            if giftA != 0 or giftB != 0:
                if giftA > giftB:
                    nextMon[friends.index(A)] += 1
                elif giftB < giftA:
                    nextMon[friends.index(B)] += 1
                elif giftA == giftB:
                    if indices[friends.index(A)] > indices[friends.index(B)]:
                        nextMon[friends.index(A)] += 1
                    elif indices[friends.index(B)] < indices[friends.index(B)]:
                        nextMon[friends.index(B)] += 1
            elif giftA == 0 and giftB == 0:
                if indices[friends.index(A)] > indices[friends.index(B)]:
                    nextMon[friends.index(A)] += 1
                elif indices[friends.index(B)] < indices[friends.index(B)]:
                    nextMon[friends.index(B)] += 1
    
    return max(nextMon)
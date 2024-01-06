def solution(bandage, health, attacks):
    maxHealth = health
    attack = 0
    band = 0
    turn = 1
    while turn <= attacks[len(attacks)-1][0]:
        if attacks[attack][0] == turn:
            band = 0
            health = health - attacks[attack][1]
            attack = attack + 1
        else:
            if band <= bandage[0]:
                if health + bandage[1] <= maxHealth:
                    health = health + bandage[1]
                    band = band + 1
                elif health + bandage[1] >= maxHealth:
                    health = maxHealth
                    band = band + 1
            if band == bandage[0]:
                if health + bandage[2] <= maxHealth:
                    health = health + bandage[2]
                    band = 0
                elif health + bandage[2] >= maxHealth:
                    health = maxHealth
                    band = band + 1
        if health <= 0:
            return -1
        turn = turn + 1
        print(health)
    if health <= 0:
        health = -1
    return health
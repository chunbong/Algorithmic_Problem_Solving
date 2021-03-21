import sys

m = int(input())

s = 0
while m != 0:
    operator, *operand = sys.stdin.readline().split()
    if len(operand) > 0:
        num = int(operand[0])-1
    if operator == "add":
        s |= (1 << (num))
    elif operator == "check":
        if s & (1 << (num)) == 0:
            print(0)
        else:
            print(1)
    elif operator == "remove":
        s &= ~(1 << (num))
    elif operator == "toggle":
        s ^= (1 << (num))
    elif operator == "all":
        s = (1 << 20) - 1
    else:
        s = 0
    m -= 1

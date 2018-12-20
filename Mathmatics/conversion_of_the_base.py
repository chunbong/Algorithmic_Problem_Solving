n, b = map(str, input().strip().split(' '))
b = int(b)
answer = 0

for i in range(len(n)):
    if ( n[i] >= '0' and n[i] <= '9' ):
        answer = answer * b + ( ord(n[i]) - ord('0') )
    else:
        answer = answer * b + ( ord(n[i]) - ord('A') + 10 )
    
print(answer)
n, m = map(int, input().split())
name1, name2 = map(str, input().split(' '))

# 이름을 하나로 합치기 -> 한 글자씩 번갈아 가면서 합치기
combinedName = ""
check_name1 = True
check_name2 = True
i = 0
while check_name1 or check_name2:
    temp = ""
    try: 
        if check_name1:
            temp += name1[i]
    except IndexError:
        check_name1 = False
    
    try:
        if check_name2:
            temp += name2[i]
    except IndexError:
        check_name2 = False
    
    i += 1
    combinedName += temp

combinedName = list(combinedName)


# 알파벳을 숫자로 바꾸기
stroke = [3, 2, 1, 2, 4, 3, 1, 3, 1, 1, 3, 1, 3, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1]
for i in range(len(combinedName)):
    combinedName[i] = stroke[ord(combinedName[i])-65]


# 숫자를 2개가 남을 때까지 더하기
for length in range(len(combinedName), 2, -1):
    for i in range(length-1):
        temp = combinedName[i] + combinedName[i+1]
        combinedName[i] = temp % 10

print(str(int(''.join([str(combinedName[i]) for i in range(2)])))+"%")
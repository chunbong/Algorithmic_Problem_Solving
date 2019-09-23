testCase = int(input())
for _ in range(testCase):
    temp = []
    password = []
    inputPassword = list(input())

    for i in range(len(inputPassword)):
        
        if inputPassword[i] == "<":
            if password:
                temp.append(password.pop())
        elif inputPassword[i] == ">":
            if temp:
                password.append(temp.pop())
        elif inputPassword[i] == "-":
            if password:
                password.pop()
        else:
            password.append(inputPassword[i])
    
    for i in range(len(temp)-1, -1, -1):
        password.append(temp[i])

    print(''.join(password))
binary = input()

answer = ""
tmp = []
octal = 0
count = 0

for i in reversed(range(len(binary))):
    if count < 3:
        tmp.insert(0, binary[i])
        count += 1
        if count == 3 or i == 0:
            if len(tmp) < 3:
                zero = 3 - len(tmp)
                for i in range(zero):
                    tmp.insert(0, '0')

            octal = (ord(tmp[0])-ord('0'))*4 + (ord(tmp[1])-ord('0'))*2 + (ord(tmp[2])-ord('0'))
            answer += str(octal)
            count = 0
            tmp = []

print(answer[::-1])

# other solution
# s = input()
# print(oct(int(s,2))[2:])
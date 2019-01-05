prime_num = []
m, n = map(int, input().strip().split(' '))
check = [False] * (n + 1)

for i in range(2, n+1):
    if (check[i] == False):
        if i >= m:
            prime_num.append(i)
        j = i * i
        while j < n+1:
            check[j] = True
            j += i

print(*prime_num, sep='\n')
num = int(input())

answer = 0
digits = len(str(num))
start = 1
end = 10

for i in range(1, digits+1):
   if i == digits:
      answer += (num - start + 1) * i
   else:
      answer += (end-start) * i
      start *= 10
      end *= 10

print(answer)
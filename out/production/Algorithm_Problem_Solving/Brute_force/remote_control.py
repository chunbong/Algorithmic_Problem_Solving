n = int(input())
broken_button_num = int(input())
if broken_button_num > 0:
   broken_button = list(map(int, input().split()))
else:
   broken_button = []


answer = abs(n-100)
button_state = [False] * 10


for num in broken_button:
   button_state[num] = True


def check_broken_button(num):
   if num == 0:
      if button_state[0]:
         return 0
      return 1
   
   length = 0
   while num > 0:
      if button_state[num%10]:
         return 0
      length += 1
      num //= 10
   return length


for i in range(1000001):
   length = check_broken_button(i)
   if length > 0:
      press = abs(i-n)
      if answer > length + press:
         answer = length + press

print(answer)
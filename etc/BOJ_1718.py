sentence = input()
key = input()

keyLen = len(key)
key = list(key)
for i in range(keyLen):
    key[i] = ord(key[i]) - ord('a') + 1


result = ""
for i in range(len(sentence)):
    if sentence[i] == " ":
        result += " "
        continue
    
    keyIdx = i % keyLen

    sentenceNum = ord(sentence[i]) - ord('a') + 1

    if sentenceNum - key[keyIdx] + 1 <= 1:
        alpha = ord('z') - abs(sentenceNum - key[keyIdx])
        result += chr(alpha)
    else:
        alpha = sentenceNum - key[keyIdx] + ord('a') - 1
        result += chr(alpha)

    
print(result)
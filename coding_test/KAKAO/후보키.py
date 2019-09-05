from itertools import combinations


def solution(relation):
    answer = 0

    tupleLength = len(relation)
    columnLength = len(relation[0])

    # 컬럼 번호로 만들 수 있는 모든 조합을 생성
    columnList = [i for i in range(columnLength)]
    columnCombinationList = []
    for selectedColumn in range(1, columnLength+1):
        columnCombinationList.extend(combinations(columnList, selectedColumn))

    superkey = []
    for columns in columnCombinationList:
        temp = [tuple([item[column] for column in columns])
                for item in relation]
        if len(set(temp)) == tupleLength:
            superkey.append(columns)

    check = [True] * len(superkey)
    for i in range(len(superkey)):
        for j in range(i+1, len(superkey)):
            if set(superkey[i]) - set(superkey[j]) == set():
                check[j] = False

    for value in check:
        if value:
            answer += 1

    return answer

# relation = [
#     ["100","ryan","music","2"],
#     ["200","apeach","math","2"],
#     ["300","tube","computer","3"],
#     ["400","con","computer","4"],
#     ["500","muzi","music","3"],
#     ["600","apeach","music","2"]
# ]

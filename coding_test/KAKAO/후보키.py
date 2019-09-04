from itertools import combinations


def checkDuplicate(data, length):
    if len(set(data)) == length:
        return True  # 중복 없음
    return False  # 중복 있음


def solution(relation):
    answer = 0
    tupleLength = len(relation)
    columnLength = len(relation[0])
    columnList = [i for i in range(columnLength)]
    columnData = {}
    for column in range(columnLength):
        for t in range(tupleLength):
            if column in columnData:
                columnData[column].append(relation[t][column])
            else:
                columnData[column] = [relation[t][column]]

    superkey = []
    for key in range(columnLength):
        if checkDuplicate(columnData[key], tupleLength):
            superkey.append([key])

    checkColumns = 2
    while checkColumns <= columnLength:
        columnPairs = combinations(columnList, checkColumns)
        tempList = []
        for pair in columnPairs:
            pairColumnList = []
            for key in pair:
                pairColumnList.append(columnData[key])

            totaldataList = []
            for i in range(tupleLength):
                dataList = []
                for j in range(checkColumns):
                    dataList.append(pairColumnList[j][i])
                totaldataList.append(tuple(dataList))
            if checkDuplicate(totaldataList, tupleLength):
                superkey.append(pair)

        checkColumns += 1

    superkeyLength = len(superkey)
    check = [True] * superkeyLength
    for i in range(superkeyLength):
        currentColumnList = superkey[i]
        for j in range(i+1, superkeyLength):
            if set(currentColumnList) - set(superkey[j]) == set():
                check[j] = False

    for value in check:
        if value:
            answer += 1

    return answer

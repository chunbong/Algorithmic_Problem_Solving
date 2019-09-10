from operator import itemgetter
import sys
sys.setrecursionlimit(10**6)


class Tree:
    def __init__(self, nodeinfo):
        self.data = nodeinfo[0]
        self.nodeNum = self.data[2]
        leftList = list(filter(lambda x: x[0] < self.data[0], nodeinfo))
        rightList = list(filter(lambda x: x[0] > self.data[0], nodeinfo))

        if leftList != []:
            self.left = Tree(leftList)
        else:
            self.left = None

        if rightList != []:
            self.right = Tree(rightList)
        else:
            self.right = None


def preorder(root, preorderList):
    if root is None:
        return
    preorderList.append(root.nodeNum)
    preorder(root.left, preorderList)
    preorder(root.right, preorderList)


def postorder(root, postorderList):
    if root is None:
        return
    postorder(root.left, postorderList)
    postorder(root.right, postorderList)
    postorderList.append(root.nodeNum)


def solution(nodeinfo):
    answer = []

    sortedNodeinfo = []
    for i in range(len(nodeinfo)):
        sortedNodeinfo.append((nodeinfo[i][0], nodeinfo[i][1], i+1))

    sortedNodeinfo = sorted(sortedNodeinfo, key=itemgetter(0))
    sortedNodeinfo = sorted(sortedNodeinfo, key=itemgetter(1), reverse=True)

    root = Tree(sortedNodeinfo)

    preorderList = []
    preorder(root, preorderList)
    postorderList = []
    postorder(root, postorderList)

    answer.append(preorderList)
    answer.append(postorderList)

    return answer


nodeinfo = [[5, 3], [11, 5], [13, 3], [3, 5],
            [6, 1], [1, 3], [8, 6], [7, 2], [2, 2]]
print(solution(nodeinfo))

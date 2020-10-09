import numpy.random as npr

n = npr.randint(2, 25)
a = [npr.randint(-50, 50) for i in range(n)]
m = npr.randint(1, n)
a.sort(reverse=True)
print("a = ", a)
print("m = ", m)
print("answer = ", sum(a[:m]))

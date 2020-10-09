import numpy.random as npr

n = npr.randint(2, 25)
a = [(npr.randint(-50, 50), npr.randint(-50, 50)) for i in range(n)]
a = [x ** 2 + y ** 2 for (x, y) in a]
print("a = ", a)
print("answer = ", len(set(a)))

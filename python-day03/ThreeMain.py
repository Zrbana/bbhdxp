'''1.寻找第N次出现位置'''
from datetime import time


def search_n(s,c,n):
    size=0
    for i,x in enumerate(s):
        if x==c:
            size+=1
        if size==n:
                return i
    return -1
print(search_n('fdasasdsf','a',3))
print(search_n('fdasasdsf','a',30))

'''2.斐波那契数列前n项'''
def fibonacci(n):
    a,b = 1,1
    for _ in range(n):
        yield a
        a,b = b,a+b
list(fibonacci(5))

'''3.找出所有重复元素'''
from collections import Counter, Iterator


def find_add_duplicates(lst):
    c = Counter(lst)
    return list(filter(lambda k:c[k]>1,c))
find_add_duplicates([1,2,2,3,3,3])

'''4.联合统计次数'''
a = ['apple','orange','computer','orange']
b = ['computer','orange']

ca = Counter(a)
cb = Counter(b)
#Counter对象间能进行数学运算
ca+cb

def sumc(*c):
    if (len(c) < 1):
        return
    mapc = map(Counter, c)
    s = Counter([])
    for ic in mapc: # ic 是一个Counter对象
        s += ic
    return s


#Counter({'orange': 3, 'computer': 3, 'apple': 1, 'abc': 1, 'face': 1})
sumc(a, b, ['abc'], ['face', 'computer'])

'''5.groupby单字段分组'''
a = [{'date':'2019-12-15','weather':'cloud'}, {'date': '2019-12-13', 'weather': 'sunny'},
 {'date': '2019-12-14', 'weather': 'cloud'}]
#按照weather分组
from itertools import groupby
for k ,items in groupby(a,key=lambda x:x['weather']):
    print(k)
'''
运行结果：
cloud
sunny
cloud
分组失败！原因“分组前必须按照分组字段排序
'''

a.sort(key=lambda x: x['weather'])
for k, items in  groupby(a,key=lambda x:x['weather']):
     print(k)
     for i in items:
         print(i)
'''
cloud
{'date': '2019-12-15', 'weather': 'cloud'}
{'date': '2019-12-14', 'weather': 'cloud'}
sunny
{'date': '2019-12-13', 'weather': 'sunny'}

'''

'''6.itemgetter和key函数
注意到sort和groupby所用的key函数，除了lambda写法外，还有一种简写，就是使用itemgetter：
'''


from operator import itemgetter
from itertools import groupby

a.sort(key=itemgetter('weather'))
for k, items in groupby(a, key=itemgetter('weather')):
     print(k)
     for i in items:
         print(i)


'''7.groupby多字段分组'''
a.sort(key=itemgetter('weather', 'date'))
for k, items in groupby(a, key=itemgetter('weather')):
     print(k)
     for i in items:
         print(i)


'''8.sum函数计算和聚合同时做'''
a = [4,2,5,1]
sum([i+1 for i in a]) # 16


'''9.list分组'''
from math import ceil
def divide_iter(lst,n):
    if n<=0:
        yield lst
        return
        i ,div=0,ceil(len(lst)/n)
        while i<n:
            yield lst[i*idv:(i+1)*div]
            i += 1
list(divide_iter([1,2,3,4,5],0))
list(divide_iter([1,2,3,4,5],2))


'''10.列表全展开'''
#多层列表展开成单层列表
a=[1,2[3,4[5,6],7],8,['python',6],9]
def fun(lst):
    for i in lst:
        if(type(i)==list):
            yield from fun(i)
        else:
            yield i
print(list(fun(a)))

'''11.测试函数运行时长的装饰器'''
def time_func(fn):
    def wrapper():
        start=time.time()
        fn()#执行传入的fn参数
        stop=time.time()
        return (stop-start)
    return wrapper()

def test_list_append():
    lst=[]
    for i in range(0,100000):
        lst.append(i)
def test_list_compare():
    [i for i in range(0,100000)]#列表生成式
a=test_list_append()
c=test_list_compare()
print("test list append time:",a)
print("test list comprehension time:",c)
print("append/compre:",round(a/c,3))



'''12.统计异常出现次数和实践的装饰器'''
def excepter(f):
    i = 0
    t1= time.time()
    def wrapper():
        try:
            f()
        except Exception as e:
            nonlocal i
            i += 1
            print(f'{e.args[0]}:{i}')
            t2=time.time()
            if i == n:
                print(f"spending time:{round(t2-t1)}")
    return wrapper()

'''13.定制递减迭代器'''
class Descend(Iterator):
    def __init__(self,N):
        self.N=N
        self.a=0
    def __iter__(self):
        return self
    def __next__(self):
        while self.a<self.N:
            self.N-=1
            return self.N
        raise StopIteration

descend_iter=Descend(10)
print(list(descend_iter))
[9, 8, 7, 6, 5, 4, 3, 2, 1, 0]















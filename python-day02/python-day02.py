import time
from operator import *
from _collections import *
'''41.创建range序列'''

'''
range(stop)
range(start,stop[,step])
'''
range(11)
range(0,11,1)

'''42.四舍五入'''
round(10.1465465,3)
round(15.1545645,5)

'''43.转为集合类型
返回一个set对象，集合内不允许有重复元素
'''
a = [1,4,2,3,1]
set(a)  # {1,2,3,4}


'''44.转为切片对象'''
a = [1,4,2,3,1]
my_slice = slice(0,5,2)
a[my_slice]  # [1,2,1]

'''45.排序函数'''
a = [1,5,4,6,82,3,2]
sorted(a,reverse = True)

a = [{'name':'xiaoming','age':18,'gender':'male'},{'name':'xiaohong','age':20,'gender':'female'}]
sorted(a,key=lambda x: x['age'],reverse=False)
# [{'name': 'xiaoming', 'age': 18, 'gender': 'male'},
#  {'name': 'xiaohong', 'age': 20, 'gender': 'female'}]

'''46.求和函数'''
a = [1,2,3,4,5,5]
sum(a)
sum(a,10)#求和的初始值为10

'''47.反向迭代器'''
rev = reversed([1,5,7,2,4,7])
for i in rev:
    print(i)

'''48.转元组
将对象转为一个不可变的序列类型
'''
list1 = [1,3,5]
tuple1 = tuple(list1)
tuple1


'''49.查看对象类型'''
class Student():
    def __init__(self,id, name):
        self.id = id
        self.name = name
    def __repr__(self):
        return 'id='+self.id+',name='+self.name

xiaoming = Student(id='001',name='xiaoming')
print(type(xiaoming))
# <class '__main__.Student'>

'''50.聚合迭代器
创建一个聚合了来自每个可迭代对象中的元素的迭代器
'''
x = [3,2,1]
y = [4,5,6]
list(zip(y,x))

a = range(5)
b = list('abcde')
[str(y) + str(y) for x,y in zip(a,b)]

'''51.nonlocal用于内嵌函数中
def excepter(f):
    i = 0
    t1 = time.time()
    def wrapper():
        try:
            f()
        except Exception as e:
            nonlocal i
            i+=1
            print(f'{e.args[0]}:{i}')
            t2 = time.time()
            if i==n:
                print(f'spending time:{round(t2-t1,2)}')
    return wrapper
'''

'''52.global声明全局变量'''
i = 0
def h():
    global i
    i += 1
h()
print(i)

'''53.链式比较'''
i = 3
print(1 <i<3) #False
print(1<i<=3)#True

'''54.不用if else实现计算器'''
def calculator(a,b,k):
    return{
        '+':add,
        '-':sub,
        '*':mul,
        '/':truediv,
        '**':pow
    }[k](a,b)
calculator(1,2,'+')
calculator(2,5,'**')

'''55.链式操作'''
def add_or_sub(a,b,oper):
    return (add if oper =='+' else sub)(a,b)
add_or_sub(1,2,'-')

'''56.交换两元素'''
def swap(a,b):
    return b,a
swap(4,87)

'''57.去掉最值 求平均'''
def score_mean(lst):
    lst.sort()
    lst2 = lst[1:(len(lst)-1)]
    return round((sum(lst2)/len(lst2)),1)
lst = [9.1,9.6,9.4,9.5]
score_mean(lst)

'''58.打印乘法口诀表'''
for i in range(1,10):
    for j in range(1,i+1):
        print('%d*%d=%d' % (j, i, j * i), end="\t")
        print()

'''59.全展开'''
def flatten(lst,out_lst=None):
    if out_lst is None:
        out_lst = []
    for i in lst:
        if isinstance(i,Iterable)
            flatten(i,out_lst)
        else:

            out_lst.append(i)
    return out_lst
print(flatten([[1,2,3],[4,5]], [6,7]))
print(flatten([[[1,2,3],[4,5,6]]]))
'''结果：
[1, 2, 3, 4, 5]
[6, 7, 1, 2, 3, 4, 5]
[1, 2, 3, 4, 5, 6]
'''

'''60列表等分'''
from math import ceil

def divide(lst, size):
    if size <= 0:
        return [lst]
    return [lst[i * size:(i+1)*size] for i in range(0, ceil(len(lst) / size))]


r = divide([1, 3, 5, 7, 9], 2)
print(r)  # [[1, 3], [5, 7], [9]]

r = divide([1, 3, 5, 7, 9], 0)
print(r)  # [[1, 3, 5, 7, 9]]

r = divide([1, 3, 5, 7, 9], -3)
print(r)  # [[1, 3, 5, 7, 9]]


'''61.列表压缩'''


'''62.更长列表'''

'''63.求众数'''





















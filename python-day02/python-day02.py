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
        if isinstance(i,Iterable):
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
def filter_false(lst):
    return list(filter(bool,lst))
r = filter_false([None,0,False,'',[],'ok',[1,2]])
print(r) #['ok',[1,2]]

'''62.更长列表'''
def max_length(*lst):
    return max(*lst,key=lambda v:len(v))
r = max_length([1,2,3],[4,5,6,7],[8])
print(f'更长的列表是{r}') #[4,5,6,7]
r = max_length([1,2,3],[4,5,6,7],[8,9])
print(f'更长的列表是{r}') #[4,5,6,7]

'''63.求众数'''
def top1(lst):
    return max(lst,default='列表为空',key=lambda v:lst.count(v))
lst = [1,3,3,2,1,1,2]
r = top1(lst)
print(f'{lst}中出现次数最多的元素是：{r}')

'''64.多表之最'''
def max_lists(*lst):
    return max(max(*lst,key=lambda v:max(v)))
r = max_lists([1,2,3],[6,7,8],[4,5])
print(r) #8

'''65.列表查重'''
def has_duplicates(lst):
    return len(lst) ==len(set(lst))
x = [1,1,2,2,3,2,3,4,5,6]
y = [1,2,3,4,5]
has_duplicates(x)#False
has_duplicates(y)#True

'''66.列表反转'''
def reverse(lst):
    return lst[::-1]
r = reverse([1,-2,3,4,1,2])
print(r)

'''67.浮点数等差数列'''
def rang(start,stop,n):
    start,stop,n=float('%.2f' % start),float('%.2f' % stop),int('%.d' %n)
    step = (stop-start)/n
    lst = [start]
    while n>0:
        start,n=start+step,n-1
        lst.append(round(start),2)
    return lst
range(1,8,10)      # [1.0, 1.7, 2.4, 3.1, 3.8, 4.5, 5.2, 5.9, 6.6, 7.3, 8.0]

'''68.按条件分组'''
def bif_by(lst,f):
    return [[x for x in lst if f(x)],[x for x in lst if not f(x)]]
records = [25,89,31,34]
bif_by(records,lambda x:x<80)       # [[25, 31, 34], [89]]

'''69.map实现向量运算'''
lst1 = [1,2,3,4,5,6]
lst2 = [3,4,5,6,3,2]
lst(map(lambda x,y:x*y+1,lst1,lst2))

'''70.值最大字典'''
def max_pairs(dic):
    if len(dic) == 0:
        return dic
    max_val = max(map(lambda v:v[1],dic.items()))
    return [item for item in dic.items() if item[1] == max_val]
r = max_pairs({'a': -10, 'b': 5, 'c': 3, 'd': 5})
print(r)  # [('b', 5), ('d', 5)]

'''71.合并两个字典'''
def merge_dict(dic1,dic2):
    return {**dic1,**dic2}
merge_dict({'a': 1, 'b': 2}, {'c': 3})  # {'a': 1, 'b': 2, 'c': 3}

'''72.topn字典'''
from heapq import nlargest
# 返回字典d第n个最大值对应的键
def topn_dict(d,n):
    return nlargest(n,d,key=lambda k:d[k])
topn_dict({'a':10,'b':8,'c':9,'d':10},3) #['a','d','c']


'''73.异位词'''
from _collections import Counter
'''检查两个字符串是否为相同字母异位词'''
def anagram(str1,str2):
    return Counter(str1)==Counter(str2)
anagram('eleven+two','twelve+one')
anagram('eleven','twelve')


'''74.逻辑上合并字典'''
dic1 = {'x':1,'y':2}
dic2 = {'y':3,'z':4}
merged1 = {**dic1,**dic2}# {'x': 1, 'y': 3, 'z': 4}

merged2 = ChainMap(dic1,dic2)
print(merged2) # ChainMap({'x': 1, 'y': 2}, {'y': 3, 'z': 4})

'''75.命名元祖提高可读性'''
from _collections import namedtuple
Point = namedtuple('Point',['x','y','z'])
lst = [Point(1.5,2,3.0),Point(-0.3,-1.0,2.1),Point(1.3,2.8,-2.5)]
print(lst[0].y - lst[1].y)

'''76.样本抽样
用sample抽样，如下例子从100个样本中随机抽样10个。
'''
from random import randint,sample
lst = [randint(0,50) for _ in rang(100)]
print(lst[:5])
lst_sample = sample(lst,10)
print(lst_sample)# [33, 40, 35, 49, 24, 15, 48, 29, 37, 24]


'''77.冲洗数据集'''
from random import shuffle
lst = [randint(0,50) for _ in range(100)]
shuffle(lst)
print(lst[:5]) #[50,3,48,1,26]



'''78.10个均匀分布的坐标点
random模块中的uniform(a,b)生成[a,b]内的一个随机数，如下生成10个均匀分布的二维坐标点
'''
from random import uniform
[(uniform(0,10),uniform(0,10)) for _ in range(10)]



'''79.10个高斯分布的坐标点
random模块中的gauss(u,sigma)生成均值U,标准差为sigma的满足高斯分布的值，如下生成
10个二维坐标点，样本误差(y-2*x-1)满足均值为0 ，标准差为1的高斯分布
'''
from random import gauss
x = range(10)
y = [2*xi+1+gauss(0,1) for xi in x]
points = list(zip(x,y))

'''76.chain高效串联多个容器对象'''
from itertools import chain
a = [1,3,5,0]
b = (2,4,6)
for i in chain(a,b):
    print(i)

    '''77.操作函数对象'''
def f():
    print('i\'m f')

def g():
    print('i\'m g')
[f,g][1]()


'''78生成逆序序列
list(range(10,-1,-1)) # [10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0]
第三个参数为负时，表示从第一个参数开始递减，终止到第二个参数(不包括此边界)
'''
list(range*10,-1,-1)

'''79.使用slice对象'''
from random import randint
cake1 = list(range(5,0,-1))
b = cake1[1:10:2]

cake2 =[randint(1,100) for _ in range(100)]
d = cake2[1:10:2]

#把上面的切法定义成slice对象
perfect_cake_slice_way = slice(1,10,2)
cake1_slice = cake1[perfect_cake_slice_way]
cake2_slice = cake2[perfect_cake_slice_way]

#对于逆向序列
a = [1,3,5,7,9,0,3,5,7]
a_ = a[5:1:-1]

named_slice = slice(5,1,-1)
a_slice = a[named_slice]










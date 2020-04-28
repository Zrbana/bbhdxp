## Python基础（list、tuple、dict、set用法、条件判断和循环）

### 一、list用法

list是Python内置的一种数据类型。

特点：有序，可删除、修改、添加。

定义一个list

```python
>>> name=['marry','hike','mory']
>>> name
#执行结果：
['marry', 'hike', 'mory']
```

获取list长度：

```python
len(name)
#执行结果：
3
```

根据索引获取值：

```python
>>> name[0]
'marry'
>>> name[2]
'mory'
>>> name[3]
```

也可以从后往前，最后一个元素索引是-1

```python
>>> name[-1]
'mory'
>>> name[-2]
'hike'
```

往list末尾追加元素

```python
>>> name.append('zhao na')
>>> name
['marry', 'hike', 'mory', 'zhao na']
```

在指定索引处添加元素

```python
>>> name.insert(0,'zhang jia he')
>>> name
['zhang jia he', 'marry', 'hike', 'mory', 'zhao na']
```

删除最后一个元素或者删除指定索引元素

```python
>>> name.pop()
'zhao na'
>>> name
['jia he', 'marry', 'hike', 'mory']
>>> name.pop(0)
'jia he'
>>> name
['marry', 'hike', 'mory']

```

修改指定索引元素 （可见list允许不同类型的数据）

```python
>>> name[1]='张三'
>>> name
['marry', '张三', 'mory']
```



### 二、tuple用法

特点：一旦初始化就不能修改，没有append()、insert()方法

tuple不可变，所以更安全。所以能用tuple代替list就尽量用tuple.

定义一个tuple:

```python
>>> t=(1,2,3,4,5)
>>> t
(1, 2, 3, 4, 5)
```

看一个特殊的：

```python
>>> t=(1)  #存在歧义
>>> t
1
>>> t=(1,)  #要定义只包含一个元素的tuple 要加,
>>> t
(1,)
```

tuple的“不可变”指的是元素的指向不变，这里改变的是list的指向，而没有改变tuple指向的list

```python
>>> t=(1,2,[3,4,5])
>>> t[2][2]=6
>>> t
(1, 2, [3, 4, 6])
```



### 三、条件判断

#### 1. if 语句

```python
age = 20
if age>= 6:
    print('teenager')
elif age >= 18:
    print('adult')
else:
    print('kid')
```

简写if 语句：

```python
if x:
    print("True")
    
#表示只要x 是非零数值，非空字符串，非空List等，就判断为True循环
```

#### 2.循环

##### 2.1 for...in 依次把list或tuple中元素迭代出来

```python
name=['a','b','c','d']
for i in name:
    print(i)
    
#执行结果：
a
b
c
d
```

计算1-10整数之和：

```python
sum=0
for i in [1,2,3,4,5,6,7,8,9,10]:
    sum += i
print(sum)
#执行结果：
55
```

如果要计算1-10000呢？

Python提供一个range()函数，可以生成一个整数序列，再通过list()函数转换为list。比如：range(5)生成的序列是从0开始小于5的整数

```python
>>>list(range(5))
#执行结果：
[0,1,2,3,4]
```

再来计算1-100的累加和

```python
sum=0;
for x in range(101):
    sum += x;
print(x)
#执行结果：
5050
```

##### 2.2 while循环

计算100以内所有奇数之和：

```python
sum=0
n=99 
while n>0:
    sum += n
    n -= 2
print(sum)
#执行结果;
2500
```

利用循环依次对list中的每个名字打印出Hello,XXX!

```python
L = ['Bart', 'Lisa', 'Adam']
for i in L:
    print('Hello',i,'!')
#执行结果：
Hello Bart !
Hello Lisa !
Hello Adam !
```

### 三、使用dict和set

#### 1.dict

Python内置了字典，全称dictionary，在其他语言中也称为map，使用键值（key-value)存储，具有极快的查找速度。

比如：假设要根据同学的名字查找对应的成绩，如果用list,需要两个list:

```python
names = ['brown','marry','happy']
grade = [20,89,90]
```

给定一个名字，要查找对应的成绩，就要先在names中找到对应位置，再从grade中取出对应的成绩,list越长，耗时越长。

如果用dict实现，只需要一个name-grade映射表，直接根据名字查找成绩

```python
>>> d = {'brown':95,'marry':75,'happy':98}
>>> d['marry']
#执行结果：
75
>>> d[75]
#编译报错
```

把数据放入dict中，除了初始化时放入，还可以通过key放入

```python
>>> d['jack'] = 99
>>> d
#执行结果：
{'brown': 95, 'marry': 75, 'happy': 98, 'Jack': 99}
```

由于一个key是唯一的，所以再次放入相同的key时，后面的值会把前面的值冲掉

```python
>>> d['jack'] = 0
>>> d
#执行结果：
{'brown': 95, 'marry': 75, 'happy': 98, 'Jack': 0}
```

如果key不存在会报错：

```python
>>> d['zn']
#执行结果
Traceback (most recent call last):
  File "<pyshell#91>", line 1, in <module>
    d['zn']
KeyError: 'zn'
```

避免key不存在的错误，有两种方法：

1.通过in判断key是否存在

```python
>>> 'zn' in d
False
```

2.通过dict提供的get方法，如果key不存在，返回None，或者自己指定的value

注意：返回None时Python的交互式命令行不显示结果。

```python
>>> d.get('zn')
>>> d.get('zn','key不存在')
'key不存在'
```

删除一对数据：

```python
>>> d.pop('brown')
95
>>> d
{'marry': 100, 'happy': 98, 'Jack': 99}
```

请务必注意，dict内部存放的顺序和key放入的顺序是没有关系的。

总结：

和list比较，dict 有一下特点：

1. 查找和插入速度快
2. 需要占用大量的内存，内存浪费多（以空间换时间）

而list相反：

1.查找和插入的时间随着元素的增加而增加

2.占用空间小，内存浪费少。

#### 2. set

set是一组Key的集合，不存储value。由于key不能重复，所以set中没有重复的key

创建一个set需要提供一个list作为输入集合

```python
>>> s = set([1,2,3,4,5])
>>> s
{1, 2, 3, 4, 5}
```

重复元素自动过滤：

```python
>>> s = set([1,2,3,4,5,1,2,4,5])
>>> s
{1, 2, 3, 4, 5}
```

可以使用add（）函数添加元素

```python
>>> s.add(10)
>>> s
{1, 2, 3, 4, 5, 10}
```

可以通过remove(key) 删除元素

```python
>>> s.remove(1)
>>> s
{2, 3, 4, 5, 10}
```

set可以看做是数学意义上的无序、不重复的数据集合，因此两个集合可以做数学意义上的交集、并集操作

```python
>>> s1=set([1,2,3,4,5])
>>> s2 = set([1,3,5,7,8])
>>> s1 & s2
{1, 3, 5}
>>> s1 | s2
{1, 2, 3, 4, 5, 7, 8}
```


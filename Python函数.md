# Python函数

## 一、调用内置函数

数据类型转换函数

```python
>>> int('123')
123
>>> int(12.23242)
12
>>> float(12.345)
12.345
>>> str(100)
'100'
>>> bool(1)
True
>>> bool('100')
True
>>> bool('')
False
```

函数名其实就是指向一个函数对象的引用，完全可以把函数名赋值给一个变量，相当于给这个函数起了一个别名

```python
>>> abs(-2323)
2323
>>> a = abs
>>> a(-323213.31)
323213.31
```

## 二、定义函数

### 1. 空函数

pass可以当做占位符，什么也不做，让代码能运行起来

```python
def pop():
    pass
```

也可以在其他语句中使用：

```python
if age>10:
    pass
```

### 2.返回多个值

函数可以返回多个值吗？答案是肯定的。
比如在游戏中经常需要从一个点移动到另一个点，给出坐标、位移和角度，就可以计算出新的新的坐标：

```python
import math
def move(x,y,step,angle = 0):
	nx= x + step * math.cos(angle)
	ny=y - step * math.sin(angle)
    retrun nx,ny
```

调用这个函数就可以返回两个值：

```python
>>> x, y = move(100, 100, 60, math.pi / 6)
>>> print(x, y)
151.96152422706632 70.0
```

但是，实际上这是一种假象，Python函数返回的值仍然是单一值

```python
>>> r = move(100, 100, 60, math.pi / 6)
>>> print(r)
(151.96152422706632, 70.0)
```

可以发现，返回值实际上是一个tuple，在语法上，返回一个tuple可以省略括号，而多个变量可以同时接受一个tuple，按位置赋给对应的值。

练习：定义一个函数fun(a,b,c)，返回一元二次方程ax*x+bx=c=0的两个解

```python
import math
#定义一个取相反数的函数
def my_abs(x):
    return -x
def fun(a,b,c):
    nb  = my_abs(b)
    x1 = (nb+math.sqrt(b*b-4*a*c))/(a*2)
    x2 = (nb-math.sqrt(b*b-4*a*c))/(a*2)
    return x1,x2
```

测试：

```python
>>> print(fun(2,3,1))
(-0.5, -1.0)
>>> print(fun(1,3,-4))
(1.0, -4.0)
```

### 3.函数的参数

Python的函数定义很简单，但是灵活度非常大，除了正常定义的必须按参数外，还可以使用默认参数，可变参数，和关键字参数。使得函数定义出来的接口，不但能处理复杂的函数，还可以简化调用者的代码。

#### 3.1  位置参数

位置参数：传入的两个值按照位置顺序依次赋给参数1和参数2

以幂函数为例说明问题：

计算x的平方的函数：

```python
def power(x):
    return x*x;
```

对于power(x)函数，x就是一个位置参数。

但是如果要计算x的6次方或者n次方怎么办？可以把power(x)改为power(x,n)，表示x的n次方的计算函数。

以下函数是计算x的n次方的，x和n就是位置参数

```python
def power(x,n):
    s = 1
    while n>0:
        n = n-1
        s = s*x
    return s
```

测试：

```python
>>> power(3,3)
27
>>> power(2,4)
16
```

#### 3.2 默认参数

##### 3.2.1 默认参数的使用

现在又有了新的问题，我再次调用计算平方的power(x)函数时，调用失败，因为参数个数不匹配。这个时候就需要默认参数，由于经常计算x的平方，所以可以把第二个参数的默认值设为2：

```python
def power(x,n=2):
    s = 1
    while n>0:
        n = n-1
        s = s*x
    return s
```

再次测试：

```python
>>> power(5)
25
>>> power(5，2)
25
```

##### 3.2.2 默认参数的好处

**降低调用函数的难度**

举个例子，录入一个班级学生的信息包括国籍，学校，班级，姓名，学号。可以将国籍，学校，班级设为默认参数，只有与默认参数不符的才提供额外的信息，将大大降低调用函数的难度。

```python
def student_info(name,number,country='China',School='The Beat',class='英语专业12班'):
    print('name:',name)
    print('number:',number)
    print('country:',country)
    print('School:',School)
    print('class:',class)
```

当录入信息时，只需要传入name,number即可，只有与默认参数不符的才提供额外的信息。

##### 3.2.3 默认函数的大坑

先看一个小例子：

先定义一个函数，传入一个list，向list末尾追加一个END，并返回list

```python
#默认函数是空的list
def append_str(L=[]):
    L.append('END')
    return L
```

传入一个非空list进行调用，调用结果正常：

```python
>>> append_str([1,2,3])
[1, 2, 3, 'END']
>>> append_str(['玛丽',2,3])
['玛丽', 2, 3, 'END']
```

使用默认参数调用：

我们的预期结果是：

第一次调用 返回['END']

第二次调用 返回['END']

第n次调用 返回['END']

而实际结果是这样的：

```python
>>> append_str()
['END']
>>> append_str()
['END', 'END']
>>> append_str()
['END', 'END', 'END']
```

出现以上结果的原因是list是可变的集合，每调用一次List的长度就会被更新，默认参数的内容就被改变了。

所以，定义默认参数时，迷人参数必须指向不变对象！！

上述例子可以做如下修改，解决上述问题：

```python
def append_str(L=None):
    if L is None:
        L=[]
    L.append('END')
    return L
```

#### 3.3 可变参数

可变参数，即传入的参数个数是可变的。

比如，给定一组数字 a,b,c，...计算a2 + b2 +c2+...

要定义这个函数，就必须确定输入的参数，由于参数个数不确定，可以把a,b,c....作为一个list或tuple传进来，函数定义如下：

```python
def cal(num):
    sum=0
    for n in num:
        sum = sum+ n*n
    return sum
```

调用时，必须传入一个list

```python
>>> cal([1,2,3])
14
>>> cal([2,3,4,5])
54
```

把 cal( num ) 的参数修改为可变参数，调用方式就可以简化为

```python
>>> cal(1,2,3)
14
>>> cal(2,3,4,5)
54
```

修改后的函数如下：

```python
def cal(*num):
    sum=0
    for n in num:
        sum = sum+ n*n
    return sum
```

可以看到，唯一的修改就是参数前面加了*号。在函数内部，参数 num 接收到的是一个tuple，因此，函数代码完全不变。

测试一下，修改成功啦！

```python
>>> cal(1,2,3,4)
30
>>> cal(5)
25
```

那么问题又来了，现在的参数是可变参数，如果现在要调用一个定义好的list或tuple怎么办？

Python允许在list或tuple之前加一个*号，把list或tuple当做可变参数传进去

```python
>>> L=[1,3,5,6]
>>> cal(*L)
71
```

#### 3.4 关键字参数

##### 3.4.1 关键字参数的使用

可变参数允许传入任意个参数，这些可变参数在调用时自动组装为一个tuple。而关键字参数允许传入任意含参数名的参数，这些关键字在函数内部自动组装为一个dict。

例如：

```python
def person(name,age,**kw):
    print('name:',name,'age:',age,'other:',kw)
```

函数有两个必选参数name,age，还接受关键字参数kw。

调用该函数时，可以只传入必选参数：

```python
>>> person('Jack',20)
name: Jack age: 20 other: {}
```

也可以传入任意个数的关键字参数

```python
>>> person('Jack',20,city='BeiJing')
name: Jack age: 20 other: {'city': 'BeiJing'}
>>> person('Jack',20,city='BeiJing',job='老师')
name: Jack age: 20 other: {'city': 'BeiJing', 'job': '老师'}
```

关键字参数的作用：扩展函数的功能。比如，有一个用户注册的功能，除了用户名和密码是必填项外，其他都是可选项，就可以利用关键字参数来实现这个功能。

和可变参数类似，也可以先组装出一个dict，然后把该dict转换为关键字参数传进去

```python
>>> others={'city':'BeiJing','job':'Student'}
>>> person('Jaca',24,city=others['city'],job=others['job'])
name: Jaca age: 24 other: {'city': 'BeiJing', 'job': 'Student'}
```

这样的调用比较复杂，简化写法如下：

```python
>>> person('Jack',24,**others)
name: Jack age: 24 other: {'city': 'BeiJing', 'job': 'Student'}
```

##### 3.4.2 命名关键字参数

如果要限制关键字参数的名字，就可以使用命名关键字参数。例如，只接受city和job作为关键字参数，函数定义如下：

```python
def person(name,age,*,city,job):
    print(name,age,city,job)
```

命名关键字参数需要一个特殊分隔符*,  *号后面的参数被视为命名关键字参数

调用方式如下：

```python
>>> person('Jack',24,city='Beijing',job='Teacher')
Jack 24 Beijing Teacher
```

注意：命名关键字参数必须传入参数名，这和位置参数不同。如果没有传入参数名，调用将报错。

#### 3.5 参数组合

在Python中定义函数，可以用必选参数，默认参数，可变参数，关键字参数和命名关键字参数。这5中参数可以组合使用，除了可变参数和命名关键字参数混合。

但是，参数定义的顺序必须是：必选参数，默认参数，可变参数/命名关键字参数和关键字参数。

#### 3.6 函数的参数使用方法总结：

1.默认参数一定要用不可变对象

2.注意定义可变参数和关键字参数的语法：

- *args 是可变参数，args接收的是一个tuple
- **kw 是关键字参数，kw接收的是一个dict

3.可变参数可以直接传入：fun(1,2,3)，也可以先组装list或tuple，在通过 * args传入：fun(*(1,2,3))

4.关键字参数可以直接传入：fun(a=1,b=2),也可以先组装dict，再通过 **kw传入：func( * *{'a': 1, 'b': 2})。

## 三、递归函数

### 1.递归函数的使用

举个例子，计算 n!

```python
def jiecheng(n):
    if n==1:
        return 1
    return n*jiecheng(n-1)
```

测试一下：

```python
>>> jiecheng(10)
3628800
>>> jiecheng(100)
93326215443944152681699238856266700490715968264381621468592963895217599993229915608941463976156518286253697920827223758251185210916864000000000000000000000000
>>> 
```

### 2.尾递归

尾递归是为了解决递归调用栈溢出的问题。

函数调用是通过栈这种数据结构实现的，每当调用一次函数，栈就会加一层栈帧，每当函数返回，栈就会减一层栈帧。由于栈的大小是有限的，所以递归次数过多，会导致栈溢出。

```python
>>> jiecheng(2000)
Traceback (most recent call last):
  File "<pyshell#209>", line 1, in <module>
    jiecheng(2000)
  File "<pyshell#204>", line 4, in jiecheng
    return n*jiecheng(n-1)
  File "<pyshell#204>", line 4, in jiecheng
    return n*jiecheng(n-1)
  File "<pyshell#204>", line 4, in jiecheng
    return n*jiecheng(n-1)
  [Previous line repeated 1021 more times]
  File "<pyshell#204>", line 2, in jiecheng
    if n==1:
RecursionError: maximum recursion depth exceeded in comparison
```

解决递归调用栈溢出的方法是通过尾递归优化。尾递归是指，在函数返回的时候，调用自身本身，并且，return语句不能包含表达式。这样，编译器或者解释器就可以把尾递归做优化，使递归本身无论调用多少次，都只占用一个栈帧，不会出现栈溢出的情况。

```python
def jiecheng(n):
    return fact_iter(n, 1)
def fact_iter(num, product):
    if num == 1:
        return product
    return fact_iter(num - 1, num * product)
```

> fact(5)对应的fact_iter(5, 1)的调用如下：
> ===> fact_iter(5, 1)
> ===> fact_iter(4, 5)
> ===> fact_iter(3, 20)
> ===> fact_iter(2, 60)
> ===> fact_iter(1, 120)
> ===> 120

遗憾的是，大多数编程语言没有针对尾递归做优化，Python解释器也没有做优化，所以，即使把上面的fact(n)函数改成尾递归方式，也会导致栈溢出。


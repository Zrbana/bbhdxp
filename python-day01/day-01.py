import sys

"""1.绝对值"""
print(abs(-6)) # 6

"""2.判断元素真假"""
# all(x)  接受一个迭代器，如果迭代器的所有元素都为真，则返回True，否则返回False
print("",0,False) # False
print(all([1,0,3,6])) # False
print(all([1,3,6])) #True

#接受一个迭代器，如果迭代器里至少有一个元素为真，返回True，否则返回False
# any(x)  x若都为"",0,False,则返回false,否则返回true
print(any(["",0,False]))  # False
print(any(["",0,1,2]))   # True
print(any([0,0,0,[]])) #False
print(any([0,0,1])) #True

"""3.ascii展示对象"""
class Student():
    def __init__(self,id,name):
        self.id = id;
        self.name = name;
    def __repr__(self):
            return 'id = ' + self.id + ",name = " + self.name


xiaoming = Student(id = '001',name = 'xiaoming')
print(xiaoming)
ascii(xiaoming)


'''4.十进制转二进制'''
print(bin(10))

'''5.十进制转八进制'''
print(oct(10))

'''6.十进制转十六进制'''
print(hex(10))

'''7.判断是真是假'''
print(bool([0,0,0,])) #True
print(bool([])) #False
print(bool([1,0,1])) #True

'''8.字符串转字节类型'''
s = 'apple'
print(bytes(s,encoding='utf-8'))

'''9.转为字符串'''
i=100
str(i)

'''10.判断对象是否可被调用，能被调用的对象就是一个callable对象'''
callable(str) #True
callable(int) #True

'''11.十进制转ASCII'''
chr(65) #'A'

'''12.ASCII转十进制'''
ord('A') #65

'''13.静态方法
classmethod 装饰器对应的函数不需要实例化，不需要 self参数，
但第一个参数需要是表示自身类的 cls 参数，可以来调用类的属性，类的方法，实例化对象等。'''
class Student():
    def __init__(self,id,name):
        self.id = id
        self.name = name
    def __repr__(self):
        return 'id = '+self.id+",name = "+self.name
    @classmethod
    def f(cls):
        print(cls)

'''14.执行字符串表示的代码'''
s = "print('hello world')"
r = compile(s,"<String>","exec")
print(r)
exec(r)


'''15.创建复数'''
complex(1,2) # (1+2j)

'''16.创建数据字典'''
dict()
dict(a='a',b='b')
dict(zip(['a','b'],[1,2]))
dict(zip(['a',1],['b',2]))

'''17.一键查看对象所有方法'''
dir(xiaoming)
'''['__class__', '__delattr__', '__dict__', '__dir__', '__doc__', '__eq__', '__format__', '__ge__', '__getattribute__', '__gt__', '__hash__', '__init__', '__init_subclass__', '__le__', '__lt__', '__module__', '__ne__', '__new__', '__reduce__', '__reduce_ex__', '__repr__', '__setattr__', '__sizeof__', '__str__', '__subclasshook__', '__weakref__', 'id', 'name']
'''

'''18.取商和余数'''
divmod(10,3)  #3 1

'''19.枚举对象'''
s = ['a','b','c']
for i,v in enumerate(s,1):
    print(i,v)

'''20.计算表达式
将字符串str 当成有效的表达式来求值并返回计算结果取出字符串中内容'''
s = "1 + 3 + 5"
print(eval(s))

'''21.查看变量所占字节数'''
a = {'a':1,'b':2.0}
sys.getsizeof(a) #240

'''22.过滤器
在函数中设定过滤条件，迭代元素，保留返回值为True的元素
'''
fil = filter(lambda x:x>100,[1,211,54,65,6])
list(fil) # 211

'''23.转为浮点类型'''
float(3) #3.0

'''24.字符串格式化'''
print('i am {0},age{1}',format('tom',18))

'''25.冻结集合
创建一个不可修改的集合
'''
frozenset([1,1,2,3,5])

'''26.动态获取对象属性'''
class Student():
    def __init__(self,id,name):
        self.id = id
        self.name = name
    def __repr__(self):
        return 'id = '+self.id+",name = "+self.name
xiaoming = Student(id='001',name = 'xiaoming')
getattr(xiaoming,'name')# 获取xiaoming这个实例的name属性值

'''27.对象是否有这个属性'''
hasattr(xiaoming,'name') #True
hasattr(xiaoming,'address') #False

'''28.返回对象的哈希值
自定义的实例都是可哈希的
list,dict,set等可变对象都是不可哈希的
'''
hash(xiaoming)
'''hash([1,2,3])#TypeErro unhashbale type:'list'''''


'''29.一键帮助  返回对象的帮助文档'''
help(xiaoming)

'''30.返回对象的内存地址'''
id(xiaoming)

'''31.获取用户输入'''
input()

'''32.转为整型'''
int('12',16) #18

'''33.判断Object是否为classinfo的实例'''
isinstance(xiaoming,Student) #True

'''34.父子关系鉴定'''
class undergraduate(Student):
    def studyClass(selfself):
        pass
    def attendActicity(self):
        pass

issubclass(undergraduate,Student) #True

issubclass(object,Student)#False

issubclass(Student,object)#True

'''35.创建迭代器类型'''
lst = [1,3,5]
for i in iter(lst):
    print(i)


class TestIter(object):
        def __init__(self):
             self.l=[1,3,2,3,4,5]
             self.i=iter(self.l)
        def __call__(self):  #定义了__call__方法的类的实例是可调用的
             item = next(self.i)
             print ("__call__ is called,fowhich would return",item)
             return item
        def __iter__(self): #支持迭代协议(即定义有__iter__()函数)
             print ("__iter__ is called!!")
             return iter(self.l)
t = TestIter()
t()#因为实现了_call_，所以t实例能被调用
for e in TestIter():
    print(e)
    # 因为实现了_iter_方法，所以t能被迭代

'''36.所有对象之根'''
o = object()
type(o)

'''37.打开文件'''
fo = open('D:/a.txt',mode='r',encoding='utf-8')
fo.read()

'''38.次幂'''
pow(3,2,4) #1

'''39.打印'''
lst = [1,3,5]
print(lst)
print(f'lst:{lst}')
print('lst:{}'.format(lst))
print('lst',lst)

'''40.创建属性的两种方式'''
#方法一
class C:
    def __init__(self):
        self._x = None
    def getx(self):
        return self._x
    def setx(self,value):
        self._x = value
    def delx(self):
        del self._x
    #使用properrty类创建property属性
    x = property(getx(),setx,delx,"I'm the 'x' property.")

#方式二
class A:
    def __init__(self):
        self._x = None

    @property
    def x(self):
        return self._x

    @x.setter
    def x(self, value):
        self._x = value

    @x.deleter
    def x(self):
        del self._x
















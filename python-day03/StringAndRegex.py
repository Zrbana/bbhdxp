'''1.反转字符串'''
from encodings.utf_8 import encode

st = 'python'
#方法一
''.join(reversed(st))
#方法二
st[::-1]

'''2.字符串切片操作
查找替换3 或5的倍数
'''
print([str("java"[i%3*4:]+"python"[i%5*6:] or i) for i in range(1,15)])
#['1', '2', 'java', '4', 'python', 'java', '7', '8', 'java', 'python', '11', 'java', '13', '14']


'''3.join串联字符串'''
mystr = ['1', '2', 'java', '4', 'python', 'java', '7', '8', 'java', 'python', '11', 'java', '13', '14']
','.join(mystr)


'''4.字符串的字节长度'''
def str_byte_len(mystr):
    return (len(mystr.encode('utf-8')))

str_byte_len('i love python')#13个字节
str_byte_len('字符')#6个字节

'''5.查找第一个匹配串'''
import re
s = 'i love python very much'
pat = 'python'
r = re.search(pat,s)
print(r.span())#(7,13)

'''6.查找所有1的索引'''
s = '湖北省武汉市第1大道第1人民医院'
pat = '1'
r =re.finditer(pat,s)
for i in r:
    print(i)
#<re.Match object; span=(7, 8), match='1'>
#<re.Match object; span=(11, 12), match='1'>

'''7.\d匹配数字[0-9]'''
s = '一共20行代码运行时间13.59s'
pat = r'\d+' # +表示匹配数字(\d表示数字的通用字符)1次或多次
r = re.findall(pat,s)
print(r)
# ['20', '13', '59']

'''8.匹配浮点数和整数
?表示前一个字符匹配0或1次
'''
s = '一共20行代码运行时间13.59s'
pat = r'\d+\.?\d+' # ?表示匹配小数点(\.)0次或1次，这种写法有个小bug，不能匹配到个位数的整数
r = re.findall(pat,s)
print(r)
# ['20', '13.59']

'''9.^匹配字符串的开头'''
s = 'This is a python program'
pat = r'^[ip]' #查找以字符i p 开头的字符串
r = re.findall(pat,s)
print(r)

'''10.忽略大小写'''
s = 'This is regEx'
pat = r'T'
r =re.findall(pat,s,re.I)

'''11.compile的作用
如果要做很多次匹配，可以先编译字符串
'''
pat = re.compile('\w+') #\w匹配不是数字和字母的字符
has_special_chars = pat.search('ed#@edc')
if has_special_chars:
    print(f'str contains special characters:{has_special_chars.group(0)}')

again_pattern = pat.findall('hubeiwuhuan@232')
if '@' in again_pattern:

    print('possibly it is an email')

'''12.使用()捕获单词'''
s = 'This module provide regular expression matching operations similar to ...'
pat = r'\s([a-zA-Z]+)'
r = re.findall(pat,s)
print(r)

'''13.split分割单词'''
s = 'This module provides regular expression matching operations similar to those found in Perl'
pat = r'\s+'
r = re.split(pat,s)
print(r) # ['This', 'module', 'provides', 'regular', 'expression', 'matching', 'operations', 'similar', 'to', 'those', 'found', 'in', 'Perl']


'''14.match从字符串开始位置匹配'''
# match函数
mystr = "This"
pat = re.compile('hi')
pat.match(mystr)
pat.match(mystr,1)

# search函数
mystr = "This"
pat = re.compile('hi')
pat.search(mystr)

'''15.替换匹配的子串'''
content = 'hello 12306,hello 119'
pat =  re.compile(r'\d+') #要替换的部分
m = pat.sub('666',content)
print(m)

'''16.贪心捕获'''
content = '<h>ddesdadsad</h><div>graph</div>bb<div>math</div>cc'
pat = re.compile(r'<div>(.*)</div>')#贪婪模式
m=pat.findall(content)
print(m) #匹配结果为： ['graph</div>bb<div>math']













































'''1.获取后缀名'''
import os
file_ext = os.path.splitext('./data/py/test.py')
front,ext = file_ext
print(front) #./data/py/test
print(ext)#.py

'''2.文件读操作'''
#创建文件夹
def mkdir(path):
    isexists = os.path.exists(path)
    if not isexists:
        os.mkdir(path)

#读取文件信息
def openfile(filename):
    f = open(filename)
    filist = f.read()
    f.close()
    return filist#返回读取内容


'''3.文件写操作'''
#写入文件信息 如果文件存在，则清空后写入，不存在则创建
f = open(r'./data/test.txt','w',encoding='utf--8')
print(f.write('测试文件写入'))
f.close()

#文件存在，则在文件内容后追加，不存在则创建
f = open(r'./data/test.txt','a',encoding='utf--8')
print(f.write('测试文件写入'))
f.close()

#with关键字系统会自动关闭文件和处理异常
with open(r"./data/test.txt", "w") as f:
    f.write("hello world!")

'''4.路径中的文件名'''
file_ext = os.path.split('./data/py/test.py')
ipath,ifile = file_ext
print(ipath) #'./data/py'
print(ifile) #'test.py'

'''5.批量修改文件后缀'''
import argparse

def get_parser():
    parser = argparse.ArgumentParser(
        description='工作目录中文件后缀名修改')
    parser.add_argument('work_dir', metavar='WORK_DIR', type=str, nargs=1,
                        help='修改后缀名的文件目录')
    parser.add_argument('old_ext', metavar='OLD_EXT',
                        type=str, nargs=1, help='原来的后缀')
    parser.add_argument('new_ext', metavar='NEW_EXT',
                        type=str, nargs=1, help='新的后缀')
    return parser

def batch_rename(work_dir,old_ext,new_ext):
    '''传递当前目录，原来后缀名，新的后缀名，批量重命名后缀
    '''
    for filename in os.listdir(work_dir):
        '''获得文件后缀'''
        split_file = os.path.splitext(filename)
        file_ext = split_file[1]
        #定位后缀名为Old_ext的文件
        if old_ext == file_ext:
            '''修改后的完整名称'''
            newfile = split_file[0]+new_ext
            '''实现重命名操作'''
            os.rename(
                os.path.join(work_dir,filename),
                os.path.join(work_dir,newfile)
            )
        print('完成重命名')
        print(os.listdir(work_dir))

def main():
    parser = get_parser()
    args = vars(parser.parse_args())
    #从命令行参数中解析出参数
    work_dir = args['work_dir'][0]
    old_ext = args['old_ext'][0]
    if old_ext[0] != '.':
        old_ext = '.'+old_ext
    new_ext = args['new_ext'][0]
    if new_ext[0] != '.':
        new_ext = '.'+new_ext
    batch_rename(work_dir,old_ext,new_ext)


'''6.xls批量转换成xlsx'''
def xls_to_xlsx(work_dir):
    """
    传递当前目录，原来后缀名，新的后缀名后，批量重命名后缀
    """
    old_ext, new_ext = '.xls', '.xlsx'
    for filename in os.listdir(work_dir):
        # 获取得到文件后缀
        split_file = os.path.splitext(filename)
        file_ext = split_file[1]
        # 定位后缀名为old_ext 的文件
        if old_ext == file_ext:
            # 修改后文件的完整名称
            newfile = split_file[0] + new_ext
            # 实现重命名操作
            os.rename(
                os.path.join(work_dir, filename),
                os.path.join(work_dir, newfile)
            )
    print("完成重命名")
    print(os.listdir(work_dir))


xls_to_xlsx('./data')

# 输出结果：
# ['cut_words.csv', 'email_list.xlsx', 'email_test.docx', 'email_test.jpg', 'email_test.xlsx', 'geo_data.png', 'geo_data.xlsx',
#'iotest.txt', 'pyside2.md', 'PySimpleGUI-4.7.1-py3-none-any.whl', 'test.txt', 'test_excel.xlsx', 'ziptest', 'ziptest.zip']


'''7.定制文件不同行

比较两个文件在哪些行内容不同，返回这些行的编号，行号从1开始

'''

#定义统计文件行数的函数
def statLineCnt(statfile):
    print('文件名'+statfile)
    cnt = 0
    with open(statfile,encoding='utf-8') as f:
        while f.readline():
            cnt += 1
        return cnt

#统计文件不同之处的子函数
#more表示含有更多行数的文件
def diff(more,cnt,less):
    difflist  = []
    with open(less,encoding='utf-8') as l:
        with open(more,encoding='utf-8') as m:
            lines = l.readlines()
            for i,line in enumerate(lines):
                if line.strip() != m.readline().strip():
                    difflist.append(i)
        if cnt - i>1:
            difflist.extend(range(i+1),cnt)
        return [no+1 for no in difflist]

#主函数
def file_diff_line_nos(fileA,fileB):
    try:
        cntA = statLineCnt(fileA)
        cntB = statLineCnt(fileB)
        if cntA > cntB:
            return diff(fileA,cntA,fileB)
        return diff(fileB,cntB,fileA)
    except Exception as e:
        print(e)

'''8.获取指定后缀名的文件'''
def find_file(work_dir,extension='jpg'):
    lst = []
    for filename in os.listdir(work_dir):
        print(filename)
        splits = os.path.splitext(filename)
        ext  = splits[1]
        if ext == '.'+extension:
            lst.append(filename)
    return lst
r = find_file('.','md')
print(r)

'''9.年的日历图'''
import calendar
from datetime import date
mydate = date.today()
year_calendar_str = calendar.calendar(2019)
print(f'{mydate.year}年的日历图:{year_calendar_str}\n')

'''10.判断是否闰年'''
mydate = date.today()
is_leap = calendar.isleap(mydate.year)
print_leap_str = "%s年是闰年" if is_leap else "%s年不是闰年\n"
print(print_leap_str % mydate.year)


'''11.月的日历图'''
mydate = date.today()
month_calendar_str = calendar.month(mydate.year, mydate.month)

print(f"{mydate.year}年-{mydate.month}月的日历图：{month_calendar_str}\n")

'''12.月有几天'''
mydate = date.today()
weekday, days = calendar.monthrange(mydate.year, mydate.month)
print(f'{mydate.year}年-{mydate.month}月的第一天是那一周的第{weekday}天\n')
print(f'{mydate.year}年-{mydate.month}月共有{days}天\n')


'''13.月第一天'''
mydate = date.today()
month_first_day = date(mydate.year, mydate.month, 1)
print(f"当月第一天:{month_first_day}\n")

'''14.月最后一天'''
mydate = date.today()
_, days = calendar.monthrange(mydate.year, mydate.month)
month_last_day = date(mydate.year, mydate.month, days)
print(f"当月最后一天:{month_last_day}\n")

'''15.获取当前时间'''
from time import localtime, strftime, strptime
from datetime import date, datetime
today_date = date.today()
print(today_date)  # 2019-12-22

today_time = datetime.today()
print(today_time)  # 2019-12-22 18:02:33.398894

local_time = localtime()
print(strftime("%Y-%m-%d %H:%M:%S", local_time))  # 转化为定制的格式 2019-12-22 18:13:41

'''16.字符时间转时间'''
# parse str time to struct time
struct_time = strptime('2019-12-22 10:10:08', "%Y-%m-%d %H:%M:%S")
print(struct_time) # struct_time类型就是time中的一个类

# time.struct_time(tm_year=2019, tm_mon=12, tm_mday=22, tm_hour=10, tm_min=10, tm_sec=8, tm_wday=6, tm_yday=356, tm_isdst=-1)

'''17.时间转字符时间'''
print(localtime())  # 这是输入的时间
print(strftime("%m-%d-%Y %H:%M:%S", localtime()))  # 转化为定制的格式
# 这是字符串表示的时间：   12-22-2019 18:26:21


'''18.32加密'''
import hashlib
def hash_cry32(s):
    m  = hashlib.md5()
    m.update((str(s).encode('utf-8')))
    return m.hexdigest()
print(hash_cry32(1))  # c4ca4238a0b923820dcc509a6f75849b
print(hash_cry32('hello'))  # 5d41402abc4b2a76b9719d911017c592






























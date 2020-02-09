'''
常用的绘图工具包括:matplotlib,seaborn,ploty等
绘图轨迹turtle包
'''

'''
import turtle

#1.turtle绘制奥运五环图
import turtle as p
#定义画圆函数
def drawCircle(x,y,c='red'):
    p.pu()#抬起画笔
    p.goto(x,y)#绘制图的起始位置
    p.pd()#放下画笔
    p.color(c)#绘制c色圆环
    p.circle(30,360)#绘制图：半径，角度


#画笔基本设置
p= turtle
p.pensize(3) #画笔尺寸设置3

#绘制五环图
drawCircle(0,0,'blue')
drawCircle(60,0,'black')
drawCircle(120,0,'red')
drawCircle(90,-30,'green')
drawCircle(30,-30,'yellow')
p.done()
'''

'''2.turtle绘制漫天雪花'''
'''导入turtle库和random'''
import turtle as p
import random

#绘制雪花
def snow(snow_count):
    p.hideturtle()
    p.speed(500)
    p.pensize(2)
    for i in range(snow_count):
        r = random.random()
        g = random.random()
        b = random.random()
        p.pencolor(r, g, b)
        p.pu()
        p.goto(random.randint(-350, 350), random.randint(1, 270))
        p.pd()
        dens = random.randint(8, 12)
        snowsize = random.randint(10, 14)
        for _ in range(dens):
            p.forward(snowsize)  # 向当前画笔方向移动snowsize像素长度
            p.backward(snowsize)  # 向当前画笔相反方向移动snowsize像素长度
            p.right(360 / dens)  # 顺时针移动360 / dens度

#绘制地面
def ground(ground_line_count):
    p.hideturtle()
    p.speed(500)
    for i in range(ground_line_count):
        p.pensize(random.randint(5,10))
        x = random.randint(-400, 350)
        y = random.randint(-280, -1)
        r = -y / 280
        g = -y / 280
        b = -y / 280
        p.pencolor(r, g, b)
        p.penup()  # 抬起画笔
        p.goto(x, y)  # 让画笔移动到此位置
        p.pendown()  # 放下画笔
        p.forward(random.randint(40, 100))  # 眼当前画笔方向向前移动40~100距离


#主函数
def main():
    p.setup(800,600,0,0)
    p.bgcolor('black')
    snow(30)
    ground(30)
    p.mainloop()
main()

'''3.wordcloud词云图
import hashlib
import pandas as pd
from wordcloud import WordCloud
geo_data = pd.read_excel(r'../data/geo_data.xlsx')
print(geo_data)


words = ','.join(x for x in geo_data['city'] if x != []) #筛选出非空列表值
wc = WordCloud(
    background_color="green", #背景颜色"green"绿色
    max_words=100, #显示最大词数
    font_path='./fonts/simhei.ttf', #显示中文
    min_font_size=5,
    max_font_size=100,
    width=500  #图幅宽度
    )
x = wc.generate(words)
x.to_file('../data/geo_data.png')
'''


'''4.plotly画柱状图和折线图'''
import plotly.graph_objects as go
fig=go.Figure()
fig.add_trace(
    go.Scatter(
        x=[0,1,2,3,4,5],
        y=[1.5,1,1.3,0.7,0.8,0.9]
    )
)
fig.add_trace(
    go.Bar(
        x=[0,1,2,3,4,5],
        y=[2,0.5,0.7,-1.2,0.3,0.4]
    )
)
fig.show()

'''5.seaborn热力图'''
import seaborn as sns
import pandas as pd
import numpy as np
import matplotlib.pyplot as plt

#生成数据集
data = np.random.random((6,6))
np.fill_diagonal(data,np.ones(6))
features = ["prop1","prop2","prop3","prop4","prop5", "prop6"]
data = pd.DataFrame(data, index = features, columns=features)
print(data)
# 绘制热力图
heatmap_plot = sns.heatmap(data, center=0, cmap='gist_rainbow')
plt.show()


'''6.matplotlib折线图'''
'''7.matplotlib散点图'''
'''8.matplotlib柱状图'''
'''9.matplotlib等高线图'''
'''10.imshow图'''
































"""绘制奥运五环图"""


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

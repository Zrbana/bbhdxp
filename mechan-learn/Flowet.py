import pandas as pd
import matplotlib.pyplot as plt
import numpy as np
#从UCI机器学习库把鸢尾花数据集直接加载到
#DataFrame对象
from Perceptorn import Perceptron

df = pd.read_csv('C:\pythoncode\iris.data',header=None)
print(df.tail())

#选取setosa和versicolor
y = df.iloc[0:100,4].values
y = np.where(y== 'Iris-setosa',-1,1)
# 额外的萼片长度和花瓣长度
x  = df.iloc[0:100,[0,2]].values

#绘图数据
plt.scatter(x[:50,0],x[:50,1],color='red',marker='o',label='山鸢尾')
plt.scatter(x[50:100,0],x[50:100,1],color='blue',marker='x',label='变色鸢尾')
plt.xlabel=('sepal length [cm]')
plt.ylabel=('petal length [cm]')
plt.legend(loc='upper left')
plt.show()

ppn = Perceptron(eta=0.1,n_iter=10)
ppn.fit(x,y)
plt.plot(range(1,len(ppn.errors_)+1),ppn.errors_,marker='o')
#plt.xlabel('Epochs')
#plt.ylabel('Number of updates')
#plt.show()










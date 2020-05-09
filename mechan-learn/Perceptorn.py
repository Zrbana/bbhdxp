#实现感知器

import numpy as np

class Perceptron(object):
    """
    感知器分类器：
    参数：
    eta:float 学习率（0.0-1.1）
    n_iter:int  遍历训练集 训练次数
    random_state:int  随机数产生的种子为随机权重的初始值


    属性：
    ----------
    w_ : ld_array  加权拟合后

    errors:list  每个纪元中错误分类的数目

    根据指定的学习率，训练次数，初始化新的Perceptron对象
    """
    def __init__(self,eta=0.01,n_iter=50,random_sate=1):
        self.eta = eta
        self.n_iter = n_iter
        self.random_state = random_sate

    def fit(self,X,y):
        """
        合适的训练数据
        :param X: 类似于数组 {N_样本数量，N_特征数量}
        :param y: 类似于数组，[N_样本数]  目标数量
        :return: object
        """
        rgen = np.random.RandomState(self.random_state)
        """初始化self_w的权重"""
        """产生标准差为0.01的正态分布"""
        self.w_ = rgen.normal(loc=0.0,scale=0.01,size=1+X.shape[1])
        self.errors_=[]
        for _ in range(self.n_iter):
            errors= 0
            for xi,target in zip(X,y):
                update = self.eta * (target -self.predict(xi))
                self.w_[1:] += update*xi
                """self.w_[0]代表前面讨论过的偏差"""
                self.w_[0] += update
                errors += int(update != 0.0)
            self.errors_.append(errors)
        return self

    def net_input(self,X):
        """计算净额"""
        return np.dot(X,self.w_[1:])+self.w_[0]

    def predict(self,X):
        """单位步骤后返回类标签"""
        return np.where(self.net_input(X) >= 0.0,1,-1)


















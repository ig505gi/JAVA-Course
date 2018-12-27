# 基于MOOC 面向对象语言--JAVA 程序设计

## 1.一些设计原则
### 1.1. 消除代码复制

### 1.2. 封装
用封装来降低耦合

### 1.3. 可扩展性
用 框架+数据 提高扩展性  
方法：i）命令的解析是否可以脱离if-else  
     ii）定义一个Handler类来处理命令  
     iii）用Hash表来保存Handler和命令的关系

### 1.4. 接口的引入
设计程序时，先定义接口，再实现类  
任何需要在函数间传入传出的一定是接口而不是具体的类

## 2.设计思想
### 2.1. 控制反转
![控制反转](https://github.com/CoderOrigin/JAVA-Course/blob/firstBranch/image/%E6%8E%A7%E5%88%B6%E5%8F%8D%E8%BD%AC.png)  
Jbutton类想要实现按下去，调用step()的操作，但是我们不能在Jbutton类中再定义，是原本的框架。  
但是Jbutton类实现了ActionListener接口，并且有addActionListener函数。  
ActionListener接口中只有一个actionPerfomed函数， btnStep实例执行addActionListener函数后，就将actionPerfomed函数注册给了btnStep  
当btnStep被按下去的时候，就会执行外部override的actionPerfomed函数。  
### 2.2. MVC
View-Model-Control  
View 和 Control不直接有关系，通过Model(模型、数据)来连接

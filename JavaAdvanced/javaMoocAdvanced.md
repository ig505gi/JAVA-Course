# Mooc视频学习： 面向对象语言---JAVA

## 1.类的定义

### 1.1 对象、函数
对象 = 属性 + 服务

数据：属性，状态

操作：函数

操作是包含着数据的，把数据和对数据的操作放在一起，数据不对外面公开-->**封装**
### 1.2 this
在成员函数内部可以用this调用其他成员函数

### 1.3 成员变量&本地变量

本地变量：生存期和作用域都在函数内部，定义在函数内部

成员变量：生存期是对象的生成期，作用域是类中的成员函数，定义在类中

### 1.4 构造函数
构造函数与类名相同，没有返回类型，

重载：可以有多个构造函数，根据参数不同调用不同的构造函数

创建对象的时候，先调用构造函数，再初始化成员变量，再进入构造函数内部。

### 1.5 toString()
 可以用于任何一个类中，使类的输出变成想要的结果

## 2 对象交互
### 2.1 访问属性
**private** 
私有成员是类的私有，不是对象的私有，可以在类中访问不同对象的私有变量。

**friendly**
如果前面不加访问属性，就是friendly，在同一个包里可以使用

### 2.2 类变量
**static** 静态变量，是类的变量，不是对象的变量，可以用”类.“去访问

同样，函数前加 static，函数是类函数。

**static函数只能调用static函数，只能访问static变量**

### 2.3  public&编译单元
public 类的定义加上public，该类一定在以该类命名的java文件中，如： 

`public class test{}` 一定在test.java中

一个 \*\*.java是一个编译单元，里面只能有一个public类，并且和文件名相同
## 3 包
### 3.1
在一个包pac下面的的每个java文件一定有一行`package pac`

包中类的调用方式：
![package](https://github.com/CoderOrigin/JAVA-Course/blob/firstBranch/image/package.png)

## 4 对象容器
### 4.1 定义

`ArrayList<String> notes = new ArrayList<String>();`

定义了一个存放String的ArrayList，ArrayList是一种范型类，就是一种容器

容器的输出带着方括号

### 4.2 对象数组
对象数组的每一个元素都是对象的管理者，而非对象本身

不像int数组，for-each循环的时候，不能对每个元素赋值，

对象数组和对象容器都可以在for-each循环中，对对象的成员变量赋值。

### 4.3 set定义

`HashSet<String> notes = new HashSet<String>();`

HashSet没有重复元素，乱序

### 4.4 Hash(类似python中字典)

`HashMap<Integer, String> hm = new Hashmap<Integer, String>();`

需要用Integer，int的包裹类型，都是类的名字

`hm.put(5, "five")` 用于往HashMap的对象中放元素

重复key进行put，value会覆盖


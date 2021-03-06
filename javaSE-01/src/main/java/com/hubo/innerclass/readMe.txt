1、为什么要使用内部类?
使用内部类最吸引人的原因是：每个内部类都能独立地继承一个（接口的）实现，所以无论外围类是否已经继承了某个（接口的）实现，
对于内部类都没有影响；（解决java无法多继承）

2、其实使用内部类最大的优点就在于它能够非常好的解决多重继承的问题，但是如果我们不需要解决多重继承问题，那么我们自然可以使用其他的编码方式，
但是使用内部类还能够为我们带来如下特性（摘自《Think in java》）：
1、内部类可以用多个实例，每个实例都有自己的状态信息，并且与其他外围对象的信息相互独立。
2、在单个外围类中，可以让多个内部类以不同的方式实现同一个接口，或者继承同一个类。
3、创建内部类对象的时刻并不依赖于外围类对象的创建。
4、内部类并没有令人迷惑的“is-a”关系，他就是一个独立的实体。
5、内部类提供了更好的封装，除了该外围类，其他类都不能访问。

3、内部类分类：成员内部类、局部内部类、匿名内部类、静态内部类。

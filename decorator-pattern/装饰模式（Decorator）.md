### 1. 定义  
> 动态的给一个对象添加一些额外的职责。就增加功能来说，装饰模式比生成子类更为灵活。
### 2. 结构   

![image](https://github.com/ljmomo/learn-pattern/blob/master/decorator-pattern/src/main/java/com/junli/structure/structure.png)
- Component：组件对象的接口，可以给这些对象动态添加职责。
- ConcreteComponent:具体的组件对象，实现组件对象接口，通常就是被装饰的原始对象，也就是可以给这个对象添加职责。
- Decorator：所有装饰器的抽象父类，需要定义一个与组件接口一致的接口，并持有一个Component对象，其实就是持有一个被装饰的对象。
- ConcreteDecorator:实际的装饰对象，实现具体要被装饰对象添加的功能。


### 3. 实例
  下面以人吃饭为例,一般人吃饭没什么讲究直接吃饭就先来个，稍微讲究点的人吃饭的时候要洗手，比较讲究的人不仅吃饭前要洗手，吃完饭后还要要吃水果或者喝个汤什么的。
  
Person  
```
/**
 * Person(相当于 Component)
 * @author lijun
 * @since 2018-03-22 10:19
 */
public interface Person {
   public void  eat();
}
```


ConcretePerson
```
/**
 * 一般人（ConcreteComponent）
 * @author lijun
 * @since 2018-03-22 10:45
 */
public class ConcretePerson  implements Person {
    @Override
    public void eat() {
        System.out.println("吃饭。。。");
    }
}

```

Decorator

```
/**
 * 装饰对象
 * @author lijun
 * @since 2018-03-22 10:49
 */
public interface Decorator extends Person  {
}

```


DecoratorPersonA  
```
/**
 * DecoratorPersonA(实际的装饰对象，实现具体要被装饰对象添加的功能)
 *
 * @author lijun
 * @since 2018-03-22 10:52
 */
public class DecoratorPersonA implements Decorator {
    private Person person;

    public DecoratorPersonA(Person person) {
        this.person = person;
    }

    /**
     * 添加 上菜
     */
    private void washHands() {
        System.out.println("洗手。。。");
    }

    @Override
    public void eat() {
        washHands();
        person.eat();
    }

}

```


```
/**
 * DecoratorPersonB(实际的装饰对象，实现具体要被装饰对象添加的功能)
 *
 * @author lijun
 * @since 2018-03-22 10:52
 */
public class DecoratorPersonB implements Decorator {

    private Person person;

    public DecoratorPersonB(Person person) {
        this.person = person;
    }


    private void addFruit() {
        System.out.println("吃水果。。。");
    }

    @Override
    public void eat() {
        person.eat();
        addFruit();
    }
}
```

调用：
```
@Test
    public void  testPerson(){

        System.out.println("一般人吃饭");
        Person person = new ConcretePerson();
        person.eat();

        System.out.println("\t");
        System.out.println("稍微讲究点的人吃饭");
        Decorator decoratorA = new DecoratorPersonA(person);
        decoratorA.eat();


        System.out.println("\t");
        System.out.println("比较稍微讲究点的人吃饭");
        Decorator decoratorB = new DecoratorPersonB(decoratorA);
        decoratorB.eat();
    }
```

输出
```
一般人吃饭
吃饭。。。
	
稍微讲究点的人吃饭
洗手。。。
吃饭。。。
	
比较稍微讲究点的人吃饭
洗手。。。
吃饭。。。
吃水果。。。

```

### 4. 本质
> 动态组合。

### 5. 总结
1. 优点：  
- 比继承更灵活
- 更容易复用
- 简化高层定义
2. 缺点
- 会产生很多细粒度对象
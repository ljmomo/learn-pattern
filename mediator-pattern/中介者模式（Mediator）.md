### 1. 定义  
> 用一个中介对象来封装一系列的对象交互。中介者使各对象不需要显式地相互引用，从而使其耦合松散，而且可以独立地改变它们之间的交互。
### 2.结构  
![image](https://note.youdao.com/yws/public/resource/1e7c6f702c833e86bab289ce26ff8b8e/xmlnote/865766DBE8FC4BE9A9F1059B26453FB9/14369)

- Mediator:中介者定义一个接口用于与各同事（Colleague）对象通信。
- ConcreteMediator:具体中介者通过协调各同事对象实现协作行为，了解并维护它的各个同事。
- Colleague:抽象同事类。
- ConcreteColleague：具体同事类。每个具体同事类都只需要知道自己的行为即可，但是他们都需要认识中介者。


### 3. 实例 
我们使用一个例子来说明一下什么是同事类：有两个类A和B，类中各有一个数字，并且要保证类B中的数字永远是类A中数字的100倍。也就是说，当修改类A的数时，将这个数字乘以100赋给类B，而修改类B时，要将数除以100赋给类A。类A类B互相影响，就称为同事类。
不使用中介者的实现：

AbstractColleague
```
/**
 * @author lijun
 * @since 2018-04-09 9:37
 */
public abstract class AbstractColleague {
    protected int number;    
    
    public int getNumber() {    
        return number;    
    }    
    
    public void setNumber(int number){    
        this.number = number;    
    }
    /**
     * 抽象方法，修改数字时同时修改关联对象
     */
    public abstract void setNumber(int number, AbstractColleague coll);
}    
```


ConcreteColleagueA

```
/**
 * @author lijun
 * @since 2018-04-09 9:37
 */
public class ConcreteColleagueA extends AbstractColleague{
    @Override
    public void setNumber(int number, AbstractColleague coll) {
        this.number = number;    
        coll.setNumber(number*100);    
    }    
}    
```


ConcreteColleagueB
```
/**
 * @author lijun
 * @since 2018-04-09 9:37
 */
public class ConcreteColleagueB extends AbstractColleague{
        
    @Override
    public void setNumber(int number, AbstractColleague coll) {
        this.number = number;    
        coll.setNumber(number/100);    
    }    
} 
```
Client

```
public class Client {
    public static void main(String[] args){    
    
        AbstractColleague collA = new ConcreteColleagueA();
        AbstractColleague collB = new ConcreteColleagueB();
            
        System.out.println("==========设置A影响B==========");    
        collA.setNumber(1288, collB);    
        System.out.println("collA的number值："+collA.getNumber());    
        System.out.println("collB的number值："+collB.getNumber());    
    
        System.out.println("==========设置B影响A==========");    
        collB.setNumber(87635, collA);    
        System.out.println("collB的number值："+collB.getNumber());    
        System.out.println("collA的number值："+collA.getNumber());    
    }    
}   
```

输出
```
==========设置A影响B==========
collA的number值：1288
collB的number值：128800
==========设置B影响A==========
collB的number值：87635
collA的number值：876
```

上面的代码中，类A类B通过直接的关联发生关系，假如我们要使用中介者模式，类A类B之间则不可以直接关联，他们之间必须要通过一个中介者来达到关联的目的。


Mediator 中介者接口

```
/**
 *  中介者接口
 * @author lijun
 * @since 2018-04-09 9:34
 */
public interface Mediator {

    /**
     *影响A
     */
    public void  affectA();

    /**
     *
     */
    public void  affectB();
}

```
ConcreteMediator  具体的中介者

```
/**
 * 具体的中介者
 *
 * @author lijun
 * @since 2018-04-09 9:37
 */
public class ConcreteMediator implements Mediator {

    /**
     * 中介者持有同事类A
     */
    ConcreteColleagueA  concreteColleagueA;

    /**
     * 中介者持有同类B
     */
    ConcreteColleagueB concreteColleagueB;


    public void setConcreteColleagueA(ConcreteColleagueA concreteColleagueA) {
        this.concreteColleagueA = concreteColleagueA;
    }

    public void setConcreteColleagueB(ConcreteColleagueB concreteColleagueB) {
        this.concreteColleagueB = concreteColleagueB;
    }

    /**
     * 影响A
     */
    @Override
    public void affectA() {
        concreteColleagueA.setNumber(concreteColleagueB.getNumber()/100);
    }

    /**
     *
     */
    @Override
    public void affectB() {
        concreteColleagueB.setNumber(concreteColleagueA.getNumber()*100);
    }
}

```


AbstractColleague  同事抽象类
```
/**
 * 同事抽象类
 * @author lijun
 * @since 2018-04-09 9:34
 */
public abstract class AbstractColleague {
    protected int number;
    private Mediator mediator;

    public AbstractColleague(Mediator mediator) {
        this.mediator = mediator;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Mediator getMediator() {
        return mediator;
    }

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    /**
     * 设置number的值
     *
     * @param number   值
     * @param mediator 中介者
     */
    public abstract void setNumber(int number, Mediator mediator);

}

```
ConcreteColleagueA  同事类A

```
/**
 * 同事类A 设置同事类A的值影响B的值
 * 通过中介者来改变B的值
 *
 * @author lijun
 * @since 2018-04-09 9:42
 */
public class ConcreteColleagueA extends AbstractColleague {

    public ConcreteColleagueA(Mediator mediator) {
        super(mediator);
    }
    /**
     * 设置number的值
     *
     * @param number   值
     * @param mediator 中介者
     */
    @Override
    public void setNumber(int number, Mediator mediator) {
        this.number = number;
        mediator.affectB();
    }
}

```

ConcreteColleagueB  同事类B

```
/**
 * 同事类B 设置同事类B的值影响B的值
 * 通过中介者来改变A的值
 *
 * @author lijun
 * @since 2018-04-09 9:42
 */
public class ConcreteColleagueB extends AbstractColleague {

    public ConcreteColleagueB(Mediator mediator) {
        super(mediator);
    }

    /**
     * 设置number的值
     *
     * @param number   值
     * @param mediator 中介者
     */
    @Override
    public void setNumber(int number, Mediator mediator) {
        this.number = number;
        mediator.affectA();
    }
}
```

Client 
```
public class Client {
    public static void main(String[] args) {

        //中介者
        ConcreteMediator mediator = new ConcreteMediator();

        //同事对象
        ConcreteColleagueA concreteColleagueA = new ConcreteColleagueA(mediator);
        ConcreteColleagueB concreteColleagueB = new ConcreteColleagueB(mediator);

        //中介者设置同事对象
        mediator.setConcreteColleagueA(concreteColleagueA);
        mediator.setConcreteColleagueB(concreteColleagueB);

        System.out.println( "==========设置A影响B==========");
        concreteColleagueA.setNumber(100, mediator);
        System.out.println("concreteColleagueA: "+concreteColleagueA.getNumber());
        System.out.println("concreteColleagueB: "+concreteColleagueB.getNumber());

        System.out.println( "==========设置B影响A==========");
        concreteColleagueB.setNumber(1000, mediator);

        System.out.println("concreteColleagueB: "+concreteColleagueB.getNumber());
        System.out.println("concreteColleagueA: "+concreteColleagueA.getNumber());

    }
}
```

输出：
```
==========设置A影响B==========
concreteColleagueA: 100
concreteColleagueB: 10000
==========设置B影响A==========
concreteColleagueB: 1000
concreteColleagueA: 10
```

### 4. 本质
>封装交互


### 5.优缺点和总结
#### 1.优点
- 适当地使用中介者模式可以避免同事类之间的过度耦合，使得各同事类之间可以相对独立地使用。
- 使用中介者模式可以将对象间一对多的关联转变为一对一的关联，使对象间的关系易于理解和维护。
- 使用中介者模式可以将对象的行为和协作进行抽象，能够比较灵活的处理对象间的相互作用。

#### 2.缺点
- 过度集中化。如果同事对象的交互非常多，而已比较复杂,当这个复杂性全部集中到中介者的时候，会导致中介者对象变得十分复杂，而且难以管理和维护。

#### 3.总结
  在面向对象编程中，一个类必然会与其他的类发生依赖关系，完全独立的类是没有意义的。一个类同时依赖多个类的情况也相当普遍，既然存在这样的情况，说明，一对多的依赖关系有它的合理性，适当的使用中介者模式可以使原本凌乱的对象关系清晰，但是如果滥用，则可能会带来反的效果。一般来说，只有对于那种同事类之间是网状结构的关系，才会考虑使用中介者模式。可以将网状结构变为星状结构，使同事类之间的关系变的清晰一些。中介者模式是一种比较常用的模式，也是一种比较容易被滥用的模式。对于大多数的情况，同事类之间的关系不会复杂到混乱不堪的网状结构，因此，大多数情况下，将对象间的依赖关系封装的同事类内部就可以的，没有必要非引入中介者模式。滥用中介者模式，只会让事情变的更复杂。 
  
  源码地址
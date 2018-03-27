### 1. 定义  
> 为子系统中的一组接口提供一个一致的界面，Facade
模式定义了一个高层接口，这个接口使得这一子系统更加容易使用。

### 2.外观模式的结构   
![https://github.com/ljmomo/learn-pattern/blob/master/facade-pattern/src/main/java/com/junli/structure/structure.png](https://note.youdao.com/yws/public/resource/1e7c6f702c833e86bab289ce26ff8b8e/xmlnote/D56CE2FAD64B4DC295CE0E2800D910EB/13661)

- Facade：定义子系统的多个模块对外的高层接口，通常需要调用内部多个模块，从而把客户的请求代理给适当的子系统对象。
- 模块：接受Facade对象的委派，真正实现功能，各个模块之间可能有交互。
- Client：通过调用Facede来完成要实现的功能。

### 3. 实例
   下面以手机为例来实现该模式。  
   一个Phone 都有CPU，Memory(内存)，ROM(存储器)。当手机开启和关闭时，对应部件也会开启和关闭。Phone就相当于一个门面。实现了用户和部件之间的解耦。
 
 CPU  
```
/**
 * CPU
 * @author lijun
 * @since 2018-03-27 16:55
 */
public class CPU {
    /**
     * 启动
     */
    public void start(){
        System.out.println("CPU 启动成功！");
    }

    /**
     * 关闭
     */
    public void shutDown(){
        System.out.println("CPU 关闭成功！");
    }
}
```
Memory
```
/**
 * Memory
 * @author lijun
 * @since 2018-03-27 16:55
 */
public class Memory {
    /**
     * 启动
     */
    public void start(){
        System.out.println("Memory 启动成功！");
    }

    /**
     * 关闭
     */
    public void shutDown(){
        System.out.println("Memory 关闭成功！");
    }
}

```

ROM
```
/**
 * ROM
 * @author lijun
 * @since 2018-03-27 16:55
 */
public class ROM {
    /**
     * 启动
     */
    public void start(){
        System.out.println("ROM 启动成功！");
    }

    /**
     * 关闭
     */
    public void shutDown(){
        System.out.println("ROM 关闭成功！");
    }
}

```

Phone 
```
/**
 * @author lijun
 * @since 2018-03-27 17:04
 */
public class Phone {
    /**
     * cpu
     */
    private CPU cpu = null;

    /**
     * memory
     */
    private Memory memory = null;

    /**
     * rom
     */
    private ROM rom = null;

    public Phone() {
        cpu = new CPU();
        memory = new Memory();
        rom = new ROM();
    }

    /**
     * start
     */
    public void  start(){
        cpu.start();
        memory.start();
        rom.start();
    }

    /**
     * 关闭
     */
    public void  shutDwon(){
        cpu.shutDown();
        memory.shutDown();
        rom.shutDown();
    }

}
```

 Client
```

/**
 * @author lijun
 * @since 2018-03-27 17:12
 */
public class Client {
    public static void main(String[] args) {
        Phone phone = new Phone();
        phone.start();
        phone.shutDwon();

    }
}
```
 
 输出：
```
CPU 启动成功！
Memory 启动成功！
ROM 启动成功！
CPU 关闭成功！
Memory 关闭成功！
ROM 关闭成功！
```
 

### 4.本质 
> 封装交互，简化调用。

### 5.总结
1.  优点
-   松散耦合  
   使得客户端和子系统之间解耦，让子系统内部的模块功能更容易扩展和维护。
- 简单易用  
   客户端根本不需要知道子系统内部的实现，或者根本不需要知道子系统内部的构成，它只需要跟Facade类交互即可。
- 更好的划分访问层次  
有些方法是对系统外的，有些方法是系统内部相互交互的使用的。子系统把那些暴露给外部的功能集中到门面中，这样就可以实现客户端的使用，很好的隐藏了子系统内部的细节。
2.缺点
  过多或者不合理的Facade也容易让人迷惑。到底是调用Facade好呢！还是直接调用模块好。

 [源码地址](https://github.com/ljmomo/learn-pattern)
### 1. 定义
> 定义对象间的一种一对多的依赖关系。当一个对象的状态发生改变时，所有依赖于它的对象都得到通知并被自动更新。

### 2. 结构
![image](https://github.com/ljmomo/learn-pattern/blob/master/observer-pattern/src/main/java/com/junli/structure/struture.png)

- Subject：目标对象，通常具有如下功能能。  
a.  一个目标可以被多个观察者观察  
b. 目标提供对观察者注册和退订的维护
c. 当目标对象的状态发生变化时通知所有注册的有效观察者。
- Observer：定义观察者的接口，提供目标通知时对相应的更新方法。这个更新方法进行相应业务的处理，可以在这个方法里，回调目标对象获取目标对象的数据。
- ConcreteSubject：具体的目标实现对象，用来维护目标状态，当目标对象的状态发生改变时，通知所有的注册者，有效的观察者，让观察者执行相应的处理。
- ConcreteObserver：观察者的具体实现对象，用来接收目标对象的通知，并进行相应的后续处理，比如更新自身状态和目标状态保持一致。

### 3. 实例
  微信公众号订阅  公众号主题就是(Subject)  关注者就是观察者（Observer）一个公众号主题。公众号主题发布一些文章时就会通知所有的关注有多个订阅者。公众号主题发布一些文章时就会通知所有的关注者。下面用JAVA代码来模拟这个过程！
 
 
VipcnSubject      
```

/**
 * 微信公众号主题
 *
 * @author lijun
 * @since 2018-03-23 13:31
 */
public class VipcnSubject {

    private List<VipcnObserver> observers = new ArrayList<>();

    /**
     * 关注
     *
     * @param observer 观察者
     */
    public void attention(VipcnObserver observer) {
        observers.add(observer);
    }

    /**
     * 取消关注
     *
     * @param observer
     */
    public void canelAttention(VipcnObserver observer) {
        observers.remove(observer);
    }

    /**
     * 通知所有的订阅者
     */
    public void notifyVipcnObserver() {
        observers.stream().forEach(observer -> observer.view(this));
    }
}
```

 CsdnVipcnSubject    

```
/**
 * CSDN公众号主题  当发布文章后通知订阅者
 *
 * @author lijun
 * @since 2018-03-23 13:41
 */
public class CsdnVipcnSubject extends VipcnSubject {
    /**
     * 文章
     */
    private String context;


    public String getContext() {
        return context;
    }

    /**
     * 发布文章
     *
     * @param context 文章内容
     */
    public void publishContext(String context) {
        this.context = context;
        this.notifyVipcnObserver();
    }
}

```
VipcnObserver    

```
/**
 * 关注者接口
 *
 * @author lijun
 * @since 2018-03-23 13:33
 */
public interface VipcnObserver {
    /**
     * 查看文章
     */
    void view(VipcnSubject subject);
}
```
    
VipcnObserverA

```
/**
 * 关注者A
 *
 * @author lijun
 * @since 2018-03-23 13:58
 */
public class VipcnObserverA implements VipcnObserver {

    /**
     * 文章
     */
    private String context;

    /**
     * 查看文章
     */
    @Override
    public void view(VipcnSubject subject) {
        CsdnVipcnSubject csdnVipcnSubject = (CsdnVipcnSubject) subject;
        context = csdnVipcnSubject.getContext();
        System.out.println("我是订阅者A,我收到了文章.文章内容是：" + context);
    }
}

```

VipcnObserverB
```
/**
 * 关注者B
 *
 * @author lijun
 * @since 2018-03-23 13:58
 */
public class VipcnObserverB implements VipcnObserver {

    /**
     * 文章
     */
    private String context;

    /**
     * 查看文章
     */
    @Override
    public void view(VipcnSubject subject) {
        CsdnVipcnSubject csdnVipcnSubject = (CsdnVipcnSubject) subject;
        context = csdnVipcnSubject.getContext();
        System.out.println("我是关注者B,我收到了文章.文章内容是：" + context);
    }
}

```


测试
```
    @Test
    public void testVipcn() {
        
        CsdnVipcnSubject subject = new CsdnVipcnSubject();
        //关注
        subject.attention(new VipcnObserverA());
        subject.attention(new VipcnObserverB());

        //发布文章
        subject.publishContext("Spring5.0源码导入IDEA(一)");
    }
```
输出：

```
我是订阅者A,我收到了文章.文章内容是：Spring5.0源码导入IDEA(一)
我是关注者B,我收到了文章.文章内容是：Spring5.0源码导入IDEA(一)
```

其实JAVA中已经有了观察者模式的部分实现，在 java.util.Observable 类中实现了大部分目标类的功能，在 java.util.Observer 接口中定义了update接口，也就是观察者的接口。 下面通过JAVA自带的观察者模式的部分实现来实现上面的例子。



CsdnVipcnSubjectJava

```
/**
 * CSDN公众号主题  当发布文章后通知订阅者
 * @author lijun
 * @since 2018-03-23 16:41
 */
public class CsdnVipcnSubjectJava extends Observable {
    /**
     * 文章
     */
    private String context;


    public String getContext() {
        return context;
    }

    /**
     * 发布文章
     *
     * @param context 文章内容
     */
    public void publishContext(String context) {
        this.context = context;
        //下面这这一部必须有
        this.setChanged();
        this.notifyObservers(this.context);
    }
}

```


VipcnObserverJavaA
```
/**
 * 关注者A
 *
 * @author lijun
 * @since 2018-03-23 13:58
 */
public class VipcnObserverJavaA implements Observer {

    /**
     * 文章
     */
    private String context;


    /**
     * 查看文章
     */
    @Override
    public void update(Observable o, Object arg) {
       /* CsdnVipcnSubjectJava csdnVipcnSubject = (CsdnVipcnSubjectJava)o;
        context = csdnVipcnSubject.getContext();*/
        System.out.println("我是订阅者A,我收到了文章.文章内容是：" + arg);
    }
}

```

VipcnObserverJavaB

```
/**
 * 关注者B
 *
 * @author lijun
 * @since 2018-03-23 13:58
 */
public class VipcnObserverJavaB implements Observer {

    /**
     * 文章
     */
    private String context;


    /**
     * 查看文章
     */
    @Override
    public void update(Observable o, Object arg) {
      /*  CsdnVipcnSubjectJava csdnVipcnSubject = (CsdnVipcnSubjectJava)o;
        context = csdnVipcnSubject.getContext();*/

        System.out.println("我是订阅者A,我收到了文章.文章内容是：" + arg);
    }
}
```

测试

```
    @Test
    public void testVipcnJava() {

        CsdnVipcnSubjectJava subject = new CsdnVipcnSubjectJava();
        //关注
        subject.addObserver(new VipcnObserverJavaA());
        subject.addObserver(new VipcnObserverJavaB());

        //发布文章
        subject.publishContext("Spring5.0源码导入IDEA(一)");
    }
```

输出：
```
我是订阅者A,我收到了文章.文章内容是：Spring5.0源码导入IDEA(一)
我是关注者B,我收到了文章.文章内容是：Spring5.0源码导入IDEA(一)
```
结果和上面的例子一样。

上面的例子还有另一种稍微变形的实现：



Event

```
/**
 * 事件
 * @author lijun
 * @since 2018-03-23 14:51
 */
public class Event {

    //事件源
    private Object source;
    //通知目标
    private Object target;
    //回调
    private Method callback;
    //触发
    private String trigger;

    private long time;

    public Event(Object target, Method callback) {
        this.target = target;
        this.callback = callback;
    }


    public Object getSource() {
        return source;
    }


    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    public Method getCallback() {
        return callback;
    }

    public void setCallback(Method callback) {
        this.callback = callback;
    }

    public String getTrigger() {
        return trigger;
    }

    @Override
    public String toString() {
        return "Event{" +
                "\n\tsource=" + source + ",\n" +
                "\ttarget=" + target + ",\n" +
                "\tcallback=" + callback + ",\n" +
                "\ttrigger='" + trigger + '\'' + "\n" +
                '}';
    }

    public long getTime() {
        return time;
    }

    Event setTime(long time) {
        this.time = time;
        return this;
    }

    Event setSource(Object source) {
        this.source = source;
        return this;
    }

    Event setTrigger(String trigger) {
        this.trigger = trigger;
        return this;
    }
}

```

EventLisenter

```

/**
 * 事件的注册和监听
 *
 * @author lijun
 * @since 2018-03-23 15:07
 */
public class EventLisenter {

    /**
     * Map相当于是一个注册器
     */
    protected Map<Enum, Event> events = new HashMap<Enum, Event>();

    /**
     * 注册事件
     *
     * @param eventType eventType
     * @param target    target
     * @param callback  callback
     */
    public void addLisenter(Enum eventType, Object target, Method callback) {
        //注册事件
        //用反射调用这个方法
        events.put(eventType, new Event(target, callback));
    }

    /**
     * 触发事件
     *
     * @param e
     */
    private void trigger(Event e) {
        e.setSource(this);
        e.setTime(System.currentTimeMillis());

        try {
            e.getCallback().invoke(e.getTarget(), e);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }


    protected void trigger(Enum call) {
        if (!this.events.containsKey(call)) {
            return;
        }
        trigger(this.events.get(call).setTrigger(call.toString()));
    }

}
```


CsdnVipcnSubjectSelf 
```

/**
 * 被观察者
 *
 * @author lijun
 * @since 2018-03-23 15:42
 */
public class CsdnVipcnSubjectSelf extends EventLisenter {
    /**
     * 文章或者文字类容
     */
    private String context;

    public String getContext() {
        return context;
    }

    /**
     * 发布文章
     *
     * @param context 内容
     */
    public void publishArtcle(String context) {
        this.context = context;
        System.out.println("发布文章。。。。");
        this.trigger(VipcnEventType.PUBLISH_ARTICLE);
    }


    /**
     * 发布文字
     *
     * @param context 内容
     */
    public void publishArtcleText(String context) {
        this.context = context;
        System.out.println("发布文字。。。。");
        this.trigger(VipcnEventType.PUBLISH_TEXT);
    }

}

```


VipcnEventType
```
/**
 * 事件枚举
 * @author lijun
 * @since 2018-03-23 15:11
 */
public enum VipcnEventType {
    PUBLISH_ARTICLE,
    PUBLISH_TEXT;
}

```

VipcnEventCallback

```
/**
 * 观察者
 * 回调响应的逻辑，由自己实现
 *
 * @author lijun
 * @since 2018-03-23 15:20
 */
public class VipcnEventCallback {

    /**
     * 发布文件的通知
     *
     * @param e 事件
     */
    public void publishArticle(Event e) {
        System.out.println("观察者收到发布的文章，文章内容是：" + ((CsdnVipcnSubjectSelf) e.getSource()).getContext());
    }

    /**
     * 发布文件的通知
     *
     * @param e 事件
     */
    public void publishText(Event e) {
        System.out.println("观察者收到发布的文字，文字内容是：" + ((CsdnVipcnSubjectSelf) e.getSource()).getContext());
    }

}

```

测试：

```
 @Test
    public void testWechatCore() {
        try {

            VipcnEventCallback callback = new VipcnEventCallback();

            Method publishArticle = VipcnEventCallback.class.getMethod("publishArticle", Event.class);

            Method publishText = VipcnEventCallback.class.getMethod("publishText", Event.class);


            CsdnVipcnSubjectSelf csdnVipcnSubjectCore = new CsdnVipcnSubjectSelf();

            //添加发布文章的监听
            csdnVipcnSubjectCore.addLisenter(VipcnEventType.PUBLISH_ARTICLE, callback, publishArticle);

            //添加发布文字的监听
            csdnVipcnSubjectCore.addLisenter(VipcnEventType.PUBLISH_TEXT, callback, publishText);

            csdnVipcnSubjectCore.publishArtcle("Spring5.0源码导入IDEA(一)");
            csdnVipcnSubjectCore.publishArtcleText("今天晚上发红包！");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
```

输出：

```
发布文章。。。。
观察者收到发布的文章，文章内容是：Spring5.0源码导入IDEA(一)
发布文字。。。。
观察者收到发布的文字，文字内容是：今天晚上发红包！
```

### 4. 本质
>触发联动。


### 5. 总结
1. 优点
- 观察者模式实现了观察者和目标之间的抽象耦合
- 观察者实现了动态联动
- 观察者模式支持广播通讯
2. 缺点
- 可能会引起无谓的操作

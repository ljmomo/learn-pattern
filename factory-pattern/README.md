### 目标
1. 主要是Car为例来学习工厂模式
2. 主要是自己学习的一个记录 以前设计模式也仔细研究过没有进行整理，虽然也放在github上 已经是很久之前的事情了，这次刚好跟着课程，重新学习重新整理。

### 简单工厂模式

1. 定义
   提供一个创建对象实例的功能，而无须关心其具体实现。被创建实例的类型可以是接口，抽象类，也可以是具体的类。
2. 本质 选择实现   
3. 实例

   下面以汽车car）为例：
    
```
public interface Car {
    /**
     * 获取车的名字
     */
     String getName();
}

```


```
public class BmCar implements Car {
    /**
     * 获取车的名字
     */
    @Override
    public String getName() {
        return "宝马车";
    }
}
```

```
public class BenzCar implements Car {
    /**
     * 获取车的名字
     */
    @Override
    public String getName() {
        return "奔驰车";
    }
}
```
 上面创建了一个Car接口和其两个实现类 BmCar和BenzCar   
 如果不使用简单工厂使用该类
 
```
 @Test
    public void createCar() {
      Car car = new BmCar();
      car.getName();
    }
```
这样调用者不仅知道接口，同时还知道实现类。这样就违背了接口的思想“封装隔离”.Car的实现类应该和调用者隔离开的，调用者根本不应该知道实现类BmCar。这个时候就可以用简单工厂.

新增 汽车简单工厂类(CarSimpleFactory)

```
public class CarSimpleFactory {
    
    private CarSimpleFactory() {
    }

    public static Car getCar(String name) throws Exception{
        Car car = null;
        if ("bm".equals(name)){
            car = new BmCar();
        }else if ("bc".equals(name)){
            car = new BenzCar();
        }else{
            throw new Exception("找不到要创建的Car");
        }
        return car;
    }
}
```
调用代码如下:

```
@Test
public void  createCarBySimpleFactory() throws Exception {
    Car car = CarSimpleFactory.getCar("bm");
    car.getName();
}
```

### 工厂方法模式
1. 定义   
    工厂方法模式（FACTORYMETHOD）是一种常用的对象创建型设计模式,此模式的核心精神是封装类中不变的部分，提取其中个性化善变的部分为独立类，通过依赖注入以达到解耦、复用和方便后期维护拓展的目的。
2. 本质 延迟到子类来选择实现
3. 实例
   还是以Car为例

CarFuncFactory
    
```
public abstract class CarFuncFactory {

    /**
     * 获取
     * @return car
     */
    protected abstract Car getCar();

    public String showName(){
        Car car = getCar();
        return car.getName();
    }
}
```

BmCarFuncFactory
```
public class BmCarFuncFactory extends CarFuncFactory {
    /**
     * 获取
     *
     * @return car
     */
    @Override
    public Car getCar() {
        return new BmCar();
    }
}

```


BenzCarFuncFactory
```
public class BenzCarFuncFactory extends CarFuncFactory {
    /**
     * 获取
     *
     * @return car
     */
    @Override
    public Car getCar() {
        return new BenzCar();
    }
}
```

调用

```
    @Test
    public void  createCarByFuncFactory(){
        CarFuncFactory funcFactory = new BmCarFuncFactory();
        System.out.println(funcFactory.showName());

    }
```


### 抽象工厂
1. 定义 提供一个创建一系列相关或相互依赖对象的接口，而无需指定他们具体的类！
2. 本质 选择产品簇的实现
3. 实例
   随着造成工厂规模不断扩大现在造车场可以同时奔驰和宝马车。



AbstractFactory
```
public interface AbstractFactory {
    /**
     * 获取宝马对象
     * @return Car
     */
    Car getBmCar();

    /**
     * 获取奔驰对象
     * @return Car
     */
    Car getBenzCar();

}
```

CarFactory

```
public class CarFactory implements AbstractFactory {
    /**
     * 获取宝马对象
     *
     * @return
     */
    @Override
    public Car getBmCar() {
        return new BmCar();
    }

    /**
     * 获取奔驰对象
     *
     * @return
     */
    @Override
    public Car getBenzCar() {
        return new BenzCar();
    }
}

```
调用
```
 @Test
    public  void createCarAbstrFactory(){
        AbstractFactory carFactory = new CarFactory();
        carFactory.getBenzCar().getName();
        carFactory.getBmCar().getName();
    }
```

以上创建两种类型的car只能像如上代码那，用抽象工厂创建两次 其实我们可以引入一个角色叫Car工程师，由工程师来同时创建奔驰和宝马车。如下提供加入工程师的角色的代码。

CarEngineer

```
public class CarEngineer {
    /**
     *宝马
     */
    private BmCar bmCar =null;

    /**
     *奔驰
     */
    private BenzCar benzCar = null;

    public void makeCar(AbstractFactory abstractFactory) throws Exception {

        //获取宝马Car
        this.bmCar = abstractFactory.getBmCar();

        //获取奔驰Car
        this.benzCar =  abstractFactory.getBenzCar();

    }
}
```

调用
```
 @Test
    public  void createCarAbstrFactoryRef() throws Exception {
        CarEngineer carEngineer = new CarEngineer();
        AbstractFactory abstractFactory = new CarFactory();
        carEngineer.makeCar(abstractFactory);
    }
```

其实如上设计还存在一个问题如果我想加入一个类型的车 抽象工厂需要改变 抽象工厂的实现也要改变，这样其实很麻烦。比如我们这个工厂随着技术实力越来越强可以造BL汽车。这样就要修改抽象工厂和实现了！采用如下解决方式！抽象类添加一个参数。

BlCar
```
public class BlCar implements Car {
    /**
     * 获取车的名字
     */
    @Override
    public String getName() {
        return "宾利汽车";
    }
}

```


AbstractFactoryExtra

```
public interface AbstractFactoryExtra {
    /**
     * 获得车
     * @param type
     * @return
     */
    public Car getCar(int type) throws Exception;
}
```

CarFactoryExtra

```
public class CarFactoryExtra implements AbstractFactoryExtra{
    /**
     * 获得车
     *
     * @param type
     * @return
     */
    @Override
    public Car getCar(int type) throws Exception {
        Car car = null;
        if (type == 1) {
            car = new BmCar();
        } else if (type == 2) {
            car = new BenzCar();
        } else if (type == 3) {
            car = new BlCar();
        }else {
            throw new Exception("找不到！");
        }
        return car;
    }
}
```

CarEngineerExtra

```
public class CarEngineerExtra {
    /**
     *宝马
     */
    private BmCar bmCar =null;

    /**
     *奔驰
     */
    private BenzCar benzCar = null;

    /**
     *奔驰
     */
    private BlCar blCar = null;

    public void makeCar(AbstractFactoryExtra abstractFactoryExtra) throws Exception {

        //获取宝马Car
        this.bmCar = (BmCar) abstractFactoryExtra.getCar(1);

        //获取奔驰Car
        this.benzCar = (BenzCar) abstractFactoryExtra.getCar(2);

        //获取宾利Car
        this.blCar = (BlCar) abstractFactoryExtra.getCar(3);
    }

}
```
调用

```
    @Test
    public  void createCarAbstrFactoryExtra() throws Exception {
        CarEngineerExtra carEngineer = new CarEngineerExtra();
        AbstractFactoryExtra abstractFactoryExtra = new CarFactoryExtra();
        carEngineer.makeCar(abstractFactoryExtra);
    }
```




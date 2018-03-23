package com.junli;

import com.junli.examples.core.Event;
import com.junli.examples.mouse.Mouse;
import com.junli.examples.mouse.MouseEventCallback;
import com.junli.examples.mouse.MouseEventType;
import com.junli.examples.wechat.CsdnVipcnSubject;
import com.junli.examples.wechat.VipcnObserverA;
import com.junli.examples.wechat.VipcnObserverB;
import com.junli.examples.wechat.java.CsdnVipcnSubjectJava;
import com.junli.examples.wechat.java.VipcnObserverJavaA;
import com.junli.examples.wechat.java.VipcnObserverJavaB;
import com.junli.examples.wechat.self.CsdnVipcnSubjectSelf;
import com.junli.examples.wechat.self.VipcnEventCallback;
import com.junli.examples.wechat.self.VipcnEventType;
import com.junli.structure.ConcreteObserver;
import com.junli.structure.ConcreteSubject;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * Unit test for simple App.
 */
public class AppTest {
    @Test
    public void testStructure() {
        ConcreteSubject subject = new ConcreteSubject();
        subject.attach(new ConcreteObserver());
        subject.setSubjectState("NICE");
    }

    @Test
    public void testVipcn() {

        CsdnVipcnSubject subject = new CsdnVipcnSubject();
        //关注
        subject.attention(new VipcnObserverA());
        subject.attention(new VipcnObserverB());

        //发布文章
        subject.publishContext("Spring5.0源码导入IDEA(一)");
    }


    @Test
    public void testVipcnJava() {

        CsdnVipcnSubjectJava subject = new CsdnVipcnSubjectJava();
        //关注
        subject.addObserver(new VipcnObserverJavaA());
        subject.addObserver(new VipcnObserverJavaB());

        //发布文章
        subject.publishContext("Spring5.0源码导入IDEA(一)");
    }


    @Test
    public void testMouse() {

        try {
            MouseEventCallback callback = new MouseEventCallback();
            Method onClick = MouseEventCallback.class.getMethod("onClick", Event.class);

            Mouse mouse = new Mouse();
            mouse.addLisenter(MouseEventType.ON_CLICK, callback, onClick);
            mouse.click();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


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
}

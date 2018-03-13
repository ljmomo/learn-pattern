package com.junli.custom;
import com.junli.staticed.Star;
import java.lang.reflect.Method;
public class $Proxy4 implements com.junli.staticed.Star{
LIInvocationHandler h;
public $Proxy4(LIInvocationHandler h) { 
this.h = h;}
public void signContract() {
try{
Method m = com.junli.staticed.Star.class.getMethod("signContract",new Class[]{});
this.h.invoke(this,m,null);
}catch(Throwable e){
e.printStackTrace();
}}public void collectMoney() {
try{
Method m = com.junli.staticed.Star.class.getMethod("collectMoney",new Class[]{});
this.h.invoke(this,m,null);
}catch(Throwable e){
e.printStackTrace();
}}public void confer() {
try{
Method m = com.junli.staticed.Star.class.getMethod("confer",new Class[]{});
this.h.invoke(this,m,null);
}catch(Throwable e){
e.printStackTrace();
}}public void sing() {
try{
Method m = com.junli.staticed.Star.class.getMethod("sing",new Class[]{});
this.h.invoke(this,m,null);
}catch(Throwable e){
e.printStackTrace();
}}}

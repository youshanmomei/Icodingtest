package org.hy.test.c4;

/**
 * Created by andy on 2016/12/15.
 * 用Java代码实现中介者模式，中介者模式包装了一系列对象相互作用的方式，使得这些对象不必互相明显引用，从而实现松耦合
 *
 * 引入中介者模式，就是将网状结构变成星型结构 http://blog.csdn.net/chenhuade85/article/details/8141831
 */
abstract class Link {
    protected int number;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public abstract void setNumber(int number, AbstractMediator am);
}

class LinkA extends Link {
    @Override
    public void setNumber(int number, AbstractMediator am) {
        this.number = number;
        am.AaffectB();
    }
}

class LinkB extends Link {
    @Override
    public void setNumber(int number, AbstractMediator am) {
        this.number = number;
        am.BaffectA();
    }
}

abstract class AbstractMediator {
    protected Link A;
    protected Link B;

    public AbstractMediator(Link a, Link b) {
        A = a;
        B = b;
    }
    public abstract void AaffectB();
    public abstract void BaffectA();
}

//No.1
//开始写代码，A、B是两个数，更改任意一个都会使另一个数发生改变，用中介者模式实现这一过程，请构造Mediator类，作为数A和数B的中介者
class Mediator extends AbstractMediator {

    public Mediator(Link a, Link b) {
        super(a, b);
    }

    @Override
    public void AaffectB() {
        int aNum = A.getNumber();
        B.setNumber(aNum*10);
    }

    @Override
    public void BaffectA() {
        int bNum = B.getNumber();
        A.setNumber(bNum/10);
    }
}


//end_code
public class MediatorTest {
    public static void main(String[] args) {
        Link linkA = new LinkA();
        Link linkB = new LinkB();

        AbstractMediator am = new Mediator(linkA, linkB);

        System.out.println("通过设置A影响B");
        linkA.setNumber(20, am);
        System.out.println("A的值为：" + linkA.getNumber());
        System.out.println("B的值为A的10倍：" + linkB.getNumber());

        System.out.println("通过设置B影响A");
        linkB.setNumber(200, am);
        System.out.println("B的值为：" + linkB.getNumber());
        System.out.println("A的值为B的0.1倍：" + linkA.getNumber());
    }
}

package org.hy.test.c2;


import java.util.ArrayList;
import java.util.List;

/**
 * Java设计模式之组合类
 * http://www.cnblogs.com/draem0507/p/3794844.html
 */
public class ConSet {

    public static void main(String[] args) {

        Component component = new Composite("根节点");
        Component child = new Composite("周杰伦");
        Component child_1 = new Leaf("周杰伦---七里香");
        Component child_2 = new Leaf("周杰伦---东风破");
        child.add(child_1);
        child.add(child_2);
        Component child2 = new Composite("曲婉婷");
        Component child2_1 = new Leaf("曲婉婷---我的歌声里");
        Component child2_2 = new Leaf("曲婉婷---Jar Of Love");
        child2.add(child2_1);
        child2.add(child2_2);


        component.add(child);
        component.add(child2);
        component.foreach();
    }

}

abstract class Component {
    String name;
    public Component(String s) {
        this.name = s;
    }

    public abstract void add(Component c);
    public abstract void remove(Component c);
    public abstract void foreach();
}

//组合类
class Composite extends Component {
    private List<Component> child = new ArrayList<Component>();

    public Composite(String s) {
        super(s);
    }

    @Override
    public void add(Component c) {
        child.add(c);
    }

    @Override
    public void foreach() {
        System.out.println("节点名:\t" + name);
        for (Component c : child) {
            c.foreach();
        }
    }

    @Override
    public void remove(Component c) {
        child.remove(c);
    }

}

//不在有根节点
class Leaf extends Component {

    public Leaf(String s) {
        super(s);
    }

    @Override
    public void add(Component c) {
    }

    @Override
    public void foreach() {
        System.out.println("tself name-->" + this.name);
    }

    @Override
    public void remove(Component c) {
    }

}

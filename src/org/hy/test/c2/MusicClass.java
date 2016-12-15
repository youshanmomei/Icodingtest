package org.hy.test.c2;

/**
 * Created by andy on 2016/12/15.
 * 用Java代码实现组合模式
 * ROOT：
 *      |---周杰伦的歌曲有：
 *          |---七里香
 *          |---东风破
 *      |---曲婉婷的歌曲有：
 *          |---我的歌声里
 *          |---Jar Of Love
 *
 * 将歌曲与对应的歌手归类，用组合模式实现这一过程
 * song是歌曲类，ConcreteMusicClass是歌手类，均继承MusicClass，请自行构造这两个类
 */
import java.util.ArrayList;
import java.util.List;

abstract class MusicClass{
    public String name;
    public ArrayList<MusicClass> list;
    public abstract void add(MusicClass component);
    public abstract void remove(MusicClass component);
    public abstract void display();

    public MusicClass(String name) {
        this.name = name;
    }
}
//No.1
//开始写代码，使用组合模式，请构造Song和ConcreteMusicClass类
//歌曲类
class Song extends MusicClass{

    public Song(String name) {
        super(name);
    }

    @Override
    public void add(MusicClass component) {}

    @Override
    public void remove(MusicClass component) {}

    @Override
    public void display() {
        System.out.print("  《" + name+"》");
    }
}

//歌手类
class ConcreteMusicClass extends MusicClass{
    private List<MusicClass> musics = new ArrayList<MusicClass>();

    public ConcreteMusicClass(String name) {
        super(name);
    }

    @Override
    public void add(MusicClass component) {
        musics.add(component);
    }

    @Override
    public void remove(MusicClass component) {
        musics.remove(component);
    }

    @Override
    public void display() {
        System.out.println(name + "的歌曲有：");
        for (MusicClass m : musics) {
            m.display();
        }
        System.out.println();
    }
}


//end_code
class CompositeTest {
    public static void main(String args[]){
        Song song1=new Song("七里香");
        Song song2=new Song("东风破");
        ConcreteMusicClass concreteMusicClassZhou=new ConcreteMusicClass("周杰伦");

        Song song3=new Song("我的歌声里");
        Song song4=new Song("jar of love");
        ConcreteMusicClass concreteMusicClassQu=new ConcreteMusicClass("曲婉婷");

        ConcreteMusicClass root=new ConcreteMusicClass("root");

        //No.2
        //开始写代码，补充完整main函数
        concreteMusicClassZhou.add(song1);
        concreteMusicClassZhou.add(song2);

        concreteMusicClassQu.add(song3);
        concreteMusicClassQu.add(song4);

        root.add(concreteMusicClassZhou);
        root.add(concreteMusicClassQu);
        root.display();

        //end_code
    }
}

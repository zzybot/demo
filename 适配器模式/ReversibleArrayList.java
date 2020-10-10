package chapter11.example.iterable;

import java.util.*;

/**
 * 适配器方法，我希望在先有的迭代器的基础上，增加反向迭代的能力。
 * 也就是说，我需要通过一个方法，产生一个对象，这个对象对Iterator()方法与正常的有着不一样的实现。
 * 并且，我需要保留正常迭代的功能，所以不能简单的重写父类的iterator方法。
 */
public class ReversibleArrayList<T> extends ArrayList<T> {

    public ReversibleArrayList(Collection<? extends T> c) {
        super(c);
    }

    //定义一个方法，该方法可以产生带有反向迭代器的对象
    public Iterable<T> reverse() {
        return new Iterable<T>() {
            @Override
            public Iterator<T> iterator() {
                return new Iterator<T>() {
                    int count = size() - 1;

                    @Override
                    public boolean hasNext() {
                        return count > -1;
                    }

                    @Override
                    public T next() {
                        return get(count--);
                    }

                    @Override
                    public void remove() {
                        throw new UnsupportedOperationException();
                    }
                };
            }
        };
    }

    public static void main(String[] args) {
        ReversibleArrayList<String> list = new ReversibleArrayList<>(
                Arrays.asList("To be or not to be".split(" "))
        );

        for (String str : list
        ) {
            System.out.println(str + " ");
        }
        System.out.println("----------");
        for (String str : list.reverse()
        ) {
            System.out.println(str + " ");
        }
    }
}

//http://ccfit.nsu.ru/~deviv/courses/oop/java_ser_rus.html
//https://javarush.com/tasks/com.javarush.task.task20.task2015#discussion
//package com.javarush.task.task20.task2015;
package Serialize;
import java.io.*;

public class RedefinitionSerialize implements Serializable, Runnable {
    transient private Thread runner;
    private int speed;

    public RedefinitionSerialize(int speed) {
        this.speed = speed;
        runner = new Thread(this);
        runner.start();
    }

    public void run() {
        // do something here, doesn't matter what
        while(true){
            // выполнение анимации
        }

    }

    /**
     * Переопределяем сериализацию.
     * Для этого необходимо объявить методы:
     * private void writeObject(ObjectOutputStream out) throws IOException
     * private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
     * Теперь сериализация/десериализация пойдет по нашему сценарию :)
     */
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        // наш "псевдо-конструктор"
        in.defaultReadObject();
        // теперь мы вновь получили "живой" объект, поэтому давайте перестроим и запустим его
        runner = new Thread(this);
        runner.start();
    }

    public static void main(String[] args) {    }
}

/*
Переопределение сериализации
Сделайте (переопределите метод readObject) так, чтобы после инициализации объекта типа RedefineSerializInStream посредством десериализации нить runner запускалась автоматически.
Ключевые слова объекта runner менять нельзя.

Подсказка: конструктор не вызывается при десериализации, только инициализируются все поля.


Requirements:
1. Класс RedefineSerializInStream должен поддерживать интерфейс Serializable.
2. Класс RedefineSerializInStream должен поддерживать интерфейс Runnable.
3. Поле runner в классе RedefineSerializInStream должно быть объявлено с модификатором transient.
4. В методе readObject должен быть создан новый объект типа Thread с текущим объектом в качестве параметра.
5. В методе readObject должен быть вызван метод start у нового объекта типа Thread.
 */
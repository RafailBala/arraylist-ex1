package org.example;

import java.util.Arrays;

/**
 * Класс, реализующий ArrayList
 *
 * @version 1
 * @autor Рафаил Балаев
 */
public class MyArrayListImpl<T extends Comparable<T>> implements MyArrayList<T> {
    private int size;
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] objects;

    /**
     * Конструктор - создание нового списка с размером массива по умолчанию
     */
    public MyArrayListImpl() {
        objects = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    /**
     * Конструктор - создание нового списка с заданным размером массива
     *
     * @param capacity - размер создаваемого массива
     */
    public MyArrayListImpl(int capacity) {
        objects = new Object[capacity];
        size = 0;
    }

    public void add(T element) {
        ensureCapacity();
        objects[size++] = element;
    }

    public void add(int index, T element) {
        if (index <= size) {
            ensureCapacity();
            System.arraycopy(objects, index, objects, index + 1, size - index);
            objects[index] = element;
            size++;
        } else throw new ArrayIndexOutOfBoundsException("Значение " + index + " должно быть <= " + size);
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " выходит за грань массива = " + size);
        }
        return (T) objects[index];
    }

    public void remove(T element) {
        for (int i = 0; i < size; i++) {
            if (objects[i].equals(element)) {
                System.arraycopy(objects, i + 1, objects, i, size - i - 1);
                objects[size--] = null;
            }
        }
    }

    public void clear() {
        objects = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    /**
     * Метод для увеличения размерности массива в 1,5 раза плюс 1
     */
    private void ensureCapacity() {
        if (size == objects.length) {
            int newCapacity = (int) (objects.length * 1.5 + 1);
            objects = Arrays.copyOf(objects, newCapacity);
        }
    }

    public int getSize() {
        return size;
    }

    public Object[] getObjects() {
        return Arrays.copyOf(objects, size);
    }

    public void sort() {
        if (size > 1)
            quickSort(objects, 0, size - 1);
    }

    /**
     * Метод,реализующий быструю сортировку
     *
     * @param sortArr - сортируемый массив
     * @param low     - нижний индекс массива
     * @param high    - верхний индекс массива
     */
    private void quickSort(Object[] sortArr, int low, int high) {

        if (sortArr.length == 0 || low >= high)
            return;

        if (sortArr[0] instanceof Integer) {
            int middle = low + (high - low) / 2;
            int border = (int) sortArr[middle];

            int i = low, j = high;
            while (i <= j) {
                while ((int) sortArr[i] < border) i++;
                while ((int) sortArr[j] > border) j--;
                if (i <= j) {
                    int swap = (int) sortArr[i];
                    sortArr[i] = sortArr[j];
                    sortArr[j] = swap;
                    i++;
                    j--;
                }
            }
            if (low < j) quickSort(sortArr, low, j);
            if (high > i) quickSort(sortArr, i, high);
        }
        else throw new IllegalArgumentException("Упс!");
    }

    @Override
    public String toString() {
        return Arrays.toString(getObjects());
    }
}


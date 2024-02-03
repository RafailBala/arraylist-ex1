package org.example;

public interface MyArrayList <T>{
    /**
     * Метод добавления нового элемента в конец списка
     * @param element - добавляемый элемент
     */
    void add(T element);
    /**
     * Метод добавления нового элемента в спискок по заданному индексу
     * @param index - индекс для вставки
     * @param element - добавляемый элемент
     * @throws IndexOutOfBoundsException - ошибка, если индекс для вставки невалидное значение
     */
    void add(int index, T element);
    /**
     * Метод получения элемента по индексу
     * @param index - индекс необходимого элемента
     */
    T get(int index);
    /**
     * Метод удаления обьекта
     * @param  element - удаляемый элемент
     */
    void remove(T element);
    /**
     * Метод очистки списка
     */
    void clear();
    /**
     * Метод, который возвражет размер списка
     */
    int getSize();
    /**
     * Метод, который вызывает метод сортировки
     */
    void sort();
}

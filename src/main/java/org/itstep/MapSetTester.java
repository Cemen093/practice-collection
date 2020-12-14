package org.itstep;

import java.util.*;

//оздайте проект MapLab с классом MapSetTester и статическим методом main().
public class MapSetTester {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //В методе main() создайте словарь HashMap с именем networkMap
        //Ключ - имя телеканала (строка), а значение - это множество типа TreeSet,
        // который содержит телевизионные шоу для этого телеканала - тоже строки
        Map<String, TreeSet<String>> networkMap = new HashMap<>();

/*        //Если у вас есть словарь с каналами
        String[] arrStringResourceForNetworkMap = {"FOX", "The Simpsons", "NBC", "ER", "ABC", "20/20", "CBS", "Survivor", "ABC", "Lost", "FOX", "Family Guy", "CBS", "CSI", "FOX", "American Idol", "ABC", "Desperate Housewives", "NBC", "Law And Order"};

        for (int i = 0; i < arrStringResourceForNetworkMap.length; i += 2) {
            boolean IsChannelExist = false;
            for (Map.Entry<String, TreeSet<String>> entry : networkMap.entrySet()) {
                if (entry.getKey().equals(arrStringResourceForNetworkMap[i])) {
                    IsChannelExist = true;
                    entry.getValue().add(arrStringResourceForNetworkMap[i + 1]);
                    break;
                }
            }

            if (!IsChannelExist) {
                TreeSet<String> newTeleShow = new TreeSet<>();
                newTeleShow.add(arrStringResourceForNetworkMap[i + 1]);
                networkMap.put(arrStringResourceForNetworkMap[i], newTeleShow);
            }
        }*/


        //boolean containsKey(Object k): возвращает true, если коллекция содержит ключ k
        //boolean containsValue(Object v): возвращает true, если коллекция содержит значение v
        //Set<Map.Entry<K, V>> entrySet(): возвращает набор элементов коллекции. Все элементы представляют объект Map.Entry
        //boolean isEmpty: возвращает true, если коллекция пуста
        //V putIfAbsent(K k, V v): помещает в коллекцию новый объект с ключом k и значением v, если в коллекции еще нет элемента с подобным ключом.
        //void putAll(Map<? extends K, ? extends V> map): добавляет в коллекцию все объекты из отображения map
        int numberShowAdd;
        do {
            System.out.println("Please enter how many shows you want to add");
            numberShowAdd = Integer.parseInt(scanner.next());

            //Таким образом введите не менее 10 телевизионных шоу.
            if (numberShowAdd < 10){
                System.out.println("The number must be greater than 10");
            }
        } while (numberShowAdd < 10);
        for (int i = 0; i < numberShowAdd; i++) {

            //В цикле запросите у пользователя название телешоу,
            // а затем запросите пользователя ввести имя телевизионного канала для этого шоу
            System.out.print("Input TV network and TV show ");
            String nameChannel = scanner.next();
            String nameTvShow = scanner.next();

            TreeSet<String> newTeleShow = new TreeSet<>();
            newTeleShow.add(nameTvShow);

            //Если канал еще не добавлен в словарь, то создайте множество TreeSet в которое добавьте название телешоу,
            // а затем ключ к паре значений (канал, с заданным телевизионным шоу) в словарь
            if (networkMap.putIfAbsent(nameChannel, newTeleShow) != null) {
                //Если канал находится в словаре, добавьте телешоу к множеству TreeSet этого телеканала.
                networkMap.get(nameChannel).add(nameTvShow);
            }

            //После обновления словаря выведите его содержимое.
            System.out.println(networkMap.toString());
        }

        //Если у вас есть словарь с каналами
        if (!networkMap.isEmpty()){
            //выведите содержимое словаря в алфавитном порядке каналов, по одному каналу в каждой строке.

            //Создайте массив содержащий ключи (названия каналов) словаря networkMap.
            String[] keys = networkMap.keySet().toArray(new String[0]);
            //Отсортируйте полученный массив каналов по алфавиту.
            Arrays.sort(keys);

            //Переберите элементы массива ключей
            for (int i = 0; i < networkMap.size(); i++) {
                //получить соответствующее значение (наборы ТВ-шоу) для каждого ключа из словаря и распечатать их
                System.out.println("TV " + keys[i] + " " + networkMap.get(keys[i]));
            }
        }
    }
}
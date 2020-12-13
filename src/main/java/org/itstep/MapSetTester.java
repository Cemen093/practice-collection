package org.itstep;

import java.util.*;

public class MapSetTester {
    public static void main(String[] args) {

        Map<String, TreeSet<String>> networkMap = new HashMap<>();

        //Если у вас есть словарь с каналами
        String[] arrStringResourceForNetworkMap = {"FOX", "The Simpsons", "NBC", "ER", "ABC", "20/20", "CBS", "Survivor", "ABC", "Lost", "FOX", "Family Guy", "CBS", "CSI", "FOX", "American Idol", "ABC", "Desperate Housewives", "NBC", "Law And Order"};

        System.out.println("Содержимое словаря в алфавитном порядке каналов, по одному каналу в каждой строке.");
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
        }
        //Выведите содержимое словаря в алфавитном порядке каналов, по одному каналу в каждой строке.
        for (Map.Entry<String, TreeSet<String>> entry : networkMap.entrySet()) {
            System.out.println(entry);

        }
        System.out.println();
        //Создайте массив содержащий ключи (названия каналов) словаря `networkMap`.
        String[] arrKeyChannel = new String[networkMap.size()];
        networkMap.keySet().toArray(arrKeyChannel);

        System.out.println("Массив до сортировки");
        for (int i = 0; i < arrKeyChannel.length; i++) {
            System.out.print(arrKeyChannel[i] + ", ");
        }
        System.out.println("\n");
        //Отсортируйте полученный массив каналов по алфавиту.
        //Ну как бы он уже по алфавиту, но ладно
        Arrays.sort(arrKeyChannel);

        System.out.println("Массив после сортировки");
        for (int i = 0; i < arrKeyChannel.length; i++) {
            System.out.print(arrKeyChannel[i] + ", ");
        }
        System.out.println("\n");

        //Переберите элементы массива ключей, что бы получить соответствующее значение (наборы ТВ-шоу) для каждого ключа из словаря и распечатать их.
        System.out.println("Наборы ТВ-шоу");
        for (int i = 0; i < arrKeyChannel.length; i++) {
            System.out.println(networkMap.get(arrKeyChannel[i]));
        }
        System.out.println("\n");

        //**Примечание**: Вам не придется сортировать ТВ-шоу для канала, так как они уже будут отсортированы. Как вы думаете почему?
        //Так уже и не припомню это из лекции, но по моему из-за особеностей хеширования ключа

        networkMap.clear();

        System.out.println("Please enter at least 10 TV shows");
        for (int i = 0; i < 10; i++) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Input tv network: ");
            String nameChannel = scanner.nextLine();

            System.out.print("Input tv show on " + nameChannel + ": ");
            String nameTvShow = scanner.nextLine();


            boolean IsChannelExist = false;
            for (Map.Entry<String, TreeSet<String>> entry : networkMap.entrySet()) {
                if (entry.getKey().equals(nameChannel)) {
                    IsChannelExist = true;
                    entry.getValue().add(nameTvShow);
                    break;
                }
            }

            if (!IsChannelExist) {
                TreeSet<String> newTeleShow = new TreeSet<>();
                newTeleShow.add(nameTvShow);
                networkMap.put(nameChannel, newTeleShow);
            }

            System.out.println(networkMap.toString());
            //(обратите внимание, что сети не расположены в алфавитном порядке, но телевизионные
            //   шоу для каждого канала выводятся по алфавиту. Как вы думаете почему?)
            //У меня и то и то в алфавитном порядке идёт (я так понимаю из-за HashMap) и я не знаю каким методом вывода вы пользовались так что без понятия
            //может добавление компоратора при создании? new TreeSet<>(Comparator.comparing(String::length));
        }
    }
}
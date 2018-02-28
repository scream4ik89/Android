package com.itacademy.homework.homework6.manager;

import com.itacademy.homework.homework6.manager.Download.Downloader;
import com.itacademy.homework.homework6.manager.Parse.AbstractParser;
import com.itacademy.homework.homework6.manager.Parse.ParseFactory;
import com.itacademy.homework.homework6.manager.Search.SearchByCountry;
import com.itacademy.homework.homework6.manager.Search.SearchByDate;
import com.itacademy.homework.homework6.manager.Search.SearchByName;
import com.itacademy.homework.homework6.manager.Search.SearchByPrice;
import com.itacademy.homework.homework6.manager.Sort.SortByCountry;
import com.itacademy.homework.homework6.manager.Sort.SortByName;
import com.itacademy.homework.homework6.manager.Sort.SortByPrice;
import com.itacademy.homework.homework6.manager.Sort.SortByYear;
import model.Exception.NoFile;
import model.Exception.NoObject;
import model.Input;
import model.entity.Pub;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.Collections;

public class Manager  {

    private static Manager instance;
    public final String LINKXML = "http://kiparo.ru/t/pub.xml";
    public final String LINKJSON = "http://kiparo.ru/t/pub.json";
    private File file;
    private  Pub pub;

    //реализация паттерна Singleton
    public void startManager() throws IOException, ParseException {
        PrepareForWork();
        begginingOfWork();
    }
    private Manager(){

    }
    private void PrepareForWork() throws ParseException {
        System.out.println("Добро пожаловать. Выберете нужный пункт: " + "\n" +
                "1)Работа с Xml" + "\n" +
                "2)Работа с Json" + "\n");

        int input = 0;
        input = Input.inputNumber();
        try {
            FunctionalManualPrepareForWork(input);
        } catch (NoFile noFile) {
            System.err.println(noFile.getMessage());
            this.PrepareForWork();
        } catch (NoObject noObject) {
            System.err.println(noObject.getMessage());
            this.PrepareForWork();
        }
    }

    private void FunctionalManualPrepareForWork(int input) throws NoFile, NoObject, ParseException {
        Downloader downloader = null;
        switch (input) {
            case 1:
                downloader = new Downloader(LINKXML);
                break;
            case 2:
                downloader = new Downloader(LINKJSON);
                break;
            default:
                System.err.println("Некорректный ввод, попробуйте снова:");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                this.FunctionalManualPrepareForWork(Input.inputNumber());
                break;
        }
        if (downloader != null){
            Thread thread = new Thread(downloader);
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {

            }
        }
        if(file != null) {
            AbstractParser parser = ParseFactory.getParser(file);
            Thread thread = new Thread(parser);
            thread.start();
        }

    }

    private void begginingOfWork() throws IOException {
        System.out.println("Выберете желаемую операцию : " + "\n" +
                "1)Поиск" + "\n" +
                "2)Сортировка" + "\n" +
                "3)Выход из программыы");
        int input = 0;
        input = Input.inputNumber();
        operationMessage(input);

    }

    private void operationMessage(int input) throws IOException {
        if (input == 1) {
            System.out.println("Добро пожаловать в поисковик: " + "\n" +
                    "1)Поиск по стране" + "\n" +
                    "2)Поиск по дате разлива" + "\n" +
                    "3)Поиск по названию пива" + "\n" +
                    "4)Поиск по цене пива" + "\n");
            input = Input.inputNumber();
            searchBeer(input);

        } else if (input == 2) {
            System.out.println("Добро пожаловать в сортировку: " + "\n" +
                    "1)Сортировка по стране" + "\n" +
                    "2)Сортировка по названию" + "\n" +
                    "3)Сортировка по цене" + "\n" +
                    "4)Сортировка по году разлива");
            input = Input.inputNumber();
            sortBeer(input);

        } else if (input == 3) {
            System.out.println("Программа завершает работу...");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.exit(100);
        } else {
            System.err.println("Некорректный ввод, попробуйте снова:");
            operationMessage(Input.inputNumber());
            return;
        }
        begginingOfWork();
    }
    /*
        вызов метода для сортировки
         */
    private void sortBeer(int input) {

        switch (input) {
            case 1:
                Collections.sort(pub.getGoods(), new SortByCountry());
                System.out.println("Результат сортировки:");
                System.out.println(pub.getGoods().toString());
                break;
            case 2:
                Collections.sort(pub.getGoods(), new SortByName());
                System.out.println("Результат сортировки:");
                System.out.println(pub.getGoods().toString());
                break;
            case 3:
                Collections.sort(pub.getGoods(), new SortByPrice());
                System.out.println("Результат сортировки:");
                System.out.println(pub.getGoods().toString());
                break;
            case 4:
                Collections.sort(pub.getGoods(), new SortByYear());
                System.out.println("Результат сортировки:");
                System.out.println(pub.getGoods().toString());
                break;
            default:
                System.err.println("Некорректный ввод, попробуйте снова:");
                sortBeer(Input.inputNumber());
                break;
        }

    }
    /*
        вызов метода для поиска
         */
    private void searchBeer(int input) throws IOException {
        switch (input) {
            case 1:
                System.out.println("Введите страну для поиска в формате 'DE, CE...");
                SearchByCountry.search(pub.getGoods());
                break;
            case 2:
                System.out.println("Введите дату разлива в формате yyyy-mm-dd");
                SearchByDate.search(pub.getGoods());
                break;
            case 3:
                System.out.println("Введите название пива");
                SearchByName.search(pub.getGoods());
                break;
            case 4:
                System.out.println("Введите цену пива");
                SearchByPrice.search(pub.getGoods());
                break;
            default:
                System.err.println("Некорректный ввод, попробуйте снова:");
                searchBeer(Input.inputNumber());
                break;

        }
    }

    public void setFile(File file) {
        this.file = file;
    }

    public void setPub(Pub pub) {
        this.pub = pub;
    }

    public static Manager getInstance(){
        if(instance == null){
            instance = new Manager();
        }
        return instance;
    }
}

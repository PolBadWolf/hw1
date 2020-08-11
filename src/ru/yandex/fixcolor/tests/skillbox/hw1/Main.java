package ru.yandex.fixcolor.tests.skillbox.hw1;

import com.sun.deploy.util.SyncAccess;

import java.awt.image.BufferedImage;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main
{
    Scanner scanner = null;
    public static void main(String[] args)
    {
        System.out.println("Кофе-машина");
        new Main().start();
    }

    private void start() {
        // init console input
        scanner = new Scanner(System.in);
        //TODO: read from console
        System.out.print("Загрузите деньги в примник Кофе-машины: ");
        int moneyAmount = scanner.nextInt();
        System.out.println("Загружено " + moneyAmount + "рублей");

        // load bd drinks
        DrinkList[] drinks = {
                new DrinkList("капучино", 150),
                new DrinkList("эспрессо", 80),
                new DrinkList("воду", 20),
                new DrinkList("молоко", 50)
        };

        //TODO: реализовать оповещение в случае, если недостаточно средств
        boolean canBuyAnything = false;

        for (DrinkList drink : drinks) {
            if (moneyAmount >= drink.price) {
                System.out.println("Вы можите купить " + drink.name);
                canBuyAnything = true;
            }
        }
        if (!canBuyAnything) {
            System.out.println("У вас недостаточно средств");
        }

        //TODO: 20200810_204507
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
        Date now = new Date();
        System.out.println(dateFormat.format(now));

        //TODO: get screenshot
        BufferedImage image = null;
        System.out.println(image.getWidth() + "x" + image.getHeight());
    }
}
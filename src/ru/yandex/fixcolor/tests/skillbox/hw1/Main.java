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

        int[] drinkPrices = {150, 80, 20, 50};
        String[] drinkNames = {"капучино", "эспрессо", "воду", "молоко"};

        //TODO: реализовать оповещение в случае, если недостаточно средств
        boolean canBuyAnything = false;

        for(int i = 0; i < drinkNames.length; i++)
        {
            if(moneyAmount >= drinkPrices[i]) {
                System.out.println("Вы можете купить " + drinkNames[i]);
            }
        }

        //TODO: 20200810_204507
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date now = new Date();
        System.out.println(dateFormat.format(now));

        //TODO: get screenshot
        BufferedImage image = null;
        System.out.println(image.getWidth() + "x" + image.getHeight());
    }
}
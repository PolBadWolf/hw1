package ru.yandex.fixcolor.tests.skillbox.hw1;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
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
        int countBuy = 0;

        for (DrinkList drink : drinks) {
            if (moneyAmount >= drink.price) {
                countBuy++;
                if (countBuy == 1) {
                    System.out.println("Вы можите купить:");
                }
                System.out.println(countBuy + ") " + drink.name);
            }
        }
        if (countBuy == 0) {
            System.out.println("У вас недостаточно средств");
        }

        //TODO: 20200810_204507
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
        Date now = new Date();
        System.out.println(dateFormat.format(now));

        //TODO: get screenshot
        BufferedImage image = null;
        try {
            image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
            ImageIO.write(image, "png", new File("G:\\DropBox\\Dropbox\\", dateFormat.format(now) + ".png"));
        } catch (AWTException e) {
            System.out.println("Ошибка получения скриншота: " + e.getLocalizedMessage());
        } catch (IOException e) {
            System.out.println("Ошибка сохранения скриншота: " + e.getLocalizedMessage());
        }
        System.out.println(image.getWidth() + "x" + image.getHeight());
    }
}
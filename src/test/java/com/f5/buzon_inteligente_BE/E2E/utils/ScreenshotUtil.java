package com.f5.buzon_inteligente_BE.E2E.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

public class ScreenshotUtil {

    public static void takeScreenshot(WebDriver driver, String fileName) {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
        File destFile = new File("screenshots/" + fileName + ".png");

        try {
            FileUtils.copyFile(srcFile, destFile);
            System.out.println("Captura guardada en: " + destFile.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Error al guardar la captura:");
            e.printStackTrace();
        }
    }
}

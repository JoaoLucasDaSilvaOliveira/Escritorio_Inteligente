package org.escinteligente.escritorio_inteligente.Model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.List;

public class WhatsSender {
    public static void main(String[] args) throws InterruptedException, IOException {
        // Caminho do driver do Chrome
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\jlso9\\Desktop\\chromedriver-win64\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://web.whatsapp.com/");

        System.out.println("Escaneie o QR Code e pressione Enter...");
        System.in.read(); // espera você logar no WhatsApp

        List<String> numeros = null;
        String mensagem = """
                *[Departamento Pessoal - João]* Bom dia, tudo bem?

                Podemos FECHAR a folha *08/2025?*

                Algum lançamento para fazer?
                Falta, atestado, hora extra, etc...""";

        String mensagemEncoded = URLEncoder.encode(mensagem, StandardCharsets.UTF_8);

        for (String numero : numeros) {
            String url = "https://wa.me/" + numero + "?text=" + mensagemEncoded;
            driver.get(url);

            // Espera até 10 segundos para o botão que leva para a segunda página
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement primeiroBotao = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@href, 'web.whatsapp.com/send')]")));
            primeiroBotao.click();

            // Espera até 10 segundos para o botão "Usar WhatsApp Web" aparecer
            // O seletor foi corrigido para o elemento <span> que contém o texto
            WebElement usarWeb = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='usar o WhatsApp Web']")));
            usarWeb.click();

            // Espera um pouco para a página carregar
            Thread.sleep(5000);

            // Envia a mensagem (pressiona Enter no campo de texto)
            WebElement caixaTexto = driver.switchTo().activeElement();
            caixaTexto.sendKeys("\n");

            Thread.sleep(2000);
        }

        driver.quit();
    }
}

        import java.time.Duration;

        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.openqa.selenium.support.ui.ExpectedConditions;
        import org.openqa.selenium.support.ui.WebDriverWait;

public class Demo {

    public static void main(String[] args) throws InterruptedException {
        // TODO Auto-generated method stub

        System.out.println("Hello World");

        // ChromeOptions chromeOption = new ChromeOptions();
        // chromeOption.addArguments("--remote-allow-origins=*");
        // System.setProperty("webdriver.chrome.driver",
        // "C:\\ChromeDriver\\chromedriver.exe");
        // WebDriver driver = new ChromeDriver(chromeOption);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.get("https://www.drf.com/");
        // Thread.sleep(1000);
        System.out.println(driver.getTitle());


        try {
            WebElement overlay = driver.findElement(By.xpath("//div[@id='adOverlay']/div"));
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@id='adOverlay']/div"))));
            WebElement overlayCross = driver.findElement(By.xpath("//div[@id='adOverlay']/div/div[1]"));
            overlayCross.click();

        } catch (Exception e) {
        }

        WebElement selectedWagering = driver.findElement(By.xpath("//div[@class='leftNavFixed']/ul/li[1]"));
        System.out.println(selectedWagering.getText());
        System.out.println(selectedWagering.isEnabled());

        // WebElement selectedPP = driver.findElement(By.id("drfNavMainWrapper"));

        WebElement selectedPP = driver.findElement(By.xpath("//div[@class='leftNavFixed']/ul/li[2]"));
        System.out.println(selectedPP.getText());
        boolean isselectedPP = selectedPP.isEnabled();
        //selectedPP.
        System.out.println("PP is selected: " + isselectedPP);

        // div[@class='d-flex calenderRight']/div//span[@class='dateNo']

        WebElement selectOneDate = driver
                .findElement(By.xpath("//div[@class='d-flex calenderRight']/div//span[@class='dateNo']"));

        selectOneDate.click();

        // WebElement wer = new WebDriverWait(driver, 5).until((WebDriver dr1) ->
        // dr1.findElement(By.id("q")));

        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait1.until(ExpectedConditions
                .visibilityOf(driver.findElement(By.xpath("//*[@class= 'purchaseFlow-Wrapper PF-container']/h2"))));

        // Thread.sleep(5000);
        WebElement getAccesstext = driver.findElement(By.xpath("//*[text()='Get Access to Past Performances']"));

        System.out.println(getAccesstext.getText());

        // *[text()='Get Access to Past Performances']
        // *[@class= 'purchaseFlow-Wrapper PF-container']/h2
        Thread.sleep(3000);
        WebElement buyFormulatedPPs = driver.findElement(By.xpath("//div[@class='chooseSubscription hiddenMobile']/ul/li[3]/button"));
        buyFormulatedPPs.click();

        WebElement register = driver.findElement(By.xpath("//div[@class='purchaseFlow-Wrapper PF-container']/h2"));
        System.out.println(register.getText());


    }
}



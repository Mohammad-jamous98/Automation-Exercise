package Pages;

import java.time.Duration;
import java.util.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {
	WebDriver driver;
	WebDriverWait wait;
	Random rand = new Random();

	public ProductsPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

	public void goToProductsPage() {
		WebElement productsLink = wait
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href='/products']")));
		productsLink.click();
	}

	public void searchAndAddProducts(List<String> brands, List<String> addedProducts) throws InterruptedException {
		for (int i = 0; i < 4 && !brands.isEmpty(); i++) {
			int index = rand.nextInt(brands.size());
			String selectedBrand = brands.remove(index);

			WebElement searchBox = driver.findElement(By.id("search_product"));
			searchBox.clear();
			searchBox.sendKeys(selectedBrand);
			driver.findElement(By.id("submit_search")).click();

			List<WebElement> productBlocks = driver.findElements(By.cssSelector(".productinfo.text-center"));
			if (!productBlocks.isEmpty()) {
				int randomIndex = rand.nextInt(productBlocks.size());
				WebElement selectedBlock = productBlocks.get(randomIndex);

				String productName = selectedBlock.findElement(By.tagName("p")).getText().trim();
				addedProducts.add(productName);
				
				System.out.println("🔍 Adding product: " + productName);


				WebElement addButton = selectedBlock.findElement(By.xpath(".//a[contains(text(),'Add to cart')]"));
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", addButton);
				
				Thread.sleep(500);

				WebElement continueBtn = wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Continue Shopping')]")));
				continueBtn.click();
			}
		}
	}

	public void goToCart() {
		WebElement cartLink = wait
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href='/view_cart']")));
		cartLink.click();
	}

	public List<String> getCartProductNames() {
		List<WebElement> cartItems = driver.findElements(By.cssSelector(".cart_description h4 a"));
		List<String> cartNames = new ArrayList<>();
		for (WebElement item : cartItems) {
			cartNames.add(item.getText().trim());
		}
		return cartNames;
	}
}

package Tests;

import Bases.BaseTest;
import Pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class ProductSearchTest extends BaseTest {

	@Test(priority = 2, enabled = true)
	public void testSearchAndAddToCart() throws InterruptedException {
		ProductsPage productsPage = new ProductsPage(driver);

		productsPage.goToProductsPage();

		List<String> brandOptions = new ArrayList<>(Arrays.asList("Polo","Madame","Kookie Kids", "Mast & Harbour"));
		List<String> addedProducts = new ArrayList<>();

		productsPage.searchAndAddProducts(brandOptions, addedProducts);
		productsPage.goToCart();

		List<String> cartNames = productsPage.getCartProductNames();

		for (String addedProduct : addedProducts) {
			boolean found = cartNames.stream().anyMatch(
					name -> name.replaceAll("\\s+", "").equalsIgnoreCase(addedProduct.replaceAll("\\s+", "")));

			System.out.println(" Product added: " + addedProduct);
			System.out.println(" Cart items: " + cartNames);

			Assert.assertTrue(found, "Product not found in cart: " + addedProduct);
		}
	}
}

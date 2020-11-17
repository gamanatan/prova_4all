package Runs;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import Generics.GenericMethods;
import Generics.Log;
import Pages.Checkout;
import Pages.Home;


public class RunJUnit {
	
	static GenericMethods gem;
	static WebDriver driver;
	static Home home;
	static Checkout checkout;
	static Log log;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("*******************************");
		System.out.println("*          Inicio Teste       *");
		System.out.println("*******************************");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("*******************************");
		System.out.println("*          Fim Teste          *");
		System.out.println("*******************************");
	}

	@Before
	public void setUp() throws Exception {
		gem = new GenericMethods();
		driver = gem.getDriver();
		home = new Home(driver);
		checkout = new Checkout(driver);
		log = new Log();
	}

	@After
	public void tearDown() throws Exception {
		driver.close();
	}
	
	@Test
	public void desafio1() {
		
		String categoria = "Doces";
		ArrayList<String> itens = new ArrayList<String>();
		itens.add("Brigadeiro");
		itens.add("Alfajor de chocolate");
		
		home.getHomePage();
		log.screenshot(driver);
		home.setCategoria(categoria);
		log.screenshot(driver);
		
		for (String item : itens) {
			home.addItem(item);
			log.screenshot(driver);
			Assert.assertEquals(home.getMensagem().toLowerCase(), "o produto '"+item.toLowerCase()+"' foi adicionado ao carrinho");
		}
		
		home.setCategoria("Todos");
		log.screenshot(driver);
		home.getCarrinho();
		
		log.screenshot(driver);
		checkout.removeAddBigadeiro(4);
		log.screenshot(driver);
		Assert.assertEquals(checkout.getQuantidadeBrigadeiro(), 4);
		
		checkout.finalizarPedido();
		log.screenshot(driver);
		Assert.assertEquals(checkout.getMensagem(), "Pedido realizado com sucesso!");
		checkout.fecharMensagem();
		log.screenshot(driver);
	}
	
	@Test
	public void desafio2() throws InterruptedException {
		String categoria_1 = "Bebidas";
		ArrayList<String> itens_categoria_1 = new ArrayList<String>();
		itens_categoria_1.add("Coca-cola lata");
		itens_categoria_1.add("Fanta uva lata");
		itens_categoria_1.add("água mineral sem gás");
	
		String categoria_2 = "Todos";
		ArrayList<String> itens_categoria_2 = new ArrayList<String>();
		itens_categoria_2.add("rissole médio");
		ArrayList<Integer> quantidade_item = new ArrayList<Integer>();
		quantidade_item.add(9);
		quantidade_item.add(6);
		
		double soma = 0;
		
		home.getHomePage();
		log.screenshot(driver);
		home.setCategoria(categoria_1);
		log.screenshot(driver);
		
		for (String item : itens_categoria_1) {
			home.addItem(item);
			log.screenshot(driver);
			Assert.assertEquals(home.getMensagem().toLowerCase(), "o produto '"+item.toLowerCase()+"' foi adicionado ao carrinho");
		}
		
		home.setCategoria(categoria_2);
		log.screenshot(driver);
		for (String item : itens_categoria_2) {
			home.addItem(item);
			log.screenshot(driver);
			Assert.assertEquals(home.getMensagem().toLowerCase(), "o produto '"+item.toLowerCase()+"' foi adicionado ao carrinho");
		}
		
		home.getCarrinho();
		log.screenshot(driver);
		
		for(int quantidade : quantidade_item) {
			log.screenshot(driver);
			checkout.removeAddItem(itens_categoria_2.get(0), quantidade);
			log.screenshot(driver);
			Assert.assertEquals(checkout.getQuantidadeItem(itens_categoria_2.get(0)), quantidade);
		}
		

		log.screenshot(driver);
		itens_categoria_1.addAll(itens_categoria_2);
		for (String item : itens_categoria_1) {
			soma += checkout.getTotalPrecoItem(item);			
		}
		
		Assert.assertEquals(soma, checkout.getSubtotalPreco(), 0);
		Assert.assertEquals(checkout.getTotalPreco(), soma, 0);
		
		checkout.finalizarPedido();
		log.screenshot(driver);
		Assert.assertEquals(checkout.getMensagem().toLowerCase(), "pedido realizado com sucesso!");
		checkout.fecharMensagem();
		log.screenshot(driver);
		
	}

}

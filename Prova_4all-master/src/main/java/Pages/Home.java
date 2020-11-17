package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Generics.GenericMethods;

public class Home extends PageObject {
	
	static GenericMethods gem;
	
	public Home(WebDriver driver) {
		super(driver);
		gem = new GenericMethods(driver);
	}
	
	@FindBy(how = How.ID, using = "cart-products-qtd")
	protected WebElement carrinhoBotao;	

	@FindBy(how = How.ID, using = "open-categories-btn")
	protected WebElement categoriasBotao;

	@FindBy(how = How.ID, using = "category-all")
	protected WebElement categoriaTodos;

	@FindBy(how = How.ID, using = "category-0")
	protected WebElement categoriaBebidas;

	@FindBy(how = How.ID, using = "category-1")
	protected WebElement categoriaDoces;

	@FindBy(how = How.ID, using = "category-2")
	protected WebElement categoriaSalgados;

	@FindBy(how = How.ID, using = "category-3")
	protected WebElement categoriaPratosQuentes;

	@FindBy(how = How.ID, using = "add-product-0-btn")
	protected WebElement addBebidaCoca;

	@FindBy(how = How.ID, using = "add-product-1-btn")
	protected WebElement addBebidaFanta;

	@FindBy(how = How.ID, using = "add-product-2-btn")
	protected WebElement addBebidaAgua;

	@FindBy(how = How.ID, using = "add-product-3-btn")
	protected WebElement addSalgadoRisoles;

	@FindBy(how = How.ID, using = "add-product-4-btn")
	protected WebElement addDoceBrigadeiro;

	@FindBy(how = How.ID, using = "add-product-5-btn")
	protected WebElement addDoceAlfajor;
	
	@FindBy(how = How.XPATH, using = "//div[@class='Toastify__toast-body']")
	protected WebElement mensagem;
	
	
	public void getHomePage() {
		gem.getHomePage("https://shopcart-challenge.4all.com/");
	}
	
	public void getCarrinho(){
		carrinhoBotao.click();
	}
	
	public void setCategoria(String categoria){

		categoriasBotao.click();
		switch (categoria.toLowerCase()) {
			case "todos":
				categoriaTodos.click();
				break;
			case "bebidas":
				categoriaBebidas.click();
				break;
			case "doces":
				categoriaDoces.click();
				break;
			case "salgados":
				categoriaSalgados.click();
				break;
			case "pratos quentes":
				categoriaPratosQuentes.click();
				break;
			default:
				categoriaTodos.click();
				break;
		}
	}

	public String getMensagem() {
		String txt;
		wait.until(ExpectedConditions.visibilityOf(mensagem));
		txt = mensagem.getText();
		mensagem.click();
		return txt;
	}
	
	public void addItem(String item){
		switch (item.toLowerCase()) {
		case "brigadeiro":
			addDoceBrigadeiro.click();
			break;
		case "alfajor de chocolate":
			addDoceAlfajor.click();
			break;
		case "coca-cola lata":
			addBebidaCoca.click();
			break;
		case "fanta uva lata":
			addBebidaFanta.click();
			break;
		case "água mineral sem gás":
			addBebidaAgua.click();
			break;
		case "rissole médio":
			addSalgadoRisoles.click();
			break;
		default:
			break;
		}
	}		
}

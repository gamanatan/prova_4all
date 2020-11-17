package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class Checkout extends PageObject {
	
	public Checkout(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(how = How.ID, using = "finish-checkout-button")
	protected WebElement finalizarCompraBotao;	
	
	@FindBy(how = How.ID, using = "remove-product-4-qtd")
	protected WebElement removeBrigadeiro;	
	
	@FindBy(how = How.ID, using = "add-product-4-qtd")
	protected WebElement addBrigadeiro;	
	
	@FindBy(how = How.ID, using = "product-4-qtd")
	protected WebElement qtdBrigadeiro;
	
	@FindBy(how = How.ID, using = "remove-product-3-qtd")
	protected WebElement removeRissoles;	

	@FindBy(how = How.ID, using = "add-product-3-qtd")
	protected WebElement addRissoles;	


	@FindBy(how = How.ID, using = "product-0-price")
	protected WebElement precoCocaCola;

	@FindBy(how = How.ID, using = "product-0-qtd")
	protected WebElement qtdCocaCola;
	
	@FindBy(how = How.ID, using = "product-1-price")
	protected WebElement precoFantaUva;

	@FindBy(how = How.ID, using = "product-1-qtd")
	protected WebElement qtdFantaUva;
	
	@FindBy(how = How.ID, using = "product-2-price")
	protected WebElement precoAgua;

	@FindBy(how = How.ID, using = "product-2-qtd")
	protected WebElement qtdAgua;
	
	@FindBy(how = How.ID, using = "product-3-price")
	protected WebElement precoRissoles;

	@FindBy(how = How.ID, using = "product-3-qtd")
	protected WebElement qtdRissoles;
	

	@FindBy(how = How.ID, using = "subtotal-price")
	protected WebElement subtotalPreco;
	
	@FindBy(how = How.ID, using = "price-total-checkout")
	protected WebElement totalPreco;
	
	@FindBy(how = How.XPATH, using = "//h2[@class='sc-dNLxif jyncPa']")
	protected WebElement mensagem;	
	
	@FindBy(how = How.XPATH, using = "//button[@class='close-modal sc-jqCOkK ippulb']")
	protected WebElement fecharMensagemBotao;
	
	public void removeAddItem(String item, int quantidade){
		switch (item.toLowerCase()) {
		case "brigadeiro":
			removeAddBigadeiro(quantidade);
			break;
		case "rissole médio":
			removeAddRissoles(quantidade);
			break;
		default:
			break;
		}
	}
	
	public void removeAddBigadeiro(int quantidade){
		while (quantidade > Integer.parseInt(qtdBrigadeiro.getText())) {
			addBrigadeiro.click();
		}
		while (quantidade < Integer.parseInt(qtdBrigadeiro.getText())) {
			removeBrigadeiro.click();
		}
	}

	public void removeAddRissoles(int quantidade){
		while (quantidade > Integer.parseInt(qtdRissoles.getText())) {
			addRissoles.click();
		}
		while (quantidade < Integer.parseInt(qtdRissoles.getText())) {
			removeRissoles.click();
		}
	}
	
	public int getQuantidadeItem(String item){
		switch (item.toLowerCase()) {
		case "brigadeiro":
			return getQuantidadeBrigadeiro();
		case "rissole médio":
			return getQuantidadeRissoles();
		}
		return 0;
	}
	
	public int getQuantidadeBrigadeiro(){
		return Integer.parseInt(qtdBrigadeiro.getText());
	}
	
	public int getQuantidadeCocaCola(){
		return Integer.parseInt(qtdCocaCola.getText());
	}
	
	public int getQuantidadeFantaUva(){
		return Integer.parseInt(qtdFantaUva.getText());
	}
	
	public int getQuantidadeAgua(){
		return Integer.parseInt(qtdAgua.getText());
	}
	
	public int getQuantidadeRissoles(){
		return Integer.parseInt(qtdRissoles.getText());
	}
	
	public double getTotalPrecoItem(String item){
		switch (item.toLowerCase()) {
			case "coca-cola lata":
				return getQuantidadeCocaCola() * getPrecoCocaCola() ;
			case "fanta uva lata":
				return getQuantidadeFantaUva() * getPrecoFantaUva();
			case "água mineral sem gás":
				return getQuantidadeAgua() * getPrecoAgua();
			case "rissole médio":
				return getQuantidadeRissoles() * getPrecoRissoles() ;
			}
		return 0;
	}
	
	public double getPreco(WebElement element) {
		return Double.parseDouble(element.getText().replace("R$ ", "").replace(",", ".") );
	}
	
	public double getPrecoCocaCola(){
		return getPreco(precoCocaCola);
	}
	
	public double getPrecoFantaUva(){
		return getPreco(precoFantaUva);
	}
	
	public double getPrecoAgua(){
		return getPreco(precoAgua);
	}
	
	public double getPrecoRissoles(){
		return getPreco(precoRissoles);
	}
	

	public double getSubtotalPreco(){
		return getPreco(subtotalPreco);
	}

	public double getTotalPreco(){
		return getPreco(totalPreco);
	}

	
	public void finalizarPedido(){
		finalizarCompraBotao.click();
	}
	
	public String getMensagem(){
		wait.until(ExpectedConditions.visibilityOf(mensagem));
		return mensagem.getText();
	}
	
	public void fecharMensagem() {
		fecharMensagemBotao.click();
	}
	
	
}

package poo.loja.imposto;

import poo.loja.modelo.Venda;

public class IPL extends TemplateImposto {
	
	@Override
	protected boolean isTaxaMaxima(Venda venda) {
		return (venda.produtoValorMaior(10000));
	}

	@Override
	protected double taxaMaxima() {
		return 0.25;
	}

	@Override
	protected double taxaNormal() {
		return 0.1;
	}

}

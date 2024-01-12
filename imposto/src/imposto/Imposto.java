package imposto;

import java.util.Locale;
import java.util.Scanner;

public class Imposto {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		double salario, salarioPrestServ, ganhoCap, rendaAnual, rendaAnualPestServ, rendaAnualGanhoCap, gastoMed,
				gastoEdu, impostoSalario = 0, impostoPrestServico = 0, impostoGanhoCap = 0, maximoDedutivel,
				gastosDedutiveis, impostoBruto, abatimento = 0, impostoDevido;

		System.out.println("Informe O Salário: ");
		salario = sc.nextDouble();
		rendaAnual = salario * 12;
		System.out.printf("Renda anual com salário: R$ %.2f%n", rendaAnual);

		System.out.println("Informe o Salário com prestação de serviço:");
		salarioPrestServ = sc.nextDouble();
		rendaAnualPestServ = salarioPrestServ * 12;
		System.out.printf("Renda anual com prestação de Serviço: R$ %.2f%n", rendaAnualPestServ);

		System.out.println("Informe o ganho com capital mensal: ");
		ganhoCap = sc.nextDouble();
		rendaAnualGanhoCap = ganhoCap * 12;
		System.out.printf("Renda anual com ganho de capital: R$ %.2f%n", rendaAnualGanhoCap);

		System.out.println("Informe gastos anul com médicos: ");
		gastoMed = sc.nextDouble();
		System.out.printf("Gastos médicos : R$ %.2f%n", gastoMed);

		System.out.println("Informe gastos anul educacionais: ");
		gastoEdu = sc.nextDouble();
		System.out.printf("Gastos eduacacionais : R$ %.2f%n%n", gastoEdu);

		System.out.println("RELARÓRIO DE IMPOSTO DE RENDA");
		System.out.println();

		System.out.println("CONSOLIDADO DE RENDA:");
		if (salario < 3000.00) {
			System.out.println("Isento");
		} else if (salario >= 3000.00 && salario <= 5000.00) {
			impostoSalario = rendaAnual * 0.1;
			System.out.printf("Imposto sobre salário : R$ %.2f%n", impostoSalario);
		} else {
			impostoSalario = rendaAnual * 0.2;
			System.out.printf("Imposto sobre salário : R$ %.2f%n", impostoSalario);
		}
		;

		if (salarioPrestServ > 0) {
			impostoPrestServico = rendaAnualPestServ * 0.15;
			System.out.printf("Imposto sobre serviços : R$ %.2f%n", impostoPrestServico);
		} else {
			System.out.println("Imposto sobre serviços : R$" + salarioPrestServ);
		}
		;

		if (ganhoCap > 0) {
			impostoGanhoCap = rendaAnualGanhoCap * 0.20;
			System.out.printf("Imposto sobre ganho de capital : R$ %.2f%n", impostoGanhoCap);
		} else {
			System.out.println("Imposto sobre ganho de capital : R$ " + ganhoCap);
		}
		;

		System.out.println();
		System.out.println("DEDUÇÕES:");
		impostoBruto = (impostoSalario + impostoPrestServico + impostoGanhoCap);

		maximoDedutivel = impostoBruto * 0.3;

		if (maximoDedutivel >= impostoBruto * 0.3) {
			System.out.printf("Máximo dedutível : R$ %.2f%n", maximoDedutivel);
		}

		gastosDedutiveis = gastoMed + gastoEdu;

		if (gastosDedutiveis <= impostoBruto * 0.3) {
			System.out.printf("Gastos dedutíveis : R$ %.2f%n", gastosDedutiveis);
		}

		System.out.println("RESUMO");
		System.out.println();

		System.out.printf("Imposto bruto total : R$ %.2f%n", impostoBruto);

		if (maximoDedutivel >= gastosDedutiveis) {
			abatimento = gastosDedutiveis;
			System.out.printf("Abatimento : R$ %.2f%n", abatimento);
		} else {
			abatimento = maximoDedutivel;
			System.out.printf("Abatimento : R$ %.2f%n", abatimento);
		}

//		

		impostoDevido = impostoBruto - abatimento;
		System.out.printf("Imposto Devido: %.2f%n", impostoDevido);

		sc.close();

	}
}
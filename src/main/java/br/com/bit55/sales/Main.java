package br.com.bit55.sales;

import br.com.bit55.sales.service.Report;

import java.io.File;

public class Main {
	public static void main(String[] args) {
		
		File file = new File("/home/u300721/Projetos/sales/src/main/resources/sales_file");
		Report.createReport(file);
	}
}
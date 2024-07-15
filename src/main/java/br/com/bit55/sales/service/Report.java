package br.com.bit55.sales.service;

import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Report {

	private final LocalDate mostSalesDate;
	private final List<LocalDate> biggestSalesDates;
	private final List<Integer> mostSalesClient;
	
	public Report(final LocalDate mostSalesDate, final List<LocalDate> biggestSalesDates, final List<Integer> mostSalesClient) {
		this.mostSalesDate = mostSalesDate;
		this.biggestSalesDates = biggestSalesDates;
		this.mostSalesClient = mostSalesClient;
	}
	
	public static Report createReport(File file) {
		Map<LocalDate, Integer> dailySalesCounts = new HashMap<>();
		Map<LocalDate, Integer> dailyTotalValues = new HashMap<>();
		Map<Integer, Integer> clientSaleCounts = new HashMap<>();
		
		try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
			String line;
			
			while ((line = bufferedReader.readLine()) != null) {
				String[] split = line.split(",");
				
				LocalDate saleDate = LocalDate.parse(split[0], DateTimeFormatter.BASIC_ISO_DATE);
				int clientId = Integer.parseInt(split[1]);
				int saleCount = Integer.parseInt(split[2]);
				int saleValue = Integer.parseInt(split[3]);
				
				dailySalesCounts.put(saleDate, dailySalesCounts.getOrDefault(saleDate, 0) + saleCount);
				dailyTotalValues.put(saleDate, dailyTotalValues.getOrDefault(saleDate, 0) + saleValue);
				clientSaleCounts.put(clientId, clientSaleCounts.getOrDefault(clientId, 0) + saleCount);
			}
			
			LocalDate mostSalesDate = dailySalesCounts.entrySet().stream()
			                                          .max(Map.Entry.comparingByValue())
			                                          .map(Map.Entry::getKey)
			                                          .orElseThrow(() -> new IllegalArgumentException("Sales not found"));
			
			List<LocalDate> biggestSalesDates = dailyTotalValues.entrySet().stream()
			                                                    .sorted(Map.Entry.<LocalDate, Integer>comparingByValue().reversed())
			                                                    .limit(3)
			                                                    .map(Map.Entry::getKey)
			                                                    .collect(Collectors.toList());
			
			List<Integer> mostSalesClients = clientSaleCounts.entrySet().stream()
			                                                 .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
			                                                 .limit(3)
			                                                 .map(Map.Entry::getKey)
			                                                 .collect(Collectors.toList());
			
			System.out.println("mostSalesDate: " + mostSalesDate);
			System.out.println("biggestSalesDates: " + biggestSalesDates);
			System.out.println("mostSalesClients: " + mostSalesClients);
			
			return new Report(mostSalesDate, biggestSalesDates, mostSalesClients);
			
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}

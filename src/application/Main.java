package application;

import entities.Contract;
import entities.Installment;
import services.ContractService;
import services.OnlinePaymentService;
import services.PaypalService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Enter contract data: ");
        System.out.println("Contract number: ");
        int number = sc.nextInt();
        System.out.println("Contract date: ");
        LocalDate date = LocalDate.parse(sc.next(), fmt);
        System.out.println("Contract value: ");
        double totalValue = sc.nextDouble();

        Contract obj = new Contract(number, date, totalValue);

        System.out.print("Enter installment number: ");
        int n = sc.nextInt();

        ContractService contractService = new ContractService(new PaypalService());

        contractService.processContract(obj, n);

        System.out.println("Installments: ");
        for (Installment installment : obj.getInstalments()){
            System.out.println(installment);
        }
    }
}
package com.kodillacourse;

interface Employee{

    double calculateSalary();
}

class FixedAndBonusSalaryEmployee implements Employee{

    private double baseSalary;
    private double bonusRate;
    private boolean additionalSaleDone;

    public FixedAndBonusSalaryEmployee(double baseSalary, double bonusRate, boolean additionalSaleDone){
        this.baseSalary = baseSalary;
        this.bonusRate = bonusRate;
        this.additionalSaleDone = additionalSaleDone;
    }

    public boolean isAdditionalSaleDone() {
        return additionalSaleDone;
    }

    public double calculateSalary() {
        if (isAdditionalSaleDone()) {
            return baseSalary * bonusRate;
        }else{
            return baseSalary;
        }
    }
}

class ContractSalaryEmployee implements Employee{

    private int amountOfProductsDone;
    private double productPay;

    public ContractSalaryEmployee(int amountOfProductsDone, double productPay){
        this.amountOfProductsDone = amountOfProductsDone;
        this.productPay = productPay;
    }

    public double calculateSalary(){
        return amountOfProductsDone * productPay;
    }
}

abstract class SalaryPayout{

    protected abstract void payout();

    public void processPayout(Employee employee){
        System.out.println("Creating payout for: " + employee.calculateSalary());
        payout();
        System.out.println("Payout has been completed!");
    }
}

class SalaryPayoutProcessor extends SalaryPayout{

    protected void payout(){
        System.out.println("Sending money to employee...");
    }
}
class Application {
    public static void main(String[] args){

        SalaryPayout processor = new SalaryPayoutProcessor();

        Employee fixedEmployee = new FixedAndBonusSalaryEmployee(2000, 1.2,true);
        Employee contractEmpleyee = new ContractSalaryEmployee(1000, 2.5);

        processor.processPayout(fixedEmployee);
        processor.processPayout(contractEmpleyee);
    }
}

package Task1;

abstract class defaultATM implements Add, Output{
    private int capacityOfMoney;
    public int getCapacityOfMoney(){          // емкость купюр в банкомате
        return capacityOfMoney;
    }
    public void setCapacityOfMoney(int capacityOfMoney) {
        this.capacityOfMoney = capacityOfMoney;
    }
}

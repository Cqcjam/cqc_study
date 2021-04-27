package com.cqc.learning.designmode.behaviormode.response;

/**
 * @author caoqingcong
 */
public class Client {

    public static void main(String[] args) {

        AbstractHandler drinkHandler = new DrinkHandler();
        AbstractHandler eatHandler = new EatHandler();
        AbstractHandler lastHandler = new LastHandler();
        drinkHandler.setNext(eatHandler);
        eatHandler.setNext(lastHandler);
        drinkHandler.dealRequest("drinkeat");

    }
}

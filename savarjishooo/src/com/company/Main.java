package com.company;

public class Main {

    public static void main(String[] args) {
	SuperMankana superm = new SuperMankana("mercedes ",800," CLK");
        System.out.println(superm);
        superm.name = "BMW ";
        superm.speed =450;
        superm.model=" M3 ";
        System.out.println(superm);


    }
}

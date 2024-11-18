//package com.kenInternational.department_Mservice.controller;
//
//import java.util.Scanner;
//
//public class NewSimple {
//
//    private static final int ROW=4;
//    private static final int COL=4;
//    public static int x=2;
//    public static int y=1;
//    public static void main(String[] args) {
////        Scanner sc=new Scanner(System.in);
////        int row=sc.nextInt();
////        int col=sc.nextInt();
//        int[][] matrix=new int[ROW][COL];
//        traversal(matrix);
//    }
//    public static void traversal(int[][] matrix){
//        int count=1;
//        while (count <= ROW * COL){
//            if(matrix[x][y] == 0){
//                matrix[x][y]=count;
//                count+=1;
//                up();
//                System.out.println("inside while if");
//            }else {
//                down();
//                System.out.println("inside while else");
//            }
//
//        }
//        for (int i=0;i<ROW ;i++){
//            for (int j=0;j<COL;j++){
//                System.out.print(matrix[i][j]+"\t");
//            }
//            System.out.println();
//        }
//    }
//    public static void up(){
//        if (x>0){
//            x-=1;
//        }else {
//            left();
//        }
//
//    }
//    public static void down(){
//        if (x<ROW-1){
//            x+=1;
//        }else {
//            right();
//        }
//
//    }
//    public static void left(){
//        if (y>0){
//            y-=1;
//        }else {
//            down();
//        }
//    }
//    public static void right(){
//        if (y<COL-1){
//            y+=1;
//        }else {
//            up();
//        }
//    }
//}

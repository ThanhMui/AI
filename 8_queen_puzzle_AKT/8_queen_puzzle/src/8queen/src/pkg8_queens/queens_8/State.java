/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg8_queens.queens_8;

import java.util.ArrayList;

/**
 *
 * @author Do Thi Thanh Mui
 */
 public class State {
        public int G;
        int n=8;
        public int H;
        public int i = 0;
        public State topState;
        public ArrayList<row> rows;

        public State(ArrayList<row> rows) {
            this.rows = rows;
        }

        public ArrayList<Integer> mvToRowGoto() {
            int currentRow = rows.size() - 1;
            ArrayList<Integer> toMoveCols = new ArrayList<>();
            if (currentRow >= 0) {
                for (int j = rows.get(currentRow).col + 2; j <= n; j++) {
                    int i = currentRow - 1;
                    for (int temp = 2; i >= 0; i--, temp++) {
                        if (rows.get(i).col == j) break;
                        if (rows.get(i).col == j - temp) break;
                        if (rows.get(i).col == j + temp) break;
                    }
                    if (i < 0) toMoveCols.add(j);
                }

                for (int j = rows.get(currentRow).col - 2; j > 0; j--) {
                    int i = currentRow - 1;
                    for (int temp = 2; i >= 0; i--, temp++) {
                        if (rows.get(i).col == j) break;
                        if (rows.get(i).col == j - temp) break;
                        if (rows.get(i).col == j + temp) break;
                    }
                    if (i < 0) toMoveCols.add(j);
                }
                if (toMoveCols.size() == 0) toMoveCols = null;
            } else for (int j = 1; j <= n; j++) toMoveCols.add(j);
            return toMoveCols;
        }

        public void show() {
            System.out.println("Trạng thái S" + i + ":");
            int j = 0;
            for (; j < rows.size(); j++) {
                int column = rows.get(j).col;
                for (int c = 0; c < n; c++) {
                    if (c + 1 == column) System.out.print("*\t");
                    else System.out.print("-\t");
                }
                System.out.print("\n");
            }
            for (; j < n; j++) {
                for (int c = 0; c < n; c++) System.out.print("-\t");
                System.out.print("\n");
            }
            System.out.println("g: " + this.G);
            System.out.println("h: " + this.H);
            System.out.println("f: " + (this.G + this.H));
        }
    }

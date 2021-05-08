/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AStar_HanoiTower;

import java.util.ArrayList;

/**
 *
 * @author Do Thi Thanh Mui
 */
  public class State implements Comparable {
        public int G;
        public int H;
        public int i = 0;
       public int n=3;
        public State top;
        public ArrayList<cot> columns;
       
        
        
        
        public State(ArrayList columns) {
            this.columns = new ArrayList<>(columns);
        }

        public State() {
            this.columns = new ArrayList<>();
        }

        public ArrayList<cot> getColumns() {
            return columns;
        }

        public void setColumns(ArrayList<cot> columns) {
            this.columns = columns;
        }

        public void print() {
            System.out.println("Trạng thái S" + i + ":");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < cot.__MAX; j++) {
                    ArrayList<SLDia> disks = this.columns.get(j).disks;
                    if (disks.size() > n - i - 1) {
                        int size = disks.get(n - i - 1).count;
                        if (size < n) {
                            for (int l = 0; l < n - size; l++) System.out.print(" ");
                        }
                        for (int k = 0; k < size; k++) {
                            System.out.print("-");
                        }
                        System.out.print("|");
                        for (int k = 0; k < size; k++) {
                            System.out.print("-");
                        }
                        if (size < n) {
                            for (int l = 0; l < n - size; l++) System.out.print(" ");
                        }
                        System.out.print("\t");
                    } else {
                        for (int l = 0; l < n; l++) System.out.print(" ");
                        System.out.print("|");
                        for (int l = 0; l < n; l++) System.out.print(" ");
                        System.out.print("\t");
                    }
                }
                System.out.print("\n");
            }
            System.out.println("G: " + this.G);
            System.out.println("H: " + this.H);
            System.out.println("F: " + (this.G + this.H));
        }

        public boolean col1_3() {
            cot column1 = this.columns.get(0);
            cot column3 = this.columns.get(2);
            ArrayList<SLDia> disks1 = column1.disks;
            ArrayList<SLDia> disks3 = column3.disks;
            if (disks1.size() > 0)
                if (disks3.size() == 0 || disks3.get(disks3.size() - 1).count > disks1.get(disks1.size() - 1).count)
                    return true;
            return false;
        }

        public boolean col1_2() {
           cot column1 = this.columns.get(0);
           cot column2 = this.columns.get(1);
            ArrayList<SLDia> disks1 = column1.disks;
            ArrayList<SLDia> disks2 = column2.disks;
            if (disks1.size() > 0)
                if (disks2.size() == 0 || disks2.get(disks2.size() - 1).count > disks1.get(disks1.size() - 1).count)
                    return true;
            return false;
        }

        public boolean col2_3() {
            cot column2 = this.columns.get(1);
            cot column3 = this.columns.get(2);
            ArrayList<SLDia> disks2 = column2.disks;
            ArrayList<SLDia> disks3 = column3.disks;
            if (disks2.size() > 0)
                if (disks3.size() == 0 || disks3.get(disks3.size() - 1).count > disks2.get(disks2.size() - 1).count)
                    return true;
            return false;
        }

        public boolean col3_1() {
            cot column3 = this.columns.get(2);
           cot column1 = this.columns.get(0);
            ArrayList<SLDia> disks3 = column3.disks;
            ArrayList<SLDia> disks1 = column1.disks;
            if (disks3.size() > 0)
                if (disks1.size() == 0 || disks1.get(disks1.size() - 1).count > disks3.get(disks3.size() - 1).count)
                    return true;
            return false;
        }

        public boolean col3_2() {
          cot column3 = this.columns.get(2);
           cot column2 = this.columns.get(1);
            ArrayList<SLDia> disks3 = column3.disks;
            ArrayList<SLDia> disks2 = column2.disks;
            if (disks3.size() > 0)
                if (disks2.size() == 0 || disks2.get(disks2.size() - 1).count > disks3.get(disks3.size() - 1).count)
                    return true;
            return false;
        }

        public boolean col2_1() {
           cot  column2 = this.columns.get(1);
            cot column1 = this.columns.get(0);
            ArrayList<SLDia> disks2 = column2.disks;
            ArrayList<SLDia> disks1 = column1.disks;
            if (disks2.size() > 0)
                if (disks1.size() == 0 || disks1.get(disks1.size() - 1).count > disks2.get(disks2.size() - 1).count)
                    return true;
            return false;
        }

        public boolean isEqual(State S) {
            for (int i = 0; i < cot.__MAX; i++) {
                ArrayList<SLDia> Sdisks = S.columns.get(i).disks;
                ArrayList<SLDia> disks = this.columns.get(i).disks;
                if (Sdisks.size() == disks.size()) {
                    for (int j = 0; j < Sdisks.size(); j++) {
                        if (Sdisks.get(j).count != disks.get(j).count)
                            return false;
                    }
                } else return false;
            }
            return true;
        }

        @Override
        public int compareTo(Object o) {
            return (this.G + this.H) - (((State) o).G + ((State) o).H);
        }
    }


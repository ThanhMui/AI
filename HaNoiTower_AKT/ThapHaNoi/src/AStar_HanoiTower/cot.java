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
public class cot {
     
        public ArrayList<SLDia> disks;
        public static int __MAX = 3;

        public cot() {
            disks = new ArrayList<>();
        }

        public ArrayList<SLDia> getDisks() {
            return disks;
        }

        public void setDisks(ArrayList<SLDia> disks) {
            this.disks = disks;
        }

        public cot(ArrayList<SLDia> disks) {
            this.disks = new ArrayList<>(disks);
        
    }
}

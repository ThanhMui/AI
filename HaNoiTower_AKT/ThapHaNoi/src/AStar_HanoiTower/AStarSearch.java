/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AStar_HanoiTower;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Do Thi Thanh Mui
 */
public class AStarSearch {
    public ArrayList<State> ListOpens;
    public ArrayList<State> ListCloses;
    public int count = 0; 
    public int n; 
    public int i = 1; 

    public AStarSearch(int n) {
        this.ListOpens = new ArrayList();
        this.ListCloses = new ArrayList();
        this.n = n;
    }

    public void H(State state) {
        ArrayList<SLDia> disks = state.getColumns().get(2).disks;
        int h;
        if (disks.size() == 0) h = n;
        else if (disks.get(0).count == n) h = n - disks.size();
        else if (disks.get(0).count == 1) h = n + 1;
        else h = n + disks.get(0).count;
        state.H = h;
    }

    public void generateG(State state) {
        state.G = state.top.G + 1;
    }

    public void addToOpen(State state) {
        if (state.col1_2()) {
            move(state, 0, 1);
        }
        if (state.col1_3()) {
            move(state, 0, 2);
        }
        if (state.col2_3()) {
            move(state, 1, 2);
        }
        if (state.col2_1()) {
            move(state, 1, 0);
        }
        if (state.col3_1()) {
            move(state, 2, 0);
        }
        if (state.col3_2()) {
            move(state, 2, 1);
        }
        System.out.print("OPEN: ");
        for (State S : ListOpens) {
            if (S.i < ListOpens.get(ListOpens.size() - 1).i) System.out.print("S" + S.i + ", ");
            else System.out.println("S" + S.i);
        }
    }

    public void move(State state, int indexS, int indexD) {
        State s = new State();
        s.top = state;
        ArrayList<cot> columns = new ArrayList<>();
        for (int i = 0; i < state.getColumns().size(); i++) {
            ArrayList<SLDia> disks = new ArrayList<>();
            for (int j = 0; j < state.getColumns().get(i).disks.size(); j++) {
                SLDia disk = new SLDia(state.getColumns().get(i).disks.get(j).count);
                disks.add(disk);
            }
            cot column = new cot(disks);
            columns.add(column);
        }
        s.setColumns(columns);
        ArrayList<SLDia> source = s.getColumns().get(indexS).getDisks();
        SLDia diskToMove = source.remove(source.size() - 1);
        s.getColumns().get(indexD).getDisks().add(diskToMove);
        s.i = ++count;
       H(s);
        generateG(s);
        for (int i = 0; i < ListCloses.size(); i++)
            if (ListCloses.get(i).isEqual(s)) {
                return;
            }
        ListOpens.add(s);
        s.print();
        System.out.println("Thêm S" + s.i + " vào OPEN");
    }

    public State startState() {
        ArrayList<cot> columns = new ArrayList<>();
        ArrayList<SLDia> disks = new ArrayList<>();
        int i = n;
        for (int j = 0; j < n; j++) {
            disks.add(new SLDia(i--));
        }
        columns.add(new cot(disks));
        columns.add(new cot());
        columns.add(new cot());
        State S0 = new State(columns);
        S0.G = 0;
        H(S0);
        return S0;
    }

    public State finalState() {
        
        ArrayList<SLDia> disk = new ArrayList<>();
        ArrayList<cot> col = new ArrayList<>();
        int i = n;
        for (int j = 0; j < n; j++) {
            disk.add(new SLDia(i--));
        }
        col.add(new cot());
        col.add(new cot());
        col.add(new cot(disk));
        State SN = new State(col);
        return SN;
    }

    public void Search() {
        ListOpens.add(startState());
        System.out.println(" Khởi tạo tập OPEN và CLOSE");
        System.out.println("OPEN={}");
        System.out.println("CLOSE={}");
        System.out.println("Thêm S" + ListOpens.get(0).i + " vào OPEN");
        ListOpens.get(0).print();
        while (ListOpens.size() > 0) {
            Collections.sort(ListOpens);
          
            System.out.println(" S" + ListOpens.get(0).i + " move to state S " + ListOpens.get(0).i);
            if (ListOpens.get(0).isEqual(finalState())) {
                System.out.println("Lấy S" + ListOpens.get(0).i + " ra khỏi OPEN");
                ListOpens.get(0).print();
                System.out.println("Trạng thái ĐÍCH LÀ S: " + ListOpens.get(0).i);
                ArrayList<State> Result = new ArrayList<>();
                State state = ListOpens.get(0);
                while (true) {
                    Result.add(state);
                    if (state.top != null) state = state.top;
                    else break;
                }
                for (int i = Result.size() - 1; i >= 0; i--) Result.get(i).print();
                return;
            }
            ListCloses.add(ListOpens.get(0));
            System.out.println("Lấy S" + ListOpens.get(0).i + " ra khỏi OPEN");
            ListOpens.remove(0).print();
            System.out.println("S" + ListCloses.get(ListCloses.size() - 1).i + " move to state: ");
            addToOpen(ListCloses.get(ListCloses.size() - 1));
            System.out.println("Thêm S" + ListCloses.get(ListCloses.size() - 1).i + " vào CLOSE");
            System.out.print("CLOSE: ");
            for (State S : ListCloses) {
                if (S.i < ListCloses.get(ListCloses.size() - 1).i) System.out.print("S" + S.i + ", ");
                else System.out.println("S" + S.i);
            }
            System.out.print("\n");
        }
        System.out.println("Not found!");
    }




}

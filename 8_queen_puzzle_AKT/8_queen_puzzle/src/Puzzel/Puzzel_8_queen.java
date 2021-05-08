package Puzzel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

import pkg8_queens.queens_8.State;
import pkg8_queens.queens_8.row;

public class Puzzel_8_queen {
    public int sl = 0;
    public int size = 8;
    public ArrayList<State> Listopen;
    public int i = 1;
    public ArrayList<State> ListClose;

    public Puzzel_8_queen() {
        this.Listopen = new ArrayList();
        this.ListClose = new ArrayList();
    }

    Comparator<State> comparator = new Comparator<State>() {
        @Override
        public int compare(State o1, State o2) {
            return (o1.G + o1.H) - (o2.G + o2.H);
        }
    };

    public void createH(State state) {
        if (state.rows.size() == 0) state.H = size * size;
        else {
            ArrayList<row> Rows = state.rows;
            int horizontal = 0;
            int current = state.rows.size() - 1;
            int cols = Rows.get(current).col;
            int left = size - current - 1;
            int right = cols - 1;
            if (cols > current) left = size - cols;
            if (cols + current > size - 1) right = size - current - 1;
            int chieuNgang = size - current - 1;
            for (int j = 1; j <= size; j++) {
                int i = current - 1;
                for (int temp = 1; i >= 0; i--, temp++) {
                    if (Rows.get(i).col == j) break;
                    if (Rows.get(i).col == j - temp) break;
                    if (Rows.get(i).col == j + temp) break;
                }
                if (i < 0) horizontal++;
            }
            for (int i = 0; i < current; i++) {
                if (checkC(current + 1, Rows.get(current).col, i + 1, Rows.get(i).col)) chieuNgang--;
            }
            for (int i = current + 2, j = cols + 1; i <= size && j <= size; i++, j++) {
                int t = 0;
                for (; t < current; t++) {
                    if (checkD(t + 1, Rows.get(t).col, true, j, i)) break;
                    if (checkV(Rows.get(t).col, j)) break;
                }
                if (t < current) left--;
            }
            for (int i = current + 2, j = cols - 1; i <= size && j > 0; i++, j--) {
                int t = 0;
                for (; t < current; t++) {
                    if (checkD(t + 1, Rows.get(t).col, false, j, i)) break;
                    if (checkV(Rows.get(t).col, j)) break;
                }
                if (t < current) right--;
            }
            state.H = --horizontal + chieuNgang + left + right;
        }
    }


    public boolean checkC(int row, int col, int row1, int col1) {
        int yL = col + row1 - col1;
        int yR = -col + row1 + col1;
        if (row < yL && yL <= size) return true;
        if (row < yR && yR <= size) return true;
        return false;
    }

    public State initState() {
        State state = new State(new ArrayList<row>());
        state.G = 0;
        createH(state);
        return state;
    }

    public boolean checkD(int row1, int col1, boolean isLeft1, int x, int y) {
        if (isLeft1) {
            return (y == -x + row1 + col1);
        } else {
            return (y == x + (row1 - col1));
        }
    }

    public void createG(State state) {
        state.G = state.topState.G + 1;
    }

    public boolean checkV(int col, int x) {
        return (col == x);
    }

    public void AddStateOpenNew_mv(State state) {
        ArrayList<Integer> moveCol = state.mvToRowGoto();
        if (moveCol != null) {
            System.out.println("Từ S" + ListClose.get(ListClose.size() - 1).i + " chuyển sang: ");
            for (int i : moveCol) {
                move_to(state, i);
            }
            System.out.print("OPEN: ");
            for (State S : Listopen) {
                if (S.i < Listopen.get(Listopen.size() - 1).i) System.out.print("S" + S.i + ", ");
                else System.out.println("S" + S.i);
            }
        } else
            System.out.println("S" + ListClose.get(ListClose.size() - 1).i + " không có trạng thái nào.");
    }

    public void move_to(State state, int col) {
        ArrayList<row> newRows = new ArrayList<>();
        for (row row : state.rows) {
            newRows.add(row);
        }
        State N = new State(newRows);
        N.rows.add(new row(col));
        N.topState = state;
        N.i = ++sl;
        createH(N);
        createG(N);
        Listopen.add(N);
        N.show();
        System.out.println("Thêm S" + N.i + " vào OPEN");
    }

    public void TimKiemAKT() {
        Listopen.add(initState());
        System.out.println("Bước " + i++ + ": Khởi tạo  OPEN và CLOSE");
        System.out.println("OPEN={}");
        System.out.println("CLOSE={}");
        System.out.println("Thêm S" + Listopen.get(0).i + " vào OPEN");
        Listopen.get(0).show();
        while (Listopen.size() > 0) {
            Collections.sort(Listopen, comparator);
            System.out.print("Bước " + i++ + ":\t");
            if (Listopen.get(0).rows.size() == size) {
                System.out.println("Lấy S" + Listopen.get(0).i + " ra khỏi OPEN");
                Listopen.get(0).show();
                System.out.println("Trạng thái đích là S:" + Listopen.get(0).i + " .");
                ArrayList<State> kq = new ArrayList<>();
                State state = Listopen.get(0);
                while (state.topState != null) {
                    kq.add(state);
                    state = state.topState;
                }
                kq.add(state);
                Collections.reverse(kq);
                for (State state1 : kq) {
                    state1.show();
                }
                return;
            }

            ListClose.add(Listopen.get(0));
            System.out.println("Lấy S" + Listopen.get(0).i + " ra khỏi OPEN");
            Listopen.remove(0).show();
            AddStateOpenNew_mv(ListClose.get(ListClose.size() - 1));
            System.out.println("Thêm S" + ListClose.get(ListClose.size() - 1).i + " vào tập CLOSED");
            System.out.print("CLOSED: ");
            for (State S : ListClose) {
                if (S.i < ListClose.get(ListClose.size() - 1).i) System.out.print("S" + S.i + ", ");
                else System.out.println("S" + S.i);
            }
            System.out.print("\n");
        }
        System.out.println("Not found!");
    }


}

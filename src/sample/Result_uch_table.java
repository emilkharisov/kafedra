package sample;

import javafx.beans.property.SimpleStringProperty;

public class Result_uch_table {
    private int show_result_nomer;
    private String show_result_nazvanie;
    private String show_result_avtoru;
    private String show_result_str;
    private String show_result_tip;
    private String show_result_god;
    private String show_result_izdatel;

    public Result_uch_table(int show_result_nomer, String show_result_nazvanie, String show_result_avtoru, String show_result_str, String show_result_tip, String show_result_god, String show_result_izdatel) {
        this.show_result_nomer = show_result_nomer;
        this.show_result_nazvanie = show_result_nazvanie;
        this.show_result_avtoru = show_result_avtoru;
        this.show_result_str = show_result_str;
        this.show_result_tip = show_result_tip;
        this.show_result_god = show_result_god;
        this.show_result_izdatel = show_result_izdatel;
    }

    public int getShow_result_nomer() {
        return show_result_nomer;
    }

    public void setShow_result_nomer(int show_result_nomer) {
        this.show_result_nomer = show_result_nomer;
    }

    public String getShow_result_nazvanie() {
        return show_result_nazvanie;
    }

    public void setShow_result_nazvanie(String show_result_nazvanie) {
        this.show_result_nazvanie = show_result_nazvanie;
    }

    public String getShow_result_avtoru() {
        return show_result_avtoru;
    }

    public void setShow_result_avtoru(String show_result_avtoru) {
        this.show_result_avtoru = show_result_avtoru;
    }

    public String getShow_result_str() {
        return show_result_str;
    }

    public void setShow_result_str(String show_result_str) {
        this.show_result_str = show_result_str;
    }

    public String getShow_result_tip() {
        return show_result_tip;
    }

    public void setShow_result_tip(String show_result_tip) {
        this.show_result_tip = show_result_tip;
    }

    public String getShow_result_god() {
        return show_result_god;
    }

    public void setShow_result_god(String show_result_god) {
        this.show_result_god = show_result_god;
    }

    public String getShow_result_izdatel() {
        return show_result_izdatel;
    }

    public void setShow_result_izdatel(String show_result_izdatel) {
        this.show_result_izdatel = show_result_izdatel;
    }
}

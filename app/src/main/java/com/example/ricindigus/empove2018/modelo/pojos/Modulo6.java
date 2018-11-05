package com.example.ricindigus.empove2018.modelo.pojos;

import android.content.ContentValues;

import com.example.ricindigus.empove2018.modelo.SQLConstantes;

public class Modulo6 {
    private String _id;
    private String idInformante;
    private String idHogar;
    private String idVivienda;
    private String c6_p601;
    private String c6_p602;
    private String c6_p603;
    private String c6_p604_1;
    private String c6_p604_2;
    private String c6_p604_3;
    private String c6_p604_4;
    private String c6_p604_5;
    private String c6_p604_6;
    private String c6_p604_7;
    private String c6_p604_8;
    private String c6_p604_9;
    private String c6_p604_10;
    private String c6_p604_11;
    private String c6_p604_o;
    private String c6_p605;
    private String c6_p606;
    private String c6_p607;
    private String c6_p608;
    private String c6_p608_o;
    private String c6_p609;
    private String c6_p610_pd;
    private String c6_p610_pl;
    private String c6_p610_pm;
    private String c6_p610_pmi;
    private String c6_p610_pj;
    private String c6_p610_pv;
    private String c6_p610_ps;
    private String c6_p610_pt;
    private String c6_p610_sd;
    private String c6_p610_sl;
    private String c6_p610_sm;
    private String c6_p610_smi;
    private String c6_p610_sj;
    private String c6_p610_sv;
    private String c6_p610_ss;
    private String c6_p610_st;
    private String c6_p610_t;
    private String c6_p611;
    private String c6_p612;
    private String c6_p612_nro;
    private String c6_p613;
    private String c6_p614_mon;
    private String c6_p614_esp;
    private String c6_p615_mon;
    private String c6_p615_esp;
    private String c6_p616_mon;
    private String c6_p616_esp;
    private String c6_p616_nas;
    private String c6_p617;
    private String c6_p617_dist;
    private String c6_p617_prov;
    private String c6_p617_dep;
    private String c6_p625_1;
    private String c6_p625_2;
    private String c6_p625_3;
    private String c6_p625_4;
    private String c6_p625_5;
    private String c6_p625_6;
    private String c6_p625_o;
    private String c6_p618;
    private String c6_p619_1;
    private String c6_p619_2;
    private String c6_p619_3;
    private String c6_p619_4;
    private String c6_p619_5;
    private String c6_p619_6;
    private String c6_p619_7;
    private String c6_p619_8;
    private String c6_p619_9;
    private String c6_p619_o;
    private String c6_p620;
    private String c6_p621;
    private String c6_p622;
    private String c6_p622_o;
    private String c6_p623;
    private String c6_p623_o;
    private String c6_p624;
    private String c6_p626;
    private String c6_p627;
    private String c6_p628;
    private String c6_p629_1;
    private String c6_p629_2;
    private String c6_p629_3;
    private String c6_p629_4;
    private String c6_p629_o;
    private String c6_p629_1_f;
    private String c6_p629_1_m;
    private String c6_p629_2_f;
    private String c6_p629_2_m;
    private String c6_p629_3_f;
    private String c6_p629_3_m;
    private String c6_p629_4_f;
    private String c6_p629_4_m;
    private String c6_p630_1;
    private String c6_p630_1med;
    private String c6_p630_1o;
    private String c6_p630_1frec;
    private String c6_p630_1mont;
    private String c6_p630_2;
    private String c6_p630_2med;
    private String c6_p630_2o;
    private String c6_p630_2mont;
    private String c6_p630_2frec;
    private String obs_cap6;
    private String c6_estado;

    public Modulo6(String _id, String idHogar, String idVivienda) {
        this._id = _id;
        this.idHogar = idHogar;
        this.idVivienda = idVivienda;
        idInformante= "";
        c6_p601= "";
        c6_p602= "";
        c6_p603= "";
        c6_p604_1= "";
        c6_p604_2= "";
        c6_p604_3= "";
        c6_p604_4= "";
        c6_p604_5= "";
        c6_p604_6= "";
        c6_p604_7= "";
        c6_p604_8= "";
        c6_p604_9= "";
        c6_p604_10= "";
        c6_p604_11= "";
        c6_p604_o= "";
        c6_p605= "";
        c6_p606= "";
        c6_p607= "";
        c6_p608= "";
        c6_p608_o= "";
        c6_p609= "";
        c6_p610_pd= "";
        c6_p610_pl= "";
        c6_p610_pm= "";
        c6_p610_pmi= "";
        c6_p610_pj= "";
        c6_p610_pv= "";
        c6_p610_ps= "";
        c6_p610_pt= "";
        c6_p610_sd= "";
        c6_p610_sl= "";
        c6_p610_sm= "";
        c6_p610_smi= "";
        c6_p610_sj= "";
        c6_p610_sv= "";
        c6_p610_ss= "";
        c6_p610_st= "";
        c6_p610_t= "";
        c6_p611= "";
        c6_p612= "";
        c6_p612_nro= "";
        c6_p613= "";
        c6_p614_mon= "";
        c6_p614_esp= "";
        c6_p615_mon= "";
        c6_p615_esp= "";
        c6_p616_mon= "";
        c6_p616_esp= "";
        c6_p616_nas= "";
        c6_p617= "";
        c6_p617_dist= "";
        c6_p617_prov= "";
        c6_p617_dep= "";
        c6_p625_1= "";
        c6_p625_2= "";
        c6_p625_3= "";
        c6_p625_4= "";
        c6_p625_5= "";
        c6_p625_6= "";
        c6_p625_o= "";
        c6_p618= "";
        c6_p619_1= "";
        c6_p619_2= "";
        c6_p619_3= "";
        c6_p619_4= "";
        c6_p619_5= "";
        c6_p619_6= "";
        c6_p619_7= "";
        c6_p619_8= "";
        c6_p619_9= "";
        c6_p619_o= "";
        c6_p620= "";
        c6_p621= "";
        c6_p622= "";
        c6_p622_o= "";
        c6_p623= "";
        c6_p623_o= "";
        c6_p624= "";
        c6_p626= "";
        c6_p627= "";
        c6_p628= "";
        c6_p629_1= "";
        c6_p629_2= "";
        c6_p629_3= "";
        c6_p629_4= "";
        c6_p629_o= "";
        c6_p629_1_f= "";
        c6_p629_1_m= "";
        c6_p629_2_f= "";
        c6_p629_2_m= "";
        c6_p629_3_f= "";
        c6_p629_3_m= "";
        c6_p629_4_f= "";
        c6_p629_4_m= "";
        c6_p630_1= "";
        c6_p630_1med= "";
        c6_p630_1o= "";
        c6_p630_1frec= "";
        c6_p630_1mont= "";
        c6_p630_2= "";
        c6_p630_2med= "";
        c6_p630_2o= "";
        c6_p630_2mont= "";
        c6_p630_2frec= "";
        obs_cap6= "";
        c6_estado= "";
    }

    public Modulo6() {
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getC6_p630_2frec() {
        return c6_p630_2frec;
    }

    public void setC6_p630_2frec(String c6_p630_2frec) {
        this.c6_p630_2frec = c6_p630_2frec;
    }

    public String getIdInformante() {
        return idInformante;
    }

    public void setIdInformante(String idInformante) {
        this.idInformante = idInformante;
    }

    public String getIdHogar() {
        return idHogar;
    }

    public void setIdHogar(String idHogar) {
        this.idHogar = idHogar;
    }

    public String getIdVivienda() {
        return idVivienda;
    }

    public void setIdVivienda(String idVivienda) {
        this.idVivienda = idVivienda;
    }

    public String getC6_p601() {
        return c6_p601;
    }

    public void setC6_p601(String c6_p601) {
        this.c6_p601 = c6_p601;
    }

    public String getC6_p602() {
        return c6_p602;
    }

    public void setC6_p602(String c6_p602) {
        this.c6_p602 = c6_p602;
    }

    public String getC6_p603() {
        return c6_p603;
    }

    public void setC6_p603(String c6_p603) {
        this.c6_p603 = c6_p603;
    }

    public String getC6_p604_1() {
        return c6_p604_1;
    }

    public void setC6_p604_1(String c6_p604_1) {
        this.c6_p604_1 = c6_p604_1;
    }

    public String getC6_p604_2() {
        return c6_p604_2;
    }

    public void setC6_p604_2(String c6_p604_2) {
        this.c6_p604_2 = c6_p604_2;
    }

    public String getC6_p604_3() {
        return c6_p604_3;
    }

    public void setC6_p604_3(String c6_p604_3) {
        this.c6_p604_3 = c6_p604_3;
    }

    public String getC6_p604_4() {
        return c6_p604_4;
    }

    public void setC6_p604_4(String c6_p604_4) {
        this.c6_p604_4 = c6_p604_4;
    }

    public String getC6_p604_5() {
        return c6_p604_5;
    }

    public void setC6_p604_5(String c6_p604_5) {
        this.c6_p604_5 = c6_p604_5;
    }

    public String getC6_p604_6() {
        return c6_p604_6;
    }

    public void setC6_p604_6(String c6_p604_6) {
        this.c6_p604_6 = c6_p604_6;
    }

    public String getC6_p604_7() {
        return c6_p604_7;
    }

    public void setC6_p604_7(String c6_p604_7) {
        this.c6_p604_7 = c6_p604_7;
    }

    public String getC6_p604_8() {
        return c6_p604_8;
    }

    public void setC6_p604_8(String c6_p604_8) {
        this.c6_p604_8 = c6_p604_8;
    }

    public String getC6_p604_9() {
        return c6_p604_9;
    }

    public void setC6_p604_9(String c6_p604_9) {
        this.c6_p604_9 = c6_p604_9;
    }

    public String getC6_p604_10() {
        return c6_p604_10;
    }

    public void setC6_p604_10(String c6_p604_10) {
        this.c6_p604_10 = c6_p604_10;
    }

    public String getC6_p604_11() {
        return c6_p604_11;
    }

    public void setC6_p604_11(String c6_p604_11) {
        this.c6_p604_11 = c6_p604_11;
    }

    public String getC6_p604_o() {
        return c6_p604_o;
    }

    public void setC6_p604_o(String c6_p604_o) {
        this.c6_p604_o = c6_p604_o;
    }

    public String getC6_p605() {
        return c6_p605;
    }

    public void setC6_p605(String c6_p605) {
        this.c6_p605 = c6_p605;
    }

    public String getC6_p606() {
        return c6_p606;
    }

    public void setC6_p606(String c6_p606) {
        this.c6_p606 = c6_p606;
    }

    public String getC6_p607() {
        return c6_p607;
    }

    public void setC6_p607(String c6_p607) {
        this.c6_p607 = c6_p607;
    }

    public String getC6_p608() {
        return c6_p608;
    }

    public void setC6_p608(String c6_p608) {
        this.c6_p608 = c6_p608;
    }

    public String getC6_p608_o() {
        return c6_p608_o;
    }

    public void setC6_p608_o(String c6_p608_o) {
        this.c6_p608_o = c6_p608_o;
    }

    public String getC6_p609() {
        return c6_p609;
    }

    public void setC6_p609(String c6_p609) {
        this.c6_p609 = c6_p609;
    }

    public String getC6_p610_pd() {
        return c6_p610_pd;
    }

    public void setC6_p610_pd(String c6_p610_pd) {
        this.c6_p610_pd = c6_p610_pd;
    }

    public String getC6_p610_pl() {
        return c6_p610_pl;
    }

    public void setC6_p610_pl(String c6_p610_pl) {
        this.c6_p610_pl = c6_p610_pl;
    }

    public String getC6_p610_pm() {
        return c6_p610_pm;
    }

    public void setC6_p610_pm(String c6_p610_pm) {
        this.c6_p610_pm = c6_p610_pm;
    }

    public String getC6_p610_pmi() {
        return c6_p610_pmi;
    }

    public void setC6_p610_pmi(String c6_p610_pmi) {
        this.c6_p610_pmi = c6_p610_pmi;
    }

    public String getC6_p610_pj() {
        return c6_p610_pj;
    }

    public void setC6_p610_pj(String c6_p610_pj) {
        this.c6_p610_pj = c6_p610_pj;
    }

    public String getC6_p610_pv() {
        return c6_p610_pv;
    }

    public void setC6_p610_pv(String c6_p610_pv) {
        this.c6_p610_pv = c6_p610_pv;
    }

    public String getC6_p610_ps() {
        return c6_p610_ps;
    }

    public void setC6_p610_ps(String c6_p610_ps) {
        this.c6_p610_ps = c6_p610_ps;
    }

    public String getC6_p610_pt() {
        return c6_p610_pt;
    }

    public void setC6_p610_pt(String c6_p610_pt) {
        this.c6_p610_pt = c6_p610_pt;
    }

    public String getC6_p610_sd() {
        return c6_p610_sd;
    }

    public void setC6_p610_sd(String c6_p610_sd) {
        this.c6_p610_sd = c6_p610_sd;
    }

    public String getC6_p610_sl() {
        return c6_p610_sl;
    }

    public void setC6_p610_sl(String c6_p610_sl) {
        this.c6_p610_sl = c6_p610_sl;
    }

    public String getC6_p610_sm() {
        return c6_p610_sm;
    }

    public void setC6_p610_sm(String c6_p610_sm) {
        this.c6_p610_sm = c6_p610_sm;
    }

    public String getC6_p610_smi() {
        return c6_p610_smi;
    }

    public void setC6_p610_smi(String c6_p610_smi) {
        this.c6_p610_smi = c6_p610_smi;
    }

    public String getC6_p610_sj() {
        return c6_p610_sj;
    }

    public void setC6_p610_sj(String c6_p610_sj) {
        this.c6_p610_sj = c6_p610_sj;
    }

    public String getC6_p610_sv() {
        return c6_p610_sv;
    }

    public void setC6_p610_sv(String c6_p610_sv) {
        this.c6_p610_sv = c6_p610_sv;
    }

    public String getC6_p610_ss() {
        return c6_p610_ss;
    }

    public void setC6_p610_ss(String c6_p610_ss) {
        this.c6_p610_ss = c6_p610_ss;
    }

    public String getC6_p610_st() {
        return c6_p610_st;
    }

    public void setC6_p610_st(String c6_p610_st) {
        this.c6_p610_st = c6_p610_st;
    }

    public String getC6_p610_t() {
        return c6_p610_t;
    }

    public void setC6_p610_t(String c6_p610_t) {
        this.c6_p610_t = c6_p610_t;
    }

    public String getC6_p611() {
        return c6_p611;
    }

    public void setC6_p611(String c6_p611) {
        this.c6_p611 = c6_p611;
    }

    public String getC6_p612() {
        return c6_p612;
    }

    public void setC6_p612(String c6_p612) {
        this.c6_p612 = c6_p612;
    }

    public String getC6_p612_nro() {
        return c6_p612_nro;
    }

    public void setC6_p612_nro(String c6_p612_nro) {
        this.c6_p612_nro = c6_p612_nro;
    }

    public String getC6_p613() {
        return c6_p613;
    }

    public void setC6_p613(String c6_p613) {
        this.c6_p613 = c6_p613;
    }

    public String getC6_p614_mon() {
        return c6_p614_mon;
    }

    public void setC6_p614_mon(String c6_p614_mon) {
        this.c6_p614_mon = c6_p614_mon;
    }

    public String getC6_p614_esp() {
        return c6_p614_esp;
    }

    public void setC6_p614_esp(String c6_p614_esp) {
        this.c6_p614_esp = c6_p614_esp;
    }

    public String getC6_p615_mon() {
        return c6_p615_mon;
    }

    public void setC6_p615_mon(String c6_p615_mon) {
        this.c6_p615_mon = c6_p615_mon;
    }

    public String getC6_p615_esp() {
        return c6_p615_esp;
    }

    public void setC6_p615_esp(String c6_p615_esp) {
        this.c6_p615_esp = c6_p615_esp;
    }

    public String getC6_p616_mon() {
        return c6_p616_mon;
    }

    public void setC6_p616_mon(String c6_p616_mon) {
        this.c6_p616_mon = c6_p616_mon;
    }

    public String getC6_p616_esp() {
        return c6_p616_esp;
    }

    public void setC6_p616_esp(String c6_p616_esp) {
        this.c6_p616_esp = c6_p616_esp;
    }

    public String getC6_p616_nas() {
        return c6_p616_nas;
    }

    public void setC6_p616_nas(String c6_p616_nas) {
        this.c6_p616_nas = c6_p616_nas;
    }

    public String getC6_p617() {
        return c6_p617;
    }

    public void setC6_p617(String c6_p617) {
        this.c6_p617 = c6_p617;
    }

    public String getC6_p617_dist() {
        return c6_p617_dist;
    }

    public void setC6_p617_dist(String c6_p617_dist) {
        this.c6_p617_dist = c6_p617_dist;
    }

    public String getC6_p617_prov() {
        return c6_p617_prov;
    }

    public void setC6_p617_prov(String c6_p617_prov) {
        this.c6_p617_prov = c6_p617_prov;
    }

    public String getC6_p617_dep() {
        return c6_p617_dep;
    }

    public void setC6_p617_dep(String c6_p617_dep) {
        this.c6_p617_dep = c6_p617_dep;
    }

    public String getC6_p625_1() {
        return c6_p625_1;
    }

    public void setC6_p625_1(String c6_p625_1) {
        this.c6_p625_1 = c6_p625_1;
    }

    public String getC6_p625_2() {
        return c6_p625_2;
    }

    public void setC6_p625_2(String c6_p625_2) {
        this.c6_p625_2 = c6_p625_2;
    }

    public String getC6_p625_3() {
        return c6_p625_3;
    }

    public void setC6_p625_3(String c6_p625_3) {
        this.c6_p625_3 = c6_p625_3;
    }

    public String getC6_p625_4() {
        return c6_p625_4;
    }

    public void setC6_p625_4(String c6_p625_4) {
        this.c6_p625_4 = c6_p625_4;
    }

    public String getC6_p625_5() {
        return c6_p625_5;
    }

    public void setC6_p625_5(String c6_p625_5) {
        this.c6_p625_5 = c6_p625_5;
    }

    public String getC6_p625_6() {
        return c6_p625_6;
    }

    public void setC6_p625_6(String c6_p625_6) {
        this.c6_p625_6 = c6_p625_6;
    }

    public String getC6_p625_o() {
        return c6_p625_o;
    }

    public void setC6_p625_o(String c6_p625_o) {
        this.c6_p625_o = c6_p625_o;
    }

    public String getC6_p618() {
        return c6_p618;
    }

    public void setC6_p618(String c6_p618) {
        this.c6_p618 = c6_p618;
    }

    public String getC6_p619_1() {
        return c6_p619_1;
    }

    public void setC6_p619_1(String c6_p619_1) {
        this.c6_p619_1 = c6_p619_1;
    }

    public String getC6_p619_2() {
        return c6_p619_2;
    }

    public void setC6_p619_2(String c6_p619_2) {
        this.c6_p619_2 = c6_p619_2;
    }

    public String getC6_p619_3() {
        return c6_p619_3;
    }

    public void setC6_p619_3(String c6_p619_3) {
        this.c6_p619_3 = c6_p619_3;
    }

    public String getC6_p619_4() {
        return c6_p619_4;
    }

    public void setC6_p619_4(String c6_p619_4) {
        this.c6_p619_4 = c6_p619_4;
    }

    public String getC6_p619_5() {
        return c6_p619_5;
    }

    public void setC6_p619_5(String c6_p619_5) {
        this.c6_p619_5 = c6_p619_5;
    }

    public String getC6_p619_6() {
        return c6_p619_6;
    }

    public void setC6_p619_6(String c6_p619_6) {
        this.c6_p619_6 = c6_p619_6;
    }

    public String getC6_p619_7() {
        return c6_p619_7;
    }

    public void setC6_p619_7(String c6_p619_7) {
        this.c6_p619_7 = c6_p619_7;
    }

    public String getC6_p619_8() {
        return c6_p619_8;
    }

    public void setC6_p619_8(String c6_p619_8) {
        this.c6_p619_8 = c6_p619_8;
    }

    public String getC6_p619_9() {
        return c6_p619_9;
    }

    public void setC6_p619_9(String c6_p619_9) {
        this.c6_p619_9 = c6_p619_9;
    }

    public String getC6_p619_o() {
        return c6_p619_o;
    }

    public void setC6_p619_o(String c6_p619_o) {
        this.c6_p619_o = c6_p619_o;
    }

    public String getC6_p620() {
        return c6_p620;
    }

    public void setC6_p620(String c6_p620) {
        this.c6_p620 = c6_p620;
    }

    public String getC6_p621() {
        return c6_p621;
    }

    public void setC6_p621(String c6_p621) {
        this.c6_p621 = c6_p621;
    }

    public String getC6_p622() {
        return c6_p622;
    }

    public void setC6_p622(String c6_p622) {
        this.c6_p622 = c6_p622;
    }

    public String getC6_p622_o() {
        return c6_p622_o;
    }

    public void setC6_p622_o(String c6_p622_o) {
        this.c6_p622_o = c6_p622_o;
    }

    public String getC6_p623() {
        return c6_p623;
    }

    public void setC6_p623(String c6_p623) {
        this.c6_p623 = c6_p623;
    }

    public String getC6_p623_o() {
        return c6_p623_o;
    }

    public void setC6_p623_o(String c6_p623_o) {
        this.c6_p623_o = c6_p623_o;
    }

    public String getC6_p624() {
        return c6_p624;
    }

    public void setC6_p624(String c6_p624) {
        this.c6_p624 = c6_p624;
    }

    public String getC6_p626() {
        return c6_p626;
    }

    public void setC6_p626(String c6_p626) {
        this.c6_p626 = c6_p626;
    }

    public String getC6_p627() {
        return c6_p627;
    }

    public void setC6_p627(String c6_p627) {
        this.c6_p627 = c6_p627;
    }

    public String getC6_p628() {
        return c6_p628;
    }

    public void setC6_p628(String c6_p628) {
        this.c6_p628 = c6_p628;
    }

    public String getC6_p629_1() {
        return c6_p629_1;
    }

    public void setC6_p629_1(String c6_p629_1) {
        this.c6_p629_1 = c6_p629_1;
    }

    public String getC6_p629_2() {
        return c6_p629_2;
    }

    public void setC6_p629_2(String c6_p629_2) {
        this.c6_p629_2 = c6_p629_2;
    }

    public String getC6_p629_3() {
        return c6_p629_3;
    }

    public void setC6_p629_3(String c6_p629_3) {
        this.c6_p629_3 = c6_p629_3;
    }

    public String getC6_p629_4() {
        return c6_p629_4;
    }

    public void setC6_p629_4(String c6_p629_4) {
        this.c6_p629_4 = c6_p629_4;
    }

    public String getC6_p629_o() {
        return c6_p629_o;
    }

    public void setC6_p629_o(String c6_p629_o) {
        this.c6_p629_o = c6_p629_o;
    }

    public String getC6_p629_1_f() {
        return c6_p629_1_f;
    }

    public void setC6_p629_1_f(String c6_p629_1_f) {
        this.c6_p629_1_f = c6_p629_1_f;
    }

    public String getC6_p629_1_m() {
        return c6_p629_1_m;
    }

    public void setC6_p629_1_m(String c6_p629_1_m) {
        this.c6_p629_1_m = c6_p629_1_m;
    }

    public String getC6_p629_2_f() {
        return c6_p629_2_f;
    }

    public void setC6_p629_2_f(String c6_p629_2_f) {
        this.c6_p629_2_f = c6_p629_2_f;
    }

    public String getC6_p629_2_m() {
        return c6_p629_2_m;
    }

    public void setC6_p629_2_m(String c6_p629_2_m) {
        this.c6_p629_2_m = c6_p629_2_m;
    }

    public String getC6_p629_3_f() {
        if(c6_p629_3_f==null) return ""; else return c6_p629_3_f;
    }

    public void setC6_p629_3_f(String c6_p629_3_f) {
        this.c6_p629_3_f = c6_p629_3_f;
    }

    public String getC6_p629_3_m() {
        return c6_p629_3_m;
    }

    public void setC6_p629_3_m(String c6_p629_3_m) {
        this.c6_p629_3_m = c6_p629_3_m;
    }

    public String getC6_p629_4_f() {
        return c6_p629_4_f;
    }

    public void setC6_p629_4_f(String c6_p629_4_f) {
        this.c6_p629_4_f = c6_p629_4_f;
    }

    public String getC6_p629_4_m() {
        return c6_p629_4_m;
    }

    public void setC6_p629_4_m(String c6_p629_4_m) {
        this.c6_p629_4_m = c6_p629_4_m;
    }

    public String getC6_p630_1frec() {
        return c6_p630_1frec;
    }

    public void setC6_p630_1frec(String c6_p630_1frec) {
        this.c6_p630_1frec = c6_p630_1frec;
    }

    public String getC6_p630_1() {
        return c6_p630_1;
    }

    public void setC6_p630_1(String c6_p630_1) {
        this.c6_p630_1 = c6_p630_1;
    }

    public String getC6_p630_1med() {
        return c6_p630_1med;
    }

    public void setC6_p630_1med(String c6_p630_1med) {
        this.c6_p630_1med = c6_p630_1med;
    }

    public String getC6_p630_1o() {
        return c6_p630_1o;
    }

    public void setC6_p630_1o(String c6_p630_1o) {
        this.c6_p630_1o = c6_p630_1o;
    }

    public String getC6_p630_1mont() {
        return c6_p630_1mont;
    }

    public void setC6_p630_1mont(String c6_p630_1mont) {
        this.c6_p630_1mont = c6_p630_1mont;
    }

    public String getC6_p630_2() {
        return c6_p630_2;
    }

    public void setC6_p630_2(String c6_p630_2) {
        this.c6_p630_2 = c6_p630_2;
    }

    public String getC6_p630_2med() {
        return c6_p630_2med;
    }

    public void setC6_p630_2med(String c6_p630_2med) {
        this.c6_p630_2med = c6_p630_2med;
    }

    public String getC6_p630_2o() {
        return c6_p630_2o;
    }

    public void setC6_p630_2o(String c6_p630_2o) {
        this.c6_p630_2o = c6_p630_2o;
    }

    public String getC6_p630_2mont() {
        return c6_p630_2mont;
    }

    public void setC6_p630_2mont(String c6_p630_2mont) {
        this.c6_p630_2mont = c6_p630_2mont;
    }

    public String getObs_cap6() {
        return obs_cap6;
    }

    public void setObs_cap6(String obs_cap6) {
        this.obs_cap6 = obs_cap6;
    }

    public String getC6_estado() {
        return c6_estado;
    }

    public void setC6_estado(String c6_estado) {
        this.c6_estado = c6_estado;
    }

    public boolean getC6_p604_trabajo(){
        if(this.c6_p604_1==null || this.c6_p604_2==null || this.c6_p604_3==null ||
            this.c6_p604_4==null || this.c6_p604_5==null || this.c6_p604_6==null ||
            this.c6_p604_7==null || this.c6_p604_8==null || this.c6_p604_9==null ||
            this.c6_p604_10==null || this.c6_p604_11==null){
            return true;
        }else{
            if(this.c6_p604_1.equals("1") || this.c6_p604_2.equals("1") || this.c6_p604_3.equals("1") ||
                this.c6_p604_4.equals("1") || this.c6_p604_5.equals("1") || this.c6_p604_6.equals("1") ||
                this.c6_p604_7.equals("1") || this.c6_p604_8.equals("1") || this.c6_p604_9.equals("1") ||
                this.c6_p604_10.equals("1") || this.c6_p604_11.equals("1")){
                return false;
            }else{
                return true;
            }
        }
    }

    public boolean pasar_a_p623(){
        if(this.c6_p618==null){
            return false;
        }else if(this.c6_p618.equals("0")){
            return true;
        }else{
            return false;
        }
    }

    public boolean pasar_a_p625(){
        if(this.c6_p620==null){
            return false;
        }else{
            if(this.c6_p620.equals("1")){
                return  true;
            }else{
                if(this.c6_p621==null){
                    return false;
                }else if(this.c6_p621.equals("1")){
                    return  true;
                }else return false;
            }
        }
    }

    public ContentValues toValues(){
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLConstantes.modulo6_id,_id);
        contentValues.put(SQLConstantes.modulo6_idInformante,idInformante);
        contentValues.put(SQLConstantes.modulo6_idHogar,idHogar);
        contentValues.put(SQLConstantes.modulo6_idVivienda,idVivienda);
        contentValues.put(SQLConstantes.modulo6_c6_p601,c6_p601);
        contentValues.put(SQLConstantes.modulo6_c6_p602,c6_p602);
        contentValues.put(SQLConstantes.modulo6_c6_p603,c6_p603);
        contentValues.put(SQLConstantes.modulo6_c6_p604_1,c6_p604_1);
        contentValues.put(SQLConstantes.modulo6_c6_p604_2,c6_p604_2);
        contentValues.put(SQLConstantes.modulo6_c6_p604_3,c6_p604_3);
        contentValues.put(SQLConstantes.modulo6_c6_p604_4,c6_p604_4);
        contentValues.put(SQLConstantes.modulo6_c6_p604_5,c6_p604_5);
        contentValues.put(SQLConstantes.modulo6_c6_p604_6,c6_p604_6);
        contentValues.put(SQLConstantes.modulo6_c6_p604_7,c6_p604_7);
        contentValues.put(SQLConstantes.modulo6_c6_p604_8,c6_p604_8);
        contentValues.put(SQLConstantes.modulo6_c6_p604_9,c6_p604_9);
        contentValues.put(SQLConstantes.modulo6_c6_p604_10,c6_p604_10);
        contentValues.put(SQLConstantes.modulo6_c6_p604_11,c6_p604_11);
        contentValues.put(SQLConstantes.modulo6_c6_p604_o,c6_p604_o);
        contentValues.put(SQLConstantes.modulo6_c6_p605,c6_p605);
        contentValues.put(SQLConstantes.modulo6_c6_p606,c6_p606);
        contentValues.put(SQLConstantes.modulo6_c6_p607,c6_p607);
        contentValues.put(SQLConstantes.modulo6_c6_p608,c6_p608);
        contentValues.put(SQLConstantes.modulo6_c6_p608_o,c6_p608_o);
        contentValues.put(SQLConstantes.modulo6_c6_p609,c6_p609);
        contentValues.put(SQLConstantes.modulo6_c6_p610_pd,c6_p610_pd);
        contentValues.put(SQLConstantes.modulo6_c6_p610_pl,c6_p610_pl);
        contentValues.put(SQLConstantes.modulo6_c6_p610_pm,c6_p610_pm);
        contentValues.put(SQLConstantes.modulo6_c6_p610_pmi,c6_p610_pmi);
        contentValues.put(SQLConstantes.modulo6_c6_p610_pj,c6_p610_pj);
        contentValues.put(SQLConstantes.modulo6_c6_p610_pv,c6_p610_pv);
        contentValues.put(SQLConstantes.modulo6_c6_p610_ps,c6_p610_ps);
        contentValues.put(SQLConstantes.modulo6_c6_p610_pt,c6_p610_pt);
        contentValues.put(SQLConstantes.modulo6_c6_p610_sd,c6_p610_sd);
        contentValues.put(SQLConstantes.modulo6_c6_p610_sl,c6_p610_sl);
        contentValues.put(SQLConstantes.modulo6_c6_p610_sm,c6_p610_sm);
        contentValues.put(SQLConstantes.modulo6_c6_p610_smi,c6_p610_smi);
        contentValues.put(SQLConstantes.modulo6_c6_p610_sj,c6_p610_sj);
        contentValues.put(SQLConstantes.modulo6_c6_p610_sv,c6_p610_sv);
        contentValues.put(SQLConstantes.modulo6_c6_p610_ss,c6_p610_ss);
        contentValues.put(SQLConstantes.modulo6_c6_p610_st,c6_p610_st);
        contentValues.put(SQLConstantes.modulo6_c6_p610_t,c6_p610_t);
        contentValues.put(SQLConstantes.modulo6_c6_p611,c6_p611);
        contentValues.put(SQLConstantes.modulo6_c6_p612,c6_p612);
        contentValues.put(SQLConstantes.modulo6_c6_p612_nro,c6_p612_nro);
        contentValues.put(SQLConstantes.modulo6_c6_p613,c6_p613);
        contentValues.put(SQLConstantes.modulo6_c6_p614_mon,c6_p614_mon);
        contentValues.put(SQLConstantes.modulo6_c6_p614_esp,c6_p614_esp);
        contentValues.put(SQLConstantes.modulo6_c6_p615_mon,c6_p615_mon);
        contentValues.put(SQLConstantes.modulo6_c6_p615_esp,c6_p615_esp);
        contentValues.put(SQLConstantes.modulo6_c6_p616_mon,c6_p616_mon);
        contentValues.put(SQLConstantes.modulo6_c6_p616_esp,c6_p616_esp);
        contentValues.put(SQLConstantes.modulo6_c6_p616_nas,c6_p616_nas);
        contentValues.put(SQLConstantes.modulo6_c6_p617,c6_p617);
        contentValues.put(SQLConstantes.modulo6_c6_p617_dist,c6_p617_dist);
        contentValues.put(SQLConstantes.modulo6_c6_p617_prov,c6_p617_prov);
        contentValues.put(SQLConstantes.modulo6_c6_p617_dep,c6_p617_dep);
        contentValues.put(SQLConstantes.modulo6_c6_p625_1,c6_p625_1);
        contentValues.put(SQLConstantes.modulo6_c6_p625_2,c6_p625_2);
        contentValues.put(SQLConstantes.modulo6_c6_p625_3,c6_p625_3);
        contentValues.put(SQLConstantes.modulo6_c6_p625_4,c6_p625_4);
        contentValues.put(SQLConstantes.modulo6_c6_p625_5,c6_p625_5);
        contentValues.put(SQLConstantes.modulo6_c6_p625_6,c6_p625_6);
        contentValues.put(SQLConstantes.modulo6_c6_p625_o,c6_p625_o);
        contentValues.put(SQLConstantes.modulo6_c6_p618,c6_p618);
        contentValues.put(SQLConstantes.modulo6_c6_p619_1,c6_p619_1);
        contentValues.put(SQLConstantes.modulo6_c6_p619_2,c6_p619_2);
        contentValues.put(SQLConstantes.modulo6_c6_p619_3,c6_p619_3);
        contentValues.put(SQLConstantes.modulo6_c6_p619_4,c6_p619_4);
        contentValues.put(SQLConstantes.modulo6_c6_p619_5,c6_p619_5);
        contentValues.put(SQLConstantes.modulo6_c6_p619_6,c6_p619_6);
        contentValues.put(SQLConstantes.modulo6_c6_p619_7,c6_p619_7);
        contentValues.put(SQLConstantes.modulo6_c6_p619_8,c6_p619_8);
        contentValues.put(SQLConstantes.modulo6_c6_p619_9,c6_p619_9);
        contentValues.put(SQLConstantes.modulo6_c6_p619_o,c6_p619_o);
        contentValues.put(SQLConstantes.modulo6_c6_p620,c6_p620);
        contentValues.put(SQLConstantes.modulo6_c6_p621,c6_p621);
        contentValues.put(SQLConstantes.modulo6_c6_p622,c6_p622);
        contentValues.put(SQLConstantes.modulo6_c6_p622_o,c6_p622_o);
        contentValues.put(SQLConstantes.modulo6_c6_p623,c6_p623);
        contentValues.put(SQLConstantes.modulo6_c6_p623_o,c6_p623_o);
        contentValues.put(SQLConstantes.modulo6_c6_p624,c6_p624);
        contentValues.put(SQLConstantes.modulo6_c6_p626,c6_p626);
        contentValues.put(SQLConstantes.modulo6_c6_p627,c6_p627);
        contentValues.put(SQLConstantes.modulo6_c6_p628,c6_p628);
        contentValues.put(SQLConstantes.modulo6_c6_p629_1,c6_p629_1);
        contentValues.put(SQLConstantes.modulo6_c6_p629_2,c6_p629_2);
        contentValues.put(SQLConstantes.modulo6_c6_p629_3,c6_p629_3);
        contentValues.put(SQLConstantes.modulo6_c6_p629_4,c6_p629_4);
        contentValues.put(SQLConstantes.modulo6_c6_p629_o,c6_p629_o);
        contentValues.put(SQLConstantes.modulo6_c6_p629_1_f,c6_p629_1_f);
        contentValues.put(SQLConstantes.modulo6_c6_p629_1_m,c6_p629_1_m);
        contentValues.put(SQLConstantes.modulo6_c6_p629_2_f,c6_p629_2_f);
        contentValues.put(SQLConstantes.modulo6_c6_p629_2_m,c6_p629_2_m);
        contentValues.put(SQLConstantes.modulo6_c6_p629_3_f,c6_p629_3_f);
        contentValues.put(SQLConstantes.modulo6_c6_p629_3_m,c6_p629_3_m);
        contentValues.put(SQLConstantes.modulo6_c6_p629_4_f,c6_p629_4_f);
        contentValues.put(SQLConstantes.modulo6_c6_p629_4_m,c6_p629_4_m);
        contentValues.put(SQLConstantes.modulo6_c6_p630_1,c6_p630_1);
        contentValues.put(SQLConstantes.modulo6_c6_p630_1med,c6_p630_1med);
        contentValues.put(SQLConstantes.modulo6_c6_p630_1o,c6_p630_1o);
        contentValues.put(SQLConstantes.modulo6_c6_p630_1frec,c6_p630_1frec);
        contentValues.put(SQLConstantes.modulo6_c6_p630_1mont,c6_p630_1mont);
        contentValues.put(SQLConstantes.modulo6_c6_p630_2,c6_p630_2);
        contentValues.put(SQLConstantes.modulo6_c6_p630_2med,c6_p630_2med);
        contentValues.put(SQLConstantes.modulo6_c6_p630_2o,c6_p630_2o);
        contentValues.put(SQLConstantes.modulo6_c6_p630_2frec,c6_p630_2frec);
        contentValues.put(SQLConstantes.modulo6_c6_p630_2mont,c6_p630_2mont);
        contentValues.put(SQLConstantes.modulo6_obs_cap6,obs_cap6);
        contentValues.put(SQLConstantes.modulo6_c6_estado,c6_estado);
        return contentValues;
    }
}

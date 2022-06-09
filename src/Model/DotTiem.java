/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author admin
 */
public class DotTiem {
    private String madottiem;
    private Date ngaytiem;
    private String maquan;
    private String maphuong;
    private String masolo;
    private String masods;
    private String madoingu;
    
    public DotTiem(){
        
    }

    public DotTiem(String madottiem, Date ngaytiem, String maquan, String maphuong, String masolo, String masods, String madoingu) {
        this.madottiem = madottiem;
        this.ngaytiem = ngaytiem;
        this.maquan = maquan;
        this.maphuong = maphuong;
        this.masolo = masolo;
        this.masods = masods;
        this.madoingu = madoingu;
    }

    public String getMadottiem() {
        return madottiem;
    }

    public void setMadottiem(String madottiem) {
        this.madottiem = madottiem;
    }

    public Date getNgaytiem() {
        return ngaytiem;
    }

    public void setNgaytiem(Date ngaytiem) {
        this.ngaytiem = ngaytiem;
    }

    public String getMaquan() {
        return maquan;
    }

    public void setMaquan(String maquan) {
        this.maquan = maquan;
    }

    public String getMaphuong() {
        return maphuong;
    }

    public void setMaphuong(String maphuong) {
        this.maphuong = maphuong;
    }

    public String getMasolo() {
        return masolo;
    }

    public void setMasolo(String masolo) {
        this.masolo = masolo;
    }

    public String getMasods() {
        return masods;
    }

    public void setMasods(String masods) {
        this.masods = masods;
    }

    public String getMadoingu() {
        return madoingu;
    }

    public void setMadoingu(String madoingu) {
        this.madoingu = madoingu;
    }

    @Override
    public String toString() {
        return "DotTiem{" + "madottiem=" + madottiem + '}';
    }
 

}


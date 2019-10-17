package sdkdemo.kx.come.easypaylibrary.bean.payment;

import java.io.Serializable;

public class ext2 implements Serializable {
    private int crdLvl;
    private int taxAmt;
    private int custCd;
    private int mchPostCd;
    private int taxId;
    private int mchMinorityCd;
    private int mchStateCd;
    private int shipPostCd;
    private int destPostCd;
    private int invoiceNum;
    private int freightAmt;
    private int dutyAmt;

    public int getCrdLvl() {
        return crdLvl;
    }

    public void setCrdLvl(int crdLvl) {
        this.crdLvl = crdLvl;
    }

    public int getTaxAmt() {
        return taxAmt;
    }

    public void setTaxAmt(int taxAmt) {
        this.taxAmt = taxAmt;
    }

    public int getCustCd() {
        return custCd;
    }

    public void setCustCd(int custCd) {
        this.custCd = custCd;
    }

    public int getMchPostCd() {
        return mchPostCd;
    }

    public void setMchPostCd(int mchPostCd) {
        this.mchPostCd = mchPostCd;
    }

    public int getTaxId() {
        return taxId;
    }

    public void setTaxId(int taxId) {
        this.taxId = taxId;
    }

    public int getMchMinorityCd() {
        return mchMinorityCd;
    }

    public void setMchMinorityCd(int mchMinorityCd) {
        this.mchMinorityCd = mchMinorityCd;
    }

    public int getMchStateCd() {
        return mchStateCd;
    }

    public void setMchStateCd(int mchStateCd) {
        this.mchStateCd = mchStateCd;
    }

    public int getShipPostCd() {
        return shipPostCd;
    }

    public void setShipPostCd(int shipPostCd) {
        this.shipPostCd = shipPostCd;
    }

    public int getDestPostCd() {
        return destPostCd;
    }

    public void setDestPostCd(int destPostCd) {
        this.destPostCd = destPostCd;
    }

    public int getInvoiceNum() {
        return invoiceNum;
    }

    public void setInvoiceNum(int invoiceNum) {
        this.invoiceNum = invoiceNum;
    }

    public int getFreightAmt() {
        return freightAmt;
    }

    public void setFreightAmt(int freightAmt) {
        this.freightAmt = freightAmt;
    }

    public int getDutyAmt() {
        return dutyAmt;
    }

    public void setDutyAmt(int dutyAmt) {
        this.dutyAmt = dutyAmt;
    }
}

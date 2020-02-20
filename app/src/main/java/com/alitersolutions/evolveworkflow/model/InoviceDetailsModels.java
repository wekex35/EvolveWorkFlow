package com.alitersolutions.evolveworkflow.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class InoviceDetailsModels {
    @SerializedName("Comments")
    @Expose
    private String Comments;
    @SerializedName("Company Code")
    @Expose
    private String CompanyCode;
    @SerializedName("Cost Centre")
    @Expose
    private String CostCentre;
    @SerializedName("Currency")
    @Expose
    private String Currency;
    @SerializedName("Date")
    @Expose
    private String Date;
    @SerializedName("Debit / Credit")
    @Expose
    private String DebitCredit;
    @SerializedName("Document Subtype")
    @Expose
    private String DocumentSubtype;
    @SerializedName("Document Type")
    @Expose
    private String DocumentType;
    @SerializedName("Expense Type")
    @Expose
    private String ExpenseType;
    @SerializedName("Invoice Amount")
    @Expose
    private String InvoiceAmount;
    @SerializedName("Invoice Doc No")
    @Expose
    private String InvoiceDocNo;
    @SerializedName("Logged Action")
    @Expose
    private String LoggedAction;
    @SerializedName("Plant")
    @Expose
    private String Plant;
    @SerializedName("Processed By")
    @Expose
    private String ProcessedBy;
    @SerializedName("REFERENCE NBr")
    @Expose
    private String REFERENCENBr;
    @SerializedName("Vendor Code")
    @Expose
    private String VendorCode;
    @SerializedName("Vendor Name")
    @Expose
    private String VendorName;

    public String getDocumentType() {
        return this.DocumentType;
    }

    public void setDocumentType(String documentType) {
        this.DocumentType = documentType;
    }

    public String getDocumentSubtype() {
        return this.DocumentSubtype;
    }

    public void setDocumentSubtype(String documentSubtype) {
        this.DocumentSubtype = documentSubtype;
    }

    public String getREFERENCENBr() {
        return this.REFERENCENBr;
    }

    public void setREFERENCENBr(String REFERENCENBr2) {
        this.REFERENCENBr = REFERENCENBr2;
    }

    public String getInvoiceDocNo() {
        return this.InvoiceDocNo;
    }

    public void setInvoiceDocNo(String invoiceDocNo) {
        this.InvoiceDocNo = invoiceDocNo;
    }

    public String getCompanyCode() {
        return this.CompanyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.CompanyCode = companyCode;
    }

    public String getPlant() {
        return this.Plant;
    }

    public void setPlant(String plant) {
        this.Plant = plant;
    }

    public String getInvoiceAmount() {
        return this.InvoiceAmount;
    }

    public void setInvoiceAmount(String invoiceAmount) {
        this.InvoiceAmount = invoiceAmount;
    }

    public String getCurrency() {
        return this.Currency;
    }

    public void setCurrency(String currency) {
        this.Currency = currency;
    }

    public String getExpenseType() {
        return this.ExpenseType;
    }

    public void setExpenseType(String expenseType) {
        this.ExpenseType = expenseType;
    }

    public String getVendorCode() {
        return this.VendorCode;
    }

    public void setVendorCode(String vendorCode) {
        this.VendorCode = vendorCode;
    }

    public String getVendorName() {
        return this.VendorName;
    }

    public void setVendorName(String vendorName) {
        this.VendorName = vendorName;
    }

    public String getDebitCredit() {
        return this.DebitCredit;
    }

    public void setDebitCredit(String debitCredit) {
        this.DebitCredit = debitCredit;
    }

    public String getCostCentre() {
        return this.CostCentre;
    }

    public void setCostCentre(String costCentre) {
        this.CostCentre = costCentre;
    }

    public String getProcessedBy() {
        return this.ProcessedBy;
    }

    public void setProcessedBy(String processedBy) {
        this.ProcessedBy = processedBy;
    }

    public String getDate() {
        return this.Date;
    }

    public void setDate(String date) {
        this.Date = date;
    }

    public String getLoggedAction() {
        return this.LoggedAction;
    }

    public void setLoggedAction(String loggedAction) {
        this.LoggedAction = loggedAction;
    }

    public String getComments() {
        return this.Comments;
    }

    public void setComments(String comments) {
        this.Comments = comments;
    }
}

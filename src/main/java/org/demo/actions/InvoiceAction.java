package org.demo.actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.demo.actions.beans.InvoiceBean;


public class InvoiceAction extends ActionSupport {

    private InvoiceBean invoiceBean;

    public InvoiceBean getInvoiceBean() {
        return invoiceBean;
    }

    public void setInvoiceBean(InvoiceBean invoiceBean) {
        this.invoiceBean = invoiceBean;
    }

    @Override
    public String execute() throws Exception {
        double totalAmount = calculateTotalAmount(invoiceBean.getGrossAmount());

        ActionContext.getContext().getSession().put("invoice", invoiceBean);
        ActionContext.getContext().getSession().put("totalAmount", totalAmount);

        return SUCCESS;
    }

    @Override
    public void validate() {
        if (invoiceBean.getSubject().isEmpty()) {
            addFieldError("invoiceBean.subject", "El concepto es obligatorio.");
        }
        if (invoiceBean.getGrossAmount() == 0) {
            addFieldError("invoiceBean.grossAmount", "El importe es obligatorio.");
        }
        if (invoiceBean.getDateFrom() == null) {
            addFieldError("invoiceBean.dateFrom", "La fecha es obligatoria.");
        }
        if (invoiceBean.getDateTo() == null) {
            addFieldError("invoiceBean.dateTo", "La fecha es obligatoria.");
        }
    }

    private double calculateTotalAmount(double grossAmount) {
        double ivaPercentage = 0.21;
        return grossAmount * (1 + ivaPercentage);
    }
}

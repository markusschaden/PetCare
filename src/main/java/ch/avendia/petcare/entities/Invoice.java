package ch.avendia.petcare.entities;

/**
 * Created by Markus on 01.04.2015.
 */
public class Invoice extends BaseTenant {

    private ServiceExection[] services;
    private Client client;
    private Pet[] pets;
    private Payment[] payments;
    private Facility[] facilities;
    private InvoiceStatus invoiceStatus;
    private Discount[] discounts;
}

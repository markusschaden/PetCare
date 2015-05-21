package ch.avendia.petcare.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Markus on 01.04.2015.
 */
@Entity
@Data
public class Invoice extends DatabaseTenantEntity {

    //private ServiceExection[] services;

    @ManyToOne
    private Client client;

    @OneToMany(mappedBy = "invoice")
    @OrderColumn
    private Payment[] payments;

    @OneToMany(mappedBy = "invoice")
    @OrderColumn
    private Facility[] facilities;

    @Enumerated(EnumType.STRING)
    private InvoiceStatus invoiceStatus;

    @ManyToMany(targetEntity = Discount.class, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "InvoiceDiscount", joinColumns = @JoinColumn(name = "Invoice_ID"), inverseJoinColumns = @JoinColumn(name = "Discount_ID"))
    @OrderColumn
    private Discount[] discounts;

    private String invoiceId;

    @Temporal(TemporalType.TIMESTAMP)
    private Date issued;

    @Temporal(TemporalType.TIMESTAMP)
    private Date paymentDue;

    private Long discount;

    @Enumerated(EnumType.STRING)
    private DiscountType discountType;

    private long tax;

}

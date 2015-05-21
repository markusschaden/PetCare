package ch.avendia.petcare.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Markus on 01.04.2015.
 */
@Entity
@Data
public class BankTransferData extends DatabaseEntity {

    private String bankName;

    @Embedded
    private Address bankAddress;

    private String accountNumber;

    private String zugunstenVon;

    @Embedded
    private Address zugunstenVonAddress;

    private String referenzNummer;

    @OneToOne(mappedBy = "transferData")
    private Company company;
}

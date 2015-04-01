package ch.avendia.petcare.entities;

import lombok.Data;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * Created by Markus on 01.04.2015.
 */
@Data
@MappedSuperclass
public abstract class BaseTenant implements Serializable {

    private Company tenant;
}

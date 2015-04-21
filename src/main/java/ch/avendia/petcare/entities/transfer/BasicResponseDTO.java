package ch.avendia.petcare.entities.transfer;

import ch.avendia.petcare.entities.DatabaseEntity;
import lombok.Data;

/**
 * Created by Markus on 01.04.2015.
 */
@Data
public class BasicResponseDTO<T extends DatabaseEntity> {

    private Status status;
    private T data;
}
